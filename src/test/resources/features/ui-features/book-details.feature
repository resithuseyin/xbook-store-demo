@web_ui_test
Feature: View Book Details

  Background:
    Given the user is on the bookstore homepage

  Scenario: View book details
    Given the user has performed a search that includes the book titled "The Great Gatsby"
    When the user clicks on the link for "The Great Gatsby" in the search results
    Then the book details page for "The Great Gatsby" should be displayed, showing detailed information about the book
