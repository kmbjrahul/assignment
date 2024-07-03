# UAA Server

## Overview

The UAA (User Account and Authentication) server is responsible for managing user authentication and providing API key validation services. It is a crucial component for securing access to other services in the system.

## Features

- User authentication
- API key validation
- Token generation

## Endpoints

### `/authenticate`

- **Description**: Validates the provided API key and generates an internal token.
- **Method**: GET
- **Parameters**:
    - `apiKey`: The API key to be authenticated
- **Responses**:
    - `200 OK`: Returns `internal-token` if the API key is valid.
    - `200 OK`: Returns `invalid-api-key` if the API key is invalid.

## Running the UAA Server

1. Clone the repository.
2. Navigate to the UAA server directory.
3. Build the project:
   ```bash
   ./gradlew build
4. Run the application
   ```bash
   ./gradlew bootRun
### Test Cases

The project includes automated tests to ensure the functionality and integration of the UAA server's `ApiKeyValidationController`.

### Note: Assumption of Operational API Server for Integration Test Cases

These integration test cases assume that the API server is operational in the backend. The tests are designed to verify the functionality and integration of the UAA server's `ApiKeyValidationController` with the API server. It is expected that the API server responds correctly to requests made by the UAA server during the execution of these tests.


#### MockMvc-based Tests

- `ApiKeyValidationControllerMockMvcTest.java`: Tests using MockMvc to validate API keys against the external authentication provider.
    - Include specific test method descriptions and expected outcomes.

#### Integration Tests with TestRestTemplate

- `ApiKeyValidationControllerIntegrationTest.java`: Integration tests using TestRestTemplate to verify the behavior of `ApiKeyValidationController` with a running server instance.
    - Describe test scenarios, such as validating valid and invalid API keys.

These tests verify the correct functioning of the UAA server's API key validation process and ensure seamless integration with the external authentication provider.
