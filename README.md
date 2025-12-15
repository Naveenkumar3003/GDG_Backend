# 🍽️ College Canteen Menu Management API

## 📋 Project Overview

This is a RESTful API for managing menu items in a college canteen system, developed as part of the **GDG on Campus Backend Volunteer Selection Task**. The application allows canteen admins to perform CRUD (Create, Read, Update, Delete) operations on food items with comprehensive validation and error handling.

**Developer:** [Naveenkumar N]  
**Email:** [naveennkumar0312@gmail.com]  
**GitHub:** [https://github.com/Naveenkumar3003/GDG_Backend]  
**Submission Date:** December 15, 2025
**GDrive Link:** [https://drive.google.com/drive/folders/1r-9XeqelNfFKUhEaGT9s0Sj4H4RTncD_?usp=sharing]
---

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17 | Programming Language |
| **Spring Boot** | 3.2.0 | Application Framework |
| **Spring Data JPA** | 3.2.0 | Database Operations |
| **H2 Database** | 2.2.224 | In-Memory Database |
| **Maven** | 3.9+ | Build Tool |
| **Lombok** | 1.18.30 | Reduce Boilerplate Code |
| **Jakarta Validation** | 3.0.2 | Input Validation |

---

## 🏗️ Project Architecture

This project follows a **layered architecture pattern** with clear separation of concerns:
```
┌─────────────────────────────────────────┐
│         Controller Layer                │  ← REST Endpoints
│    (MenuItemController.java)            │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Service Layer                   │  ← Business Logic
│  (MenuItemService + ServiceImpl)        │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│       Repository Layer                  │  ← Database Access
│    (MenuItemRepository.java)            │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Entity Layer                    │  ← Database Model
│       (MenuItem.java)                   │
└─────────────────────────────────────────┘

      ┌──────────────────────┐
      │   DTO Layer          │  ← Data Transfer
      │  Request/Response    │
      └──────────────────────┘

      ┌──────────────────────┐
      │  Exception Layer     │  ← Error Handling
      │  Global Handler      │
      └──────────────────────┘
```

---

## 📁 Project Structure
```
canteen-menu-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── gdg/
│   │   │           └── canteen/
│   │   │               ├── CanteenMenuApplication.java          # Main Application
│   │   │               ├── controller/
│   │   │               │   └── MenuItemController.java          # REST Endpoints
│   │   │               ├── service/
│   │   │               │   ├── MenuItemService.java             # Service Interface
│   │   │               │   └── MenuItemServiceImpl.java         # Service Implementation
│   │   │               ├── repository/
│   │   │               │   └── MenuItemRepository.java          # JPA Repository
│   │   │               ├── entity/
│   │   │               │   └── MenuItem.java                    # Entity Model
│   │   │               ├── dto/
│   │   │               │   ├── MenuItemRequestDTO.java          # Request DTO
│   │   │               │   └── MenuItemResponseDTO.java         # Response DTO
│   │   │               └── exception/
│   │   │                   ├── GlobalExceptionHandler.java      # Error Handler
│   │   │                   ├── MenuItemNotFoundException.java   # Custom Exception
│   │   │                   └── ErrorResponse.java               # Error Model
│   │   └── resources/
│   │       └── application.properties                           # Configuration
│   └── test/
│       └── java/
│           └── com/
│               └── gdg/
│                   └── canteen/
│                       └── CanteenMenuApplicationTests.java     # Unit Tests
├── .gitignore                                                   # Git Ignore Rules
├── pom.xml                                                      # Maven Dependencies
├── mvnw                                                         # Maven Wrapper (Unix)
├── mvnw.cmd                                                     # Maven Wrapper (Windows)
└── README.md                                                    # This File
```

---

## 🚀 Setup Instructions

### Prerequisites

Before you begin, ensure you have the following installed:

- ☑️ **Java 17 or higher** - [Download JDK](https://www.oracle.com/java/technologies/downloads/)
- ☑️ **Maven 3.6+** - [Download Maven](https://maven.apache.org/download.cgi) (or use included wrapper)
- ☑️ **Git** - [Download Git](https://git-scm.com/downloads)
- ☑️ **IDE** (Optional but recommended):
  - IntelliJ IDEA
  - Eclipse
  - VS Code with Java extensions

### Verify Java Installation
```bash
java -version
# Expected output: java version "17.0.x" or higher
```

---

### Installation Steps

#### **Step 1: Clone the Repository**
```bash
git clone https://github.com/yourusername/canteen-menu-api.git
cd canteen-menu-api
```

#### **Step 2: Build the Project**

Using Maven Wrapper (Recommended):
```bash
# Windows
mvnw.cmd clean install

# Mac/Linux
./mvnw clean install
```

Using System Maven:
```bash
mvn clean install
```

**Expected Output:**
```
[INFO] BUILD SUCCESS
[INFO] Total time: XX.XXX s
```

#### **Step 3: Run the Application**

Using Maven Wrapper:
```bash
# Windows
mvnw.cmd spring-boot:run

# Mac/Linux
./mvnw spring-boot:run
```

Using System Maven:
```bash
mvn spring-boot:run
```

**Expected Console Output:**
```
=================================
Canteen Menu API is running!
Access at: http://localhost:8080
H2 Console: http://localhost:8080/h2-console
=================================
```

#### **Step 4: Verify Installation**

Open your browser or use cURL:
```bash
curl http://localhost:8080/api/items
```

**Expected Response:**
```json
[]
```

---

## 🌐 Accessing the Application

### API Base URL
```
http://localhost:8080/api/items
```

### H2 Database Console
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:canteendb
Username: sa
Password: (leave blank)
```

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080/api/items
```

---

### 🔹 **1. Create Menu Item**

Create a new food item in the canteen menu.

**Endpoint:** `POST /api/items`

**Request Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Masala Dosa",
  "price": 45.00,
  "category": "Breakfast",
  "availability": true
}
```

**Validation Rules:**
- `name`: Required, 2-100 characters
- `price`: Required, must be positive (> 0)
- `category`: Required, must be one of: `Breakfast`, `Lunch`, `Dinner`, `Snacks`, `Drinks`, `Desserts`
- `availability`: Required, boolean value

**Success Response:** `201 Created`
```json
{
  "id": 1,
  "name": "Masala Dosa",
  "price": 45.00,
  "category": "Breakfast",
  "availability": true
}
```

**Error Response:** `400 Bad Request`
```json
{
  "timestamp": "2025-12-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Invalid input data",
  "path": "/api/items",
  "details": [
    "Name is required",
    "Price must be greater than 0"
  ]
}
```

**cURL Example:**
```bash
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Masala Dosa",
    "price": 45.00,
    "category": "Breakfast",
    "availability": true
  }'
```

---

### 🔹 **2. Get All Menu Items**

Retrieve all menu items from the canteen.

**Endpoint:** `GET /api/items`

**Success Response:** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Masala Dosa",
    "price": 45.00,
    "category": "Breakfast",
    "availability": true
  },
  {
    "id": 2,
    "name": "Coffee",
    "price": 20.00,
    "category": "Drinks",
    "availability": true
  },
  {
    "id": 3,
    "name": "Samosa",
    "price": 15.00,
    "category": "Snacks",
    "availability": false
  }
]
```

**Empty Response:** `200 OK`
```json
[]
```

**cURL Example:**
```bash
curl -X GET http://localhost:8080/api/items
```

---

### 🔹 **3. Update Menu Item**

Update an existing menu item by ID.

**Endpoint:** `PUT /api/items/{id}`

**Path Parameter:**
- `id` - The ID of the menu item to update

**Request Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Special Masala Dosa",
  "price": 55.00,
  "category": "Breakfast",
  "availability": true
}
```

**Success Response:** `200 OK`
```json
{
  "id": 1,
  "name": "Special Masala Dosa",
  "price": 55.00,
  "category": "Breakfast",
  "availability": true
}
```

**Error Response:** `404 Not Found`
```json
{
  "timestamp": "2025-12-15T10:35:00",
  "status": 404,
  "error": "Not Found",
  "message": "Menu item not found with id: 999",
  "path": "/api/items/999"
}
```

**cURL Example:**
```bash
curl -X PUT http://localhost:8080/api/items/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Special Masala Dosa",
    "price": 55.00,
    "category": "Breakfast",
    "availability": true
  }'
```

---

### 🔹 **4. Delete Menu Item**

Delete a menu item by ID.

**Endpoint:** `DELETE /api/items/{id}`

**Path Parameter:**
- `id` - The ID of the menu item to delete

**Success Response:** `204 No Content`
```
(Empty response body)
```

**Error Response:** `404 Not Found`
```json
{
  "timestamp": "2025-12-15T10:40:00",
  "status": 404,
  "error": "Not Found",
  "message": "Menu item not found with id: 999",
  "path": "/api/items/999"
}
```

**cURL Example:**
```bash
curl -X DELETE http://localhost:8080/api/items/1
```

---

## 🛡️ Error Handling

The API implements comprehensive error handling with standardized error responses.

### Error Response Format

All errors follow this structure:
```json
{
  "timestamp": "2025-12-15T10:30:00",
  "status": 400,
  "error": "Error Type",
  "message": "Human-readable error message",
  "path": "/api/items",
  "details": ["Additional error details (optional)"]
}
```

---

### Error Types

#### **1. Validation Errors (400 Bad Request)**

Occurs when input data fails validation.

**Common Scenarios:**
- Missing required fields
- Invalid data types
- Constraint violations (price ≤ 0)
- Invalid category values

**Example:**
```json
{
  "timestamp": "2025-12-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Invalid input data",
  "path": "/api/items",
  "details": [
    "Name is required",
    "Price must be greater than 0",
    "Category must be one of: Breakfast, Lunch, Dinner, Snacks, Drinks, Desserts"
  ]
}
```

---

#### **2. Resource Not Found (404 Not Found)**

Occurs when requested menu item doesn't exist.

**Example:**
```json
{
  "timestamp": "2025-12-15T10:35:00",
  "status": 404,
  "error": "Not Found",
  "message": "Menu item not found with id: 999",
  "path": "/api/items/999"
}
```

---

#### **3. Internal Server Error (500)**

Occurs when an unexpected error happens on the server.

**Example:**
```json
{
  "timestamp": "2025-12-15T10:40:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "An unexpected error occurred",
  "path": "/api/items"
}
```

---

## 🧪 Testing the API

### Using cURL

#### **Test 1: Create Multiple Items**
```bash
# Create Masala Dosa
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Masala Dosa",
    "price": 45.00,
    "category": "Breakfast",
    "availability": true
  }'

# Create Coffee
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Coffee",
    "price": 20.00,
    "category": "Drinks",
    "availability": true
  }'

# Create Samosa
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Samosa",
    "price": 15.00,
    "category": "Snacks",
    "availability": true
  }'
```

#### **Test 2: Get All Items**
```bash
curl -X GET http://localhost:8080/api/items
```

#### **Test 3: Update Item**
```bash
curl -X PUT http://localhost:8080/api/items/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Special Masala Dosa",
    "price": 55.00,
    "category": "Breakfast",
    "availability": true
  }'
```

#### **Test 4: Delete Item**
```bash
curl -X DELETE http://localhost:8080/api/items/1
```

#### **Test 5: Test Validation Error**
```bash
# Missing name field
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{
    "price": 45.00,
    "category": "Breakfast",
    "availability": true
  }'
```

#### **Test 6: Test Not Found Error**
```bash
curl -X GET http://localhost:8080/api/items/999
```

---

### Using Postman

1. **Import Collection** (optional)
2. **Set Base URL:** `http://localhost:8080/api/items`
3. **Create Requests** for each endpoint
4. **Test all CRUD operations**
5. **Test error scenarios**

---

## 🎯 Design Approach & Architecture Decisions

### **1. Layered Architecture**

The application follows a clean layered architecture pattern:

**Benefits:**
- ✅ Clear separation of concerns
- ✅ Easy to test each layer independently
- ✅ Maintainable and scalable
- ✅ Follows Spring Boot best practices

**Layers:**
1. **Controller Layer** - Handles HTTP requests/responses
2. **Service Layer** - Contains business logic
3. **Repository Layer** - Manages database operations
4. **Entity Layer** - Represents database tables
5. **DTO Layer** - Data transfer between layers
6. **Exception Layer** - Centralized error handling

---

### **2. DTO Pattern**

**Why DTOs?**
- ✅ Decouples API contracts from entity models
- ✅ Allows different validation rules for requests/responses
- ✅ Prevents exposing internal entity structure
- ✅ Enables API versioning without affecting database

**Implementation:**
- `MenuItemRequestDTO` - For incoming data (with validation)
- `MenuItemResponseDTO` - For outgoing data (clean response)

---

### **3. Service Interface Pattern**

**Why Interfaces?**
- ✅ Better testability (can mock easily)
- ✅ Flexibility to change implementations
- ✅ Follows Dependency Inversion Principle
- ✅ Enables multiple implementations if needed

---

### **4. Global Exception Handling**

**Why @RestControllerAdvice?**
- ✅ Centralized error handling
- ✅ Consistent error response format
- ✅ Reduces boilerplate code in controllers
- ✅ Easier to maintain and extend

**Handled Exceptions:**
- Custom exceptions (MenuItemNotFoundException)
- Validation exceptions (MethodArgumentNotValidException)
- Generic exceptions (Exception)

---

### **5. Input Validation**

**Why Jakarta Bean Validation?**
- ✅ Declarative validation with annotations
- ✅ Automatic validation before method execution
- ✅ Clean and readable code
- ✅ Comprehensive error messages

**Validation Annotations Used:**
- `@NotBlank` - String cannot be null or empty
- `@NotNull` - Value cannot be null
- `@Positive` - Number must be > 0
- `@Size` - String length constraints
- `@Pattern` - Regex validation for categories

---

### **6. RESTful Design**

**HTTP Methods:**
- `POST` - Create new resource
- `GET` - Retrieve resources
- `PUT` - Update existing resource
- `DELETE` - Remove resource

**HTTP Status Codes:**
- `200 OK` - Successful GET/PUT
- `201 Created` - Successful POST
- `204 No Content` - Successful DELETE
- `400 Bad Request` - Validation error
- `404 Not Found` - Resource not found
- `500 Internal Server Error` - Server error

---

## 📊 Database Schema

### Menu Item Table
```sql
CREATE TABLE menu_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    category VARCHAR(50) NOT NULL,
    availability BOOLEAN NOT NULL
);
```

**Fields:**
| Field | Type | Constraints | Description |
|-------|------|-------------|-------------|
| id | Long | Primary Key, Auto-increment | Unique identifier |
| name | String | Not Null, 2-100 chars | Item name |
| price | Double | Not Null, > 0 | Item price |
| category | String | Not Null, Enum values | Category type |
| availability | Boolean | Not Null | Availability status |

**Valid Categories:**
- Breakfast
- Lunch
- Dinner
- Snacks
- Drinks
- Desserts

---

## 🔧 Configuration

### application.properties
```properties
# Application Name
spring.application.name=canteen-menu-api

# Server Configuration
server.port=8080

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:canteendb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Logging
logging.level.com.gdg.canteen=DEBUG
logging.level.org.springframework.web=INFO
```

---

## 📦 Dependencies

### Core Dependencies
```xml
<!-- Spring Boot Web Starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Boot Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Spring Boot Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- Spring Boot Test -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

---

## ✅ Features Implemented

### Core Features
- ✅ Complete CRUD operations for menu items
- ✅ RESTful API design with proper HTTP methods
- ✅ Input validation with Bean Validation
- ✅ Custom exception handling
- ✅ DTO pattern for data transfer
- ✅ Service layer with interface
- ✅ JPA repository for database operations
- ✅ H2 in-memory database

### Code Quality
- ✅ Clean code structure with proper packaging
- ✅ Meaningful variable and method names
- ✅ Proper use of annotations
- ✅ Lombok for reducing boilerplate
- ✅ Comments and documentation

### Error Handling
- ✅ Global exception handler
- ✅ Structured error responses
- ✅ Validation error messages
- ✅ Not found error handling
- ✅ Proper HTTP status codes

### Documentation
- ✅ Comprehensive README
- ✅ API documentation with examples
- ✅ Setup instructions
- ✅ Testing guide
- ✅ Architecture explanation

---

## 🚦 HTTP Status Codes Reference

| Status Code | Meaning | When Used |
|-------------|---------|-----------|
| 200 OK | Success | GET, PUT operations |
| 201 Created | Resource created | POST operation |
| 204 No Content | Success, no body | DELETE operation |
| 400 Bad Request | Invalid input | Validation errors |
| 404 Not Found | Resource not found | Item doesn't exist |
| 500 Internal Server Error | Server error | Unexpected errors |

---

## 🔍 Troubleshooting

### Issue 1: Port 8080 Already in Use

**Error:**
```
Web server failed to start. Port 8080 was already in use.
```

**Solution:**
```properties
# Change port in application.properties
server.port=8081
```

Or kill the process using port 8080:
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Mac/Linux
lsof -i :8080
kill -9 <PID>
```

---

### Issue 2: Lombok Not Working

**Error:**
```
Cannot resolve symbol 'getData' or 'setData'
```

**Solution:**
1. **IntelliJ IDEA:**
   - File → Settings → Plugins
   - Search "Lombok" → Install
   - Restart IDE

2. **Eclipse:**
   - Download lombok.jar
   - Run: `java -jar lombok.jar`
   - Follow installer

3. **VS Code:**
   - Install "Lombok Annotations Support" extension

---

### Issue 3: Database Not Accessible

**Solution:**
1. Check H2 console is enabled in `application.properties`
2. Access: `http://localhost:8080/h2-console`
3. Use JDBC URL: `jdbc:h2:mem:canteendb`
4. Username: `sa`, Password: (empty)

---

### Issue 4: Maven Build Fails

**Solution:**
```bash
# Clean and rebuild
mvn clean install -U

# Skip tests if needed
mvn clean install -DskipTests
```

---

### Issue 5: Application Won't Start

**Check:**
1. Java version is 17 or higher
2. No other application on port 8080
3. All dependencies downloaded
4. No syntax errors in code

**Clean start:**
```bash
mvn clean
mvn install
mvn spring-boot:run
```

---

## 📝 Sample Test Data

Use this data to populate your database for testing:
```bash
# Item 1: Masala Dosa
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Masala Dosa","price":45.0,"category":"Breakfast","availability":true}'

# Item 2: Idli
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Idli (3 pcs)","price":30.0,"category":"Breakfast","availability":true}'

# Item 3: Coffee
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Coffee","price":20.0,"category":"Drinks","availability":true}'

# Item 4: Tea
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Tea","price":15.0,"category":"Drinks","availability":true}'

# Item 5: Samosa
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Samosa","price":15.0,"category":"Snacks","availability":true}'

# Item 6: Vada Pav
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Vada Pav","price":25.0,"category":"Snacks","availability":false}'

# Item 7: Biryani
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Veg Biryani","price":80.0,"category":"Lunch","availability":true}'

# Item 8: Thali
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Special Thali","price":100.0,"category":"Lunch","availability":true}'
```

---

## 🎓 Learning Outcomes

Through this project, I learned and implemented:

### Technical Skills
- ✅ Building RESTful APIs with Spring Boot
- ✅ Implementing CRUD operations
- ✅ Using Spring Data JPA for database operations
- ✅ Input validation with Bean Validation
- ✅ Exception handling with @RestControllerAdvice
- ✅ DTO pattern for clean architecture
- ✅ Maven dependency management
- ✅ H2 in-memory database configuration

### Best Practices
- ✅ Layered architecture pattern
- ✅ Separation of concerns
- ✅ RESTful API design principles
- ✅ Proper HTTP status code usage
- ✅ Meaningful error messages
- ✅ Clean code principles
- ✅ Proper project structure
- ✅ Comprehensive documentation

### Tools & Frameworks
- ✅ Spring Boot framework
- ✅ Spring Data JPA
- ✅ Hibernate ORM
- ✅ Maven build tool
- ✅ Lombok annotations
- ✅ Jakarta Bean Validation
- ✅ Git version control
- ✅ Postman/cURL for API testing

---

## 🚀 Future Enhancements

Potential features for future development:

1. **Authentication & Authorization**
   - JWT-based authentication
   - Role-based access control (Admin, User)

2. **Advanced Filtering**
   - Search by name
   - Filter by category
   - Filter by availability
   - Price range filtering

3. **Pagination**
   - Pageable responses for GET all items
   - Sorting options

4. **Image Upload**
   - Add food item images
   - Image storage and retrieval

5. **Order Management**
   - Place orders for menu items
   - Order history
   - Order status tracking

6. **Database**
   - Switch to PostgreSQL/MySQL
   - Database migrations with Flyway/Liquibase

7. **Testing**
   - Unit tests for service layer
   - Integration tests for APIs
   - Test coverage reports

8. **API Documentation**
   - Swagger/OpenAPI integration
   - Interactive API documentation

9. **Monitoring**
   - Spring Boot Actuator
   - Health checks
   - Metrics and monitoring

---

## 📞 Contact & Support

**Developer:** [Naveenkumar N]  
**Email:** [naveennkumar0312@gmail.com]  
**GitHub:** [https://github.com/Naveenkumar3003]  
**LinkedIn:** [https://www.linkedin.com/in/naveen-kumar-15b7b7343/]

**GDrive Link:** [https://drive.google.com/drive/folders/1r-9XeqelNfFKUhEaGT9s0Sj4H4RTncD_?usp=sharing]

For questions or issues, please:
1. Check the Troubleshooting section
2. Review the API documentation
3. Open an issue on GitHub
4. Contact via email

---

## 🙏 Acknowledgments

- **GDG on Campus** - For providing this learning opportunity
- **Spring Boot Team** - For the excellent framework
- **Anthropic** - For guidance and support

---

## 📄 License

This project was created for educational purposes as part of the GDG on Campus Backend Volunteer Selection Task.

---

## 📚 References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Jakarta Bean Validation](https://beanvalidation.org/)
- [RESTful API Design](https://restfulapi.net/)
- [Maven Documentation](https://maven.apache.org/guides/)

---

---
**Thank you for reviewing my submission! 🚀**

**Made with ❤️ for GDG on Campus**

---

*Last Updated: December 15, 2025*
