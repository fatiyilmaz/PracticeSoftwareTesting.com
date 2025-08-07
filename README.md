#  PracticeSoftwareTesting.com - API Automation Test Suite

##  Technologies & Tools

- Java
- Maven
- RestAssured (for API testing)
- Cucumber (BDD-style scenarios)
- JUnit (assertions)
- Jackson (JSON binding)
- Git & GitHub

###  Prerequisites

- Java JDK installed (Java 8+)
- Maven installed
- Internet access to connect to the API

## 📁 Project Structure

PracticeSoftwareTesting.com/
├── src
│   └── test
│       ├── java
│       │   ├── baseURL/              # Base API configuration
│       │   ├── request/              # Request POJOs (CreatedMessage)
│       │   ├── response/             # Response POJOs (ResponseCreatedMessage)
│       │   └── stepdefinitions/      # Cucumber step definitions
│       └── resources
│           └── features/             # .feature files for scenarios
├── configuration.properties          # API base URL & other configs
├── pom.xml                           # Maven dependencies and project setup
└── README.md                         # Project documentation
