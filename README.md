# Bookstore Automation

## Project Overview
This project provides an automation testing framework for a bookstore web application. It is built using Java, Selenium, Cucumber, JUnit, Maven, Lombok, and Rest-Assured.

## Project Structure
- **`src/test/java/com/xbook/xbookstore/pages/`**: Page Object Model classes.
- **`src/test/java/com/xbook/xbookstore/utils/`**: Utility classes.
- **`src/test/java/com/xbook/xbookstore/hooks/`**: Cucumber test hook classes.
- **`src/test/java/com/xbook/xbookstore/builders/`**: Request builders for API testing.
- **`src/test/java/com/xbook/xbookstore/models/`**: Data models for API responses.
- **`src/test/resources/features/`**: Cucumber feature files.
- **`src/test/resources/json-samples/`**: JSON schema files for API contract validation.
- **`src/test/java/com/xbook/xbookstore/stepdefinitions/`**: Cucumber step definitions.
- **`src/test/java/com/xbook/xbookstore/runners/`**: Cucumber test runner classes.

## Requirements
- JDK 21
- Maven
- WebDriver (Chrome, Firefox, etc.)
- Lombok (for reducing boilerplate code in Java classes)
- Rest-Assured (for REST API testing)

## Setup
1. Clone the repository:
    ```bash
    git clone <repo-url>
    cd xbook-store
    ```

2. Ensure JDK 21 is installed:
    ```bash
    java -version
    ```
   If JDK 21 is not installed, download and install it from [Adoptium](https://adoptium.net/) or another provider.

3. Build the project:
    ```bash
    mvn clean install
    ```
   If using Maven Wrapper, you can update it to ensure compatibility:
    ```bash
    mvn wrapper:wrapper
    ```

4. **Lombok Setup**:
   - **IntelliJ IDEA**: Ensure annotation processing is enabled via `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors`.
   - **Eclipse**: Enable annotation processing in `Project > Properties > Java Compiler > Annotation Processing`.

## Cucumber Configuration
A `cucumber.properties` file is used for Cucumber configuration. You can configure Cucumber options in this file. For example:
like cucumber.publish.enabled=false


## Running Tests
- **Web UI Tests**: Execute web UI tests with Cucumber and Selenium:
    ```bash
  mvn test -Dcucumber.filter.tags="@web_ui_test"

    ```

- **API Contract Tests**: Execute API contract tests with Rest-Assured:
    ```bash
    mvn test -Dcucumber.filter.tags="@api_test"
    ```

- **Run All Tests**: To run both web UI and API contract tests:
    ```bash
    mvn test
    ```

## File Paths
- **Feature Files**: `src/test/resources/features`
- **API Contract JSON Schemas**: `src/test/resources/json-samples`