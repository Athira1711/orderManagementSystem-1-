# orderManagementSystem-1-

The Order Management System is designed to streamline the process of managing customer orders efficiently. It provides functionalities for adding, deleting, and viewing orders. The system helps maintain an organized record of all orders by storing essential details such as order ID, customer name, order date, total amount, and order status.

folders inside:
    WORKSPACE/ordermanager/src/main/java/com/example:

Order Entity: The Order entity represents an order in the system.

Attributes:
      orderld: Unique identifier for each order.
      customerName: Name of the customer placing the order.
      orderDate: Date when the order was placed.
      totalAmount: Total cost of the order.
      orderStatus: Current status of the order (eg, "Pending", "Shipped", "Delivered").

Database Schema and Model Definitions:
Manually create the orders table with the following structure:
    orderid as an integer (auto-increment primary key).
    customerName as a non-null string.
    orderDate as a non-null date.
    totalAmount as a decimal value.
    orderStatus as a non-null string.

To Work with MySQL:
      Open a New Terminal
      Connect to MySQL → Type mysql -u root --protocol=tcp -p and enter the password examly
      Create a Database Type CREATE DATABASE appdb;
      Use the Database Type USE appdb;
      Create a Table Type CREATE TABLE TableName (columnName datatype, ...);
      Insert Data into the Table Type INSERT INTO TableName (',,...); I

DbConnection:
      Inside the util folder, create a class named DBConnectionUtil.java
      The DBConnectionUtil.java class handles the database connection details. It is responsible for establishing and closing the connection to the MySQL database.

Database Configuration:

Database Name: appdb
Username: root
Password: examly

Service:
OrderService Interface:Inside the service folder, create an interface named OrderService. This interface defines the operations for managing orders.

Methods:

String addOrder (Order order): Adds a new order and returns a success or error message.
String deleteOrder(int orderld): Deletes an order by ID and returns a success or error message.
List<Order> getAllOrders(): Returns a list of all orders or an empty list if none exist.

OrderServicelmpl Class

Inside the service folder, create a class named OrderServiceImpl that implements OrderService interface. This class establishes a connection to the MySQL database using DBConnectionUtil.

Implementation Details:

String addOrder(Order order)

o Ensures customer name, order date, total amount, and status are valid.

o Inserts order details into the orders table using an INSERT query.

o Returns a success message if successful or an error message if it fails.

String deleteOrder(int orderid)

o Deletes an order based on orderld using a DELETE query.

o Returns a success message if successful or an error message if no order is found.

List<Order> getAllOrders()

o Fetches all orders using a SELECT query.

o Returns a list of Order objects or an empty list if none exist.
MainModule Class

The MainModule class provides the main user interface for interacting with the Order Management System. Users can select various options to perform actions such as adding, deleting, and viewing orders.

Implementation Details:

main(String[] args)

o Displays a menu for managing orders.

o Based on user input, calls the appropriate method to perform the selected action.

addOrder (OrderService orderService)

o Prompts the user to enter order details, including customer name, order date, total amount, and order status.

o Calls the addOrder method of OrderService to add the order.

o Displays a success or error message.

deleteOrder(OrderService orderService)

Prompts the user to enter an order ID for deletion.

o Calls deleteOrder to remove the order.

o Displays a success message if deletion is successfull.
viewAllOrders(OrderService orderService)

o Calls getAllOrders to retrieve all orders.

o Displays a list of orders or a message if none exist.

Commands to Run the Project

Method 1: Using the VS Code Run Button

1. Open VS Code and open the ordermanager folder.

2. Open MainModule.java (inside src/main/java/com/example/).

3. Right-click on MainModule.java.

4. Click "Run Java" from the context menu.

5. The application starts running, and the output appears in the Terminal.

Method 2: Using the VS Code Terminal

1. Open VS Code Terminal and navigate to the ordermanager folder by running:

ordermanager

2. Build the project by running:

clean install

3. Run the project by executing:
mvn exec java-Dexec.mainClass="com.example.MainModule"

4. The application starts running, and the output appears in the Terminal.

Test Cases for Order Management System

Below are three non-functional test cases and two functional test cases to ensure the system is working correctly.

Non-Functional Test Cases

1. File Existence Check (Non-Functional)

o Test Case ID: test_Util_File_Exist()

o Description: Ensure that the DBConnectionUtil.java file exists in the util folder.

o Expected Outcome: The file should be present in the correct folder (src/main/java/com/example/util/), and the system should be able to locate it without errors.
2. Folder Structure Validation (Non-Functional)

o Test Case ID: test_Util_Folder_Exist()

o Description: Ensure the util folder is exist.

o Expected Outcome: The util folders should exist in the src/main/java/com/example/.

3. Method Existence Check in Service Implementation (Non-Functional)

o Test Case ID: test_Check_Method_Exist()

o Description: Verify that the OrderServicelmpl class implements all required methods from OrderService.

o Expected Outcome: The class should implement addOrder() without missing method errors.
Functional Test Cases

4. Create Order Query Execution (Functional)

o Test Case ID: test_Create_Query_Exist()

o Description: Validate if the INSERT SQL query correctly

adds a new order to the database.

o Expected Outcome: A new record should be added to the orders table with the provided details.

5. Delete Order Query Execution (Functional)

o Test Case ID: test_Delete_Query_Exist()

o Description: Ensure that the DELETE query correctly removes an order from the database.

Outcome: The specified order should be removed from the orders table.
Commands to Run the Testcase

Method 2: Using the VS Code Terminal

1. Open VS Code Terminal and navigate to the ordermanager folder by running:

cd ordermanager

2. Run the project:

mvn clean test
Dependencies:

1. JUnit 5: Used for unit testing (junit-jupiter-api and junit-jupiter-engine).

2. MySQL Connector: For connecting to a MySQL database (mysql-connector-java).

3. Mockito: For mocking objects in unit tests (mockito-inline, mockito-core, mockito-junit-jupiter).

4. Logging (SLF4J + Logback): Mentioned for logging, but dependencies aren't included.

Plugins:

5. Maven Compiler Plugin: Configures Java 17 for compiling.

6. Maven Surefire Plugin: Runs unit tests during the build.

7. Maven JAR Plugin: Builds the JAR file.

Properties:

UTF-8 Encoding: For source files.

Java Version: Set to Java 17 for compiling.
