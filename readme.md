# FastLogistics Selenium Automation Framework

A Selenium automation framework built using **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)**.

This project automates the core workflows of the **FastLogistics Shipment Management System**, including login, dashboard navigation, shipment creation, search, and status update validations.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Page Object Model (POM)
- Git & GitHub

---

## Automated Modules

### Login Module

Test scenarios covered:

- Valid login
- Invalid login
- Empty username validation
- Empty password validation
- Empty credential validation
- Logout functionality
- Session validation

---

### Dashboard Module

Test scenarios covered:

- Verify dashboard page load
- Verify dashboard URL
- Navigate to Create Shipment
- Navigate to Search Shipment
- Navigate to Update Status
- Verify logout functionality

---

### Create Shipment Module

Test scenarios covered:

- Create Express Shipment
- Create Standard Shipment
- Mandatory field validation
- Shipment type validation
- Weight validation
- Invalid shipment data validation

---

### Search Shipment Module

Test scenarios covered:

- Search shipment using Shipment ID
- Validate shipment details

---

### Update Shipment Status Module

Test scenarios covered:

- Update shipment status
- Validate successful status update

---

## Framework Structure

```
FastLogistics-Selenium
│
├── src/main/java
│   │
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   ├── CreateShipmentPage.java
│   │   ├── SearchShipmentPage.java
│   │   └── UpdateStatusPage.java
│   │
│   └── utils
│       └── ConfigReader.java
│
├── src/test/java
│   │
│   ├── base
│   │   └── BaseTest.java
│   │
│   └── tests
│       ├── LoginTest.java
│       ├── DashboardTest.java
│       ├── CreateShipmentTest.java
│       ├── SearchShipmentTest.java
│       └── UpdateStatusTest.java
│
├── src/test/resources
│   └── shipmentData.properties
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## Framework Highlights

- Page Object Model (POM) architecture
- Reusable BaseTest for browser setup and teardown
- TestNG based test execution
- Maven dependency management
- WebDriverManager for browser driver handling
- Separate page classes and test classes
- External test data management using properties file

---

## How To Run

### Clone Repository

```bash
git clone <repository-url>
```

### Open Project

Open the project in Eclipse or IntelliJ IDEA.

### Install Maven Dependencies

```bash
mvn clean install
```

### Execute Test Suite

Run using TestNG:

```
testng.xml
```

or execute through Maven:

```bash
mvn test
```

---

## Future Enhancements

- Screenshot capture on test failure
- Extent Report integration
- API testing integration
- Database validation using JDBC
- Jenkins CI/CD pipeline
- Cross-browser execution

---

## Author

**Dhrubjyoti Chattopadhyay**

QA Engineer | Manual & Automation Testing

Skills:

Java | Selenium | TestNG | Maven | SQL | Git