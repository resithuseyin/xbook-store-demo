package com.xbook.xbookstore.stepdefinitions;

import com.xbook.xbookstore.pages.BookDetailsPage;
import com.xbook.xbookstore.pages.HomePage;
import com.xbook.xbookstore.pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class BookDetailsStepsDef {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private BookDetailsPage bookDetailsPage;

    public BookDetailsStepsDef() {
        // Initialize page objects
        this.homePage = new HomePage();
        this.searchResultsPage = new SearchResultsPage();
        this.bookDetailsPage = new BookDetailsPage();
    }

    @Given("the user has performed a search that includes the book titled {string}")
    public void searchForBook(String bookTitle) {
        homePage.searchForBook(bookTitle);
    }

    @When("the user clicks on the link for {string} in the search results")
    public void clickOnBookLink(String bookTitle) {
        searchResultsPage.clickOnBookLink(bookTitle);
    }

    @Then("the book details page for {string} should be displayed, showing detailed information about the book")
    public void verifyBookDetails(String bookTitle) {
        assertEquals(bookTitle, bookDetailsPage.getBookTitle());
        // Additional assertions can be added here for author and description
        // Example:
        // assertEquals("F. Scott Fitzgerald", bookDetailsPage.getBookAuthor());
        // assertEquals("A novel set in the Roaring Twenties", bookDetailsPage.getBookDescription());
    }
}
