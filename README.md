# Project Fridge (Spring Boot with Docker)

Project Fridge is a simple web application built with Spring Boot to manage a virtual refrigerator, allowing users to add, store, and track food items. This project serves as a practical exercise in developing RESTful APIs, integrating with databases, and containerizing applications using Docker.

### Requirements
Before running this project, ensure you have the following tools installed:
- **Java JDK 17+** – required to compile and run the Spring Boot application
- **Maven** – for building and managing dependencies
- **Git** – to clone the repository (optional, can also download manually)
- **Docker** – to run the application in a containerized environment
- **IDE**: IntelliJ IDEA, Eclipse, or VSCode with Java and Docker extensions

### Technologies Used
- **Spring Boot** – for building the RESTful API and managing the application
- **Spring Data JPA** – for database operations with Hibernate
- **H2 Database** – an in-memory database for development and testing
- **Docker** – for containerizing the application
- **Maven** – for dependency management and building the project
- Core Java libraries for basic functionality

### Features
- Add food items with name, quantity, and expiration date via REST API
- Retrieve a list of all stored food items
- Persist data in an in-memory H2 database (resets on container restart)
- Containerized deployment using Docker for easy setup
- Error handling for invalid inputs or database issues

### How to Install and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/seu-usuario/projectFridge.git
   cd projectFridge
   ```

2. Build the project with Maven:
   ```bash
   mvn clean install
   ```

3. Run the application using Docker:
   ```bash
   docker-compose up --build
   ```
   - Ensure Docker Desktop is running.
   - The application will be available at `http://localhost:8080/api/food`.

4. Test the API (e.g., using Postman or cURL):
   - **POST `http://localhost:8080/api/food`** with body:
     ```json
     {
         "name": "Apple",
         "quantity": 5,
         "expirationDate": 30
     }
     ```
   - **GET `http://localhost:8080/api/food`** to list all items.

### How It Works
- **`ProjectFridgeApplication.java`**: Main class that boots the Spring Boot application.
- **`FoodController.java`**: Handles REST endpoints for adding and retrieving food items.
- **`FoodRepository.java`**: Provides JPA repository interface for database operations.
- **`Food.java`**: Entity class defining the structure of food items.
- **`Dockerfile`**: Defines the container image with JDK 17 and Maven to build the app.

### What I Learned
- How to build a RESTful API with Spring Boot
- Integrating a database (H2) with Spring Data JPA
- Containerizing a Java application using Docker
- Managing dependencies and building projects with Maven
- Debugging and resolving port conflicts and database connection issues
- Basic version control with Git and deployment to GitHub

## License
This project is licensed under the MIT License.
