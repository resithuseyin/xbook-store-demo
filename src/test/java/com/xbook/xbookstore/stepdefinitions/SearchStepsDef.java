package com.xbook.xbookstore.stepdefinitions;

import com.xbook.xbookstore.pages.HomePage;
import com.xbook.xbookstore.pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class SearchStepsDef {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    public SearchStepsDef() {
        // Initialize page objects
        this.homePage = new HomePage();
        this.searchResultsPage = new SearchResultsPage();
    }

    @Given("the user is on the bookstore homepage")
    public void userIsOnHomepage() {
        homePage.navigateToHomePage();
    }

    @When("the user searches for a book by entering a title {string} and clicking the search button")
    public void searchForBooks(String bookTitle) {
        homePage.searchForBook(bookTitle);
    }

    @Then("the search results should include the book with the title {string}")
    public void verifySearchResults(String bookTitle) {
        assertTrue(searchResultsPage.isBookInSearchResults(bookTitle));
    }
}
