@api_test
Feature: Search Books API Contract

  Scenario: Validate the response of Search Books API
    Given the API is available at "http://base-url"
    When I search for books with the title "someTitle"
    Then the response should match the search-books schema
