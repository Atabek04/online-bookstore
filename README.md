# Online Book 
---
### Project Goal

The goal of this project is to create a comprehensive web application for a bookstore, providing users with an intuitive platform to browse, search, and purchase books. The application aims to streamline the book ordering process, offering an engaging user interface and efficient management of book inventory. Additionally, the project emphasizes the use of modern web technologies, design patterns, and best practices to ensure scalability, maintainability, and a delightful user experience.

### Project Description

The Bookstore Web Application is a full-fledged platform designed to offer users a seamless experience in discovering, exploring, and purchasing books online. This application leverages modern web technologies and follows best practices to deliver a robust and user-friendly solution.

#### Key Features:

1. **User Authentication and Authorization:**
    * Secure user registration and login functionality.
    * Role-based access control for different user types (e.g., customers, administrators).

2. **Book Catalog:**
    * A comprehensive catalog of books with detailed information such as title, author, price, and cover images.
    * Advanced search and filtering options to help users find specific books.

3. **Shopping Cart:**
    * Intuitive shopping cart functionality for users to add, remove, and update items before checkout.
    * Real-time calculation of the total order amount.

4. **Order Management:**
    * Order history for registered users, allowing them to track their purchase history.
    * Admin dashboard for managing and processing orders.

5. **Responsive Design:**
    * Ensures a consistent and enjoyable user experience across various devices, including desktops, tablets, and smartphones.

6. **Integration with External Services:**
    * Seamless integration with payment gateways for secure and reliable transactions.
    * Utilization of external APIs for features such as book recommendations or reviews.

7. **Backend Administration:**
    * Easy management of book inventory, including adding new books and updating existing entries.
    * Dashboard for monitoring sales, customer interactions, and other relevant metrics.

8. **Scalability and Maintainability:**
    * Implementation of design patterns such as Singleton, Factory Method, and Dependency Injection for scalable and maintainable code.

### Technologies Used: 
* **Backend:** Java with Spring MVC for web architecture.
* **Frontend:** HTML, CSS, JavaScript, and Thymeleaf for dynamic templating.
* **Database:** PostgreSQL for storing book and order information.
* **Other Tools:** Maven for project management, Bootstrap for responsive design.    

## Design Patterns Used

The project incorporates the following design patterns:

1. **Singleton Pattern:**
    - **Usage:** In the `Postgres` class, you implemented a basic form of the Singleton pattern to ensure that only one instance of the Connection is created and reused.
    - **Example:**
    ```java
    public class DbConnector {
    private static Connection connection;
        private DbConnector() {
            // private constructor to restrict instantiation
        }
        public static Connection getConnection() {
            if (connection == null) {
                // create a new connection if it doesn't exist
                connection = DriverManager.getConnection(url, username, password);
            }
            return connection;
        }
    }
    ```

2. **Factory Method Pattern:**
    - **Usage:**  In the Spring MVC configuration (`SpringConfig` class), you used factory methods to create instances of `SpringResourceTemplateResolve`r and `ThymeleafViewResolver`.
    - **Example:**
    ```java
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        // configure the template resolver
        return templateResolver;
    }
    
    @Bean
    public ThymeleafViewResolver resolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        // configure the view resolver
        return resolver;
    }
    ```

3. **Dependency Injection (DI) Pattern:**
    - **Usage:** Throughout the code, you utilized Spring's dependency injection by annotating constructors with `@Autowired` and defining beans in the configuration class (`SpringConfig`).
    - **Example:**
    ```java
    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    ```
    
4. **Repository Pattern:**
    - **Usage:** In the `BookRepo` and `OrderRepo` interfaces, you defined methods to interact with the underlying data storage. This pattern abstracts the data access and provides a clean separation between the business logic and data access logic.
    - **Example:**
    ```java
    public interface BookRepo {
    List<Book> getAllBooks();
    Book getBookById(int id);
    // other methods...
    }
    
    public interface OrderRepository extends CrudRepository<Order, Long> {
        // methods...
    }
    ```
