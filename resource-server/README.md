# Resource Server

## Overview

The resource server provides protected resources and ensures that access to these resources is secure. It relies on the API server and the UAA server for API key validation and authentication.

## Features

- Protected resources
- Integration with API server for API key validation

## Endpoints

- **Protected Resource Endpoints**: These endpoints are secured and require valid authentication tokens to access.

## Running the Resource Server

1. Clone the repository.
2. Navigate to the resource server directory.
3. Build the project:
   ```bash
   ./gradlew build
4. Run the application
   ```bash
   ./gradlew bootRun
