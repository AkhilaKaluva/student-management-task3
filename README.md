# Student Management System - Task 3

## Project Overview

This project is a Spring Boot REST API for managing student records. It demonstrates CRUD operations along with unit testing, logging, and code coverage.

## Features

- Create Student
- Get All Students
- Get Student by ID
- Update Student
- Delete Student

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit 5
- Mockito
- SLF4J
- Logback
- JaCoCo
- Postman

## Testing

Unit tests are written using:

- JUnit 5
- Mockito

The project includes:

- Service layer unit tests
- Test reports
- JaCoCo code coverage report

## Code Coverage

JaCoCo is configured to generate code coverage reports.

Coverage Report Location:

```
target/site/jacoco/index.html
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /students | Create Student |
| GET | /students | Get All Students |
| GET | /students/{id} | Get Student by ID |
| PUT | /students/{id} | Update Student |
| DELETE | /students/{id} | Delete Student |

##  Testing Tool

All APIs were tested using Postman.

## Project Structure

```
src
 ├── main
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    ├── model
 │    └── resources
 └── test
      └── service
```

##  How to Run

1. Clone the repository

```
git clone https://github.com/AkhilaKaluva/student-management-task3.git
```

2. Open the project in IntelliJ IDEA.

3. Configure PostgreSQL credentials in `application.properties`.

4. Run the Spring Boot application.

##  Author

**Akhila Kaluva**
