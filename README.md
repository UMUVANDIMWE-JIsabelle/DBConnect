# DBConnect

A simple Java application that demonstrates how to connect to a MySQL database using **JDBC (Java Database Connectivity)**.  
The program establishes a connection, executes a query, and prints results from the `students` table.

---

## Features
- Connects to a local MySQL database
- Executes SQL queries
- Prints results to the console
- Demonstrates basic JDBC workflow (`Connection`, `Statement`, `ResultSet`)

---

## Requirements
- Java JDK 8 or higher (tested with JDK 26)
- MySQL server running locally
- MySQL Connector/J (JDBC driver) JAR file

---

## Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/UMUVANDIMWE-JIsabelle/DBConnect.git
   cd DBConnect

## Create a MySQL database and table

```sql
CREATE DATABASE dbconnect;
USE dbconnect;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

INSERT INTO students (first_name, last_name) VALUES
('Alice', 'Smith'),
('Bob', 'Johnson'),
('Charlie', 'Brown');
## Add the JDBC driver

- Download **MySQL Connector/J** from the official MySQL site.  
- Place the JAR file in a `lib/` folder inside your project.

---

## Compile and Run

From the project root:

```bash
javac -cp .;lib/mysql-connector-java-8.0.33.jar src/main/java/DBConnect.java
java -cp .;lib/mysql-connector-java-8.0.33.jar DBConnect
 ```
## Example Output

```text
1 Alice Smith
2 Bob Johnson
3 Charlie Brown
```

## Project Structure

```text
DBConnect/
├── src/
│   └── main/java/
│       ├── DBConnect.java
│       └── org/example/Main.java
├── pom.xml
└── lib/
    └── mysql-connector-java-8.0.xx.jar




