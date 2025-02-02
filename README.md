Estuate-assignemnt
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
DATING SUGGESTION
Overview
The dating recommendation engine uses a Spring Boot REST API to manage user profiles and match them based on gender, age, and shared interests. The API allows users to register, input their details, and receive recommended matches. It applies a ranking system where opposite gender, closest age, and common interests are prioritized. The backend processes user data, calculates relevance scores, and returns the best possible matches via API responses.
Project Structure

1.Application Entry Point
TestApplication
Package: com.estuate.Test
Description: The main entry point of the application.
Functionality: Bootstraps the Spring Boot application.


2.Controller
UserController
Package: com.estuate.Test.controller
Description: Handles HTTP requests for User matching operations.
Endpoints:
POST /users:used to save the user data
GET /users/{id}: Fetches mathing data of current user

Dependencies

Spring Boot: Application framework.
Spring Data JPA: Database interaction.
MySQL Connector: Connection for Database.
Jakarta Persistence: Entity management.

How to Run

1.Clone the repository.

Set up a MySQL database and populate the necessary data and update application.properties with connection details.

2.Build the project using Maven:

mvn clean install

3.Run the application:

mvn spring-boot:run

Access the API endpoints at http://localhost:8085/users/{id}.
