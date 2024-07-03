# API Server

## Overview

The API server provides APIs for various functionalities. It interacts with the UAA server to validate API keys and secure access to its endpoints.

## Features

- API key validation
- Secure endpoints

## Endpoints

### `/validate-api-key`

- **Description**: Validates the provided API key by communicating with the UAA server.
- **Method**: GET
- **Parameters**:
  - `apiKey`: The API key to be validated
- **Responses**:
  - `200 OK`: Returns the response from the UAA server.

## Running the API Server

1. Clone the repository.
2. Navigate to the API server directory.
3. Build the project:
   ```bash
   ./gradlew build
4. Run the application
   ```bash
   ./gradlew bootRun


### Test Cases

The project includes automated tests to ensure the correctness of API key authentication using different approaches:

#### MockMvc-based Tests

- `ApiKeyAuthControllerUnderlyingHttpStructTest.java`: Tests the `/authenticate` endpoint with different scenarios using MockMvc.
    - `shouldReturnValidApiToken`: Verifies a valid API key returns an "internal-token".
    - `shouldReturnInvalidApiToken`: Verifies an invalid API key returns "invalid-api-key".
    - `shouldReturn400`: Verifies a missing API key returns HTTP status code 400.

#### Integration Tests with TestRestTemplate

- `ApiKeyAuthControllerTest.java`: Tests the `/authenticate` endpoint using TestRestTemplate with a running server instance.
    - `testAuthenticate_validApiKey`: Verifies a valid API key returns an "internal-token".
    - `testAuthenticate_invalidApiKey`: Verifies an invalid API key returns "invalid-api-key".
    - `testAuthenticate_noApiKey`: Verifies a missing API key returns HTTP status code 403.

These tests are crucial for validating the API key authentication behavior across different testing approaches. They can be executed using a suitable IDE or build tool like Maven (`mvn test`).