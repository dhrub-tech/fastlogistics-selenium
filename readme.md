#  FastLogistics Selenium Automation Framework

A Selenium automation framework developed using Java, TestNG, Maven, and the Page Object Model (POM). This project automates key workflows of the FastLogistics Shipment Management System.

---

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Page Object Model (POM)
- Git & GitHub

---

## Project Modules

### Login Module
- Valid Login
- Invalid Login
- Empty Username
- Empty Password
- Empty Credentials
- Logout
- Session Validation

### Dashboard Module
- Verify Dashboard Title
- Verify Dashboard URL
- Verify Navigation to Create Shipment
- Verify Navigation to Search Shipment
- Verify Navigation to Update Status
- Verify Logout

### Create Shipment Module
- Create Express Shipment
- Create Standard Shipment
- Empty Field Validation
- Shipment Type Validation
- Large Weight Validation

---

## Project Structure

```
FastLogistics-Selenium
│
## Project Structure

- BaseTest.java - Browser setup and teardown
- LoginPage.java - Login page actions
- DashboardPage.java - Dashboard page actions
- CreateShipmentPage.java - Create shipment actions
- LoginTest.java - Login test cases
- DashboardTest.java - Dashboard test cases
- CreateShipmentTest.java - Create shipment test cases```

---

## Framework Design

- Page Object Model (POM)
- Reusable BaseTest class
- TestNG Test Execution
- Maven Dependency Management
- WebDriverManager for browser setup
- Separate Page Classes and Test Classes

---

## How to Run

1. Clone the repository

```
git clone https://github.com/dhrub-tech/fastlogistics-selenium.git
```

2. Open the project in Eclipse or VS Code.

3. Install Maven dependencies.

4. Run `testng.xml` as a TestNG Suite.

---

## Upcoming Enhancements

- Search Shipment Automation
- Update Shipment Status Automation
- End-to-End Workflow Automation
- Screenshot Capture on Failure
- Explicit Waits
- Extent Reports
- Jenkins CI Integration

---

## Author

**Dhrubjyoti Chattopadhyay**

QA Engineer | Manual & Automation Testing

Java | Selenium | TestNG | Maven | SQL | GitHub
