package com.xbook.xbookstore.stepdefinitions;

import com.networknt.schema.ValidationMessage;
import com.xbook.xbookstore.builders.RequestBuilder;
import com.xbook.xbookstore.models.Book;
import com.xbook.xbookstore.models.Books;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import org.junit.Assert;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApiContractStepDef {

    private Response response;
    private Books booksResponse;
    private Book bookResponse;

    private static final Map<String, JsonSchema> schemaCache = new ConcurrentHashMap<>();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

    @Given("the API is available at {string}")
    public void the_api_is_available_at(String baseUri) {
        new RequestBuilder().setBaseUri(baseUri);
    }

    @When("I search for books with the title {string}")
    public void i_search_for_books_with_the_title(String title) {
        RequestBuilder requestBuilder = new RequestBuilder()
                .setBasePath("/api/books")
                .addQueryParam("title", title)
                .setMethod("GET");

        response = requestBuilder.sendRequest();
        booksResponse = response.as(Books.class); // Deserialize response
    }

    @When("I get details of the book with ID {string}")
    public void i_get_details_of_the_book_with_ID(String id) {
        RequestBuilder requestBuilder = new RequestBuilder()
                .setBasePath("/api/books/" + id)
                .setMethod("GET");

        response = requestBuilder.sendRequest();
        bookResponse = response.as(Book.class); // Deserialize response
    }

    @Then("the response should match the search-books schema")
    public void the_response_should_match_the_search_books_schema() throws Exception {
        JsonSchema schema = loadSchema("search-books-schema.json");
        validateResponseAgainstSchema(booksResponse, schema);
    }

    @Then("the response should match the book-details schema")
    public void the_response_should_match_the_book_details_schema() throws Exception {
        JsonSchema schema = loadSchema("book-details-schema.json");
        validateResponseAgainstSchema(bookResponse, schema);
    }

    private static JsonSchema loadSchema(String schemaFileName) throws Exception {
        return schemaCache.computeIfAbsent(schemaFileName, fileName -> {
            try (InputStream schemaStream = ApiContractStepDef.class.getClassLoader().getResourceAsStream("json-samples/" + fileName)) {
                if (schemaStream == null) {
                    throw new IllegalArgumentException("Schema file not found: " + fileName);
                }

                JsonNode schemaNode = mapper.readTree(schemaStream);
                return schemaFactory.getSchema(schemaNode);
            } catch (Exception e) {
                throw new RuntimeException("Error loading schema: " + fileName, e);
            }
        });
    }


    private void validateResponseAgainstSchema(Object responseModel, JsonSchema schema) {
        try {
            JsonNode responseNode = mapper.valueToTree(responseModel);
            Set<ValidationMessage> validationMessages = schema.validate(responseNode);

            // Convert Set<ValidationMessage> to List<String>
            List<String> validationErrors = validationMessages.stream()
                    .map(ValidationMessage::getMessage)
                    .toList();

            // Assert that there are no validation errors
            Assert.assertTrue("API response does not match the schema. Errors: " + validationErrors, validationErrors.isEmpty());
        } catch (Exception e) {
            throw new RuntimeException("Error validating response against schema", e);
        }
    }
}
