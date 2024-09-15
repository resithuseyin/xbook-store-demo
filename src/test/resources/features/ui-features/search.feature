@web_ui_test
Feature: Search for Books

  Background:
    Given the user is on the bookstore homepage

  Scenario: Search for a book
    When the user searches for a book by entering a title "The Great Gatsby" and clicking the search button
    Then the search results should include the book with the title "The Great Gatsby"
