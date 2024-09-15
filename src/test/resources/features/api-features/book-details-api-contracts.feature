@api_test
Feature: Get Book Details API Contract

  Scenario: Validate the response of Get Book Details API
    Given the API is available at "http://localhost:8080"
    When I get details of the book with ID "1"
    Then the response should match the book-details schema
