<div align="center">

# 🚚 FastLogistics Selenium Automation Framework

### Production-Style UI Test Automation Framework

**Java · Selenium WebDriver · TestNG · Maven · Page Object Model · Git · GitHub**

<p>
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium">
  <img src="https://img.shields.io/badge/TestNG-7.x-red?style=for-the-badge" alt="TestNG">
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
</p>

<p>
  <img src="https://img.shields.io/badge/Architecture-POM-blue?style=flat-square" alt="POM">
  <img src="https://img.shields.io/badge/Driver-WebDriverManager-green?style=flat-square" alt="WebDriverManager">
  <img src="https://img.shields.io/badge/Version%20Control-Git-black?style=flat-square&logo=git" alt="Git">
  <img src="https://img.shields.io/badge/Platform-GitHub-181717?style=flat-square&logo=github" alt="GitHub">
</p>

<p>
  <b>End-to-End UI Regression Automation for Shipment Management</b>
</p>

</div>

---

## 📌 About the Project

**FastLogistics Selenium Automation Framework** is a Java-based UI automation framework developed for the **FastLogistics Shipment Management System**.

The framework uses **Selenium WebDriver, TestNG, Maven, WebDriverManager, and the Page Object Model (POM)** to automate functional and regression scenarios across the application's core shipment workflows.

The automation suite covers:

* 🔐 Authentication and access control
* 📊 Dashboard navigation
* 📦 Shipment creation
* 🔎 Shipment search
* 🔄 Shipment status management
* 🔗 End-to-end shipment lifecycle workflows
* ❌ Positive and negative validation scenarios
* 🧪 Regression-oriented UI validation

The framework is structured to keep **test logic, page interactions, configuration, test data, and framework infrastructure separated**, making it easier to maintain and extend.

---

# 🛠️ Technology Stack

<table>
<tr>
<th>Technology</th>
<th>Purpose</th>
</tr>

<tr>
<td><b>Java</b></td>
<td>Core programming language</td>
</tr>

<tr>
<td><b>Selenium WebDriver</b></td>
<td>Browser and UI automation</td>
</tr>

<tr>
<td><b>TestNG</b></td>
<td>Test execution, organization and listeners</td>
</tr>

<tr>
<td><b>Maven</b></td>
<td>Build and dependency management</td>
</tr>

<tr>
<td><b>WebDriverManager</b></td>
<td>Automated browser driver management</td>
</tr>

<tr>
<td><b>Page Object Model</b></td>
<td>Maintainable page-level automation architecture</td>
</tr>

<tr>
<td><b>Git</b></td>
<td>Source code version control</td>
</tr>

<tr>
<td><b>GitHub</b></td>
<td>Repository and source management</td>
</tr>

</table>

---

# 🧪 Test Coverage

<table>
<tr>
<th>Module</th>
<th>Automated Coverage</th>
</tr>

<tr>
<td>🔐 <b>Authentication & Access</b></td>
<td>
Valid and invalid login credentials,
empty field validation,
case sensitivity,
numeric credential handling,
session management,
logout,
post-logout URL restrictions
</td>
</tr>

<tr>
<td>📊 <b>Dashboard Navigation</b></td>
<td>
Page title,
heading,
URL validation,
Create Shipment navigation,
Search Shipment navigation,
Update Status navigation,
logout redirection
</td>
</tr>

<tr>
<td>📦 <b>Shipment Creation</b></td>
<td>
Express and Standard shipments,
mandatory field validation,
negative weight validation,
priority selection,
country selection,
confirmation toast validation
</td>
</tr>

<tr>
<td>🔎 <b>Shipment Search</b></td>
<td>
Existing shipment lookup,
missing shipment validation,
empty ID submission,
special-character query handling
</td>
</tr>

<tr>
<td>🔄 <b>Status Management</b></td>
<td>
Pending → In Transit → Delivered,
status persistence,
post-update verification,
unassigned shipment validation
</td>
</tr>

<tr>
<td>🔗 <b>End-to-End Workflow</b></td>
<td>
Shipment creation → lookup → status update → verification → dashboard tracking
</td>
</tr>

</table>

---

# 🔄 Shipment Lifecycle

<div align="center">

```text
┌──────────────┐
│    Login     │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│   Dashboard  │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Create    │
│   Shipment   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Search    │
│   Shipment   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Update Status│
└──────┬───────┘
       │
       ▼
┌──────────────────────┐
│ Verify Status        │
│ Pending → In Transit │
│ In Transit →         │
│ Delivered            │
└──────────┬───────────┘
           │
           ▼
┌──────────────┐
│   Dashboard  │
│   Tracking   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Logout    │
└──────────────┘
```

</div>

---

# 🏗️ Framework Architecture

The framework follows the **Page Object Model (POM)** design pattern.

```text
                    ┌──────────────────────┐
                    │      TestNG Suite   │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │      BaseTest       │
                    │ Driver / Setup /    │
                    │ Configuration       │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │     Test Classes     │
                    │ Login / Create /     │
                    │ Search / Update /    │
                    │ End-to-End           │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │     Page Objects     │
                    │ LoginPage            │
                    │ DashboardPage        │
                    │ CreateShipmentPage   │
                    │ SearchShipmentPage   │
                    │ UpdateStatusPage     │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │  Selenium WebDriver  │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │ FastLogistics Web UI │
                    └──────────────────────┘
```

---

# 📂 Project Structure

<details>
<summary><b>Click to expand project structure</b></summary>

```text
fastlogistics-selenium/
│
├── .github/
│
├── src/
│   │
│   ├── main/
│   │   └── java/
│   │       │
│   │       ├── pages/
│   │       │   ├── BasePage.java
│   │       │   ├── CreateShipmentPage.java
│   │       │   ├── DashboardPage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── SearchShipmentPage.java
│   │       │   └── UpdateStatusPage.java
│   │       │
│   │       └── utils/
│   │           └── ConfigReader.java
│   │
│   └── test/
│       │
│       ├── java/
│       │   │
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   │
│       │   ├── listeners/
│       │   │   └── TestListener.java
│       │   │
│       │   └── tests/
│       │       ├── CreateShipmentTest.java
│       │       ├── DashboardTest.java
│       │       ├── EndToEndTest.java
│       │       ├── LoginTest.java
│       │       ├── SearchShipmentTest.java
│       │       └── UpdateStatusTest.java
│       │
│       └── resources/
│           ├── config.properties
│           └── shipmentData.properties
│
├── pom.xml
├── testng.xml
└── README.md
```

</details>

---

# 🧩 Framework Components

## 📄 Page Objects

All application-specific UI interactions are organized inside the `pages` package.

### `BasePage.java`

Provides reusable page-level functionality and common Selenium operations.

### `LoginPage.java`

Responsible for authentication-related interactions:

* Username input
* Password input
* Login action
* Authentication validation
* Logout-related interaction

### `DashboardPage.java`

Responsible for:

* Dashboard validation
* Page navigation
* URL validation
* Logout interaction

### `CreateShipmentPage.java`

Responsible for:

* Shipment type selection
* Shipment data entry
* Priority selection
* Country selection
* Form validation
* Shipment creation
* Confirmation message validation

### `SearchShipmentPage.java`

Responsible for:

* Shipment ID input
* Search execution
* Search result validation
* Negative search scenarios
* Invalid input validation

### `UpdateStatusPage.java`

Responsible for:

* Shipment lookup
* Status selection
* Status update
* Updated status verification
* Invalid status handling

---

# 🧪 Test Classes

<table>
<tr>
<th>Test Class</th>
<th>Purpose</th>
</tr>

<tr>
<td><code>LoginTest.java</code></td>
<td>Authentication and access validation</td>
</tr>

<tr>
<td><code>DashboardTest.java</code></td>
<td>Dashboard and navigation validation</td>
</tr>

<tr>
<td><code>CreateShipmentTest.java</code></td>
<td>Shipment creation and form validation</td>
</tr>

<tr>
<td><code>SearchShipmentTest.java</code></td>
<td>Shipment search and negative scenarios</td>
</tr>

<tr>
<td><code>UpdateStatusTest.java</code></td>
<td>Shipment status lifecycle validation</td>
</tr>

<tr>
<td><code>EndToEndTest.java</code></td>
<td>Complete shipment workflow validation</td>
</tr>

</table>

---

# ⚙️ Base Test Infrastructure

`BaseTest.java` provides the common test execution infrastructure.

### Responsibilities

* WebDriver initialization
* Browser configuration
* Configuration loading
* Test setup
* Test teardown
* Driver lifecycle management

This keeps browser setup and teardown logic centralized rather than duplicated across individual test classes.

---

# 🎧 TestNG Listener

`TestListener.java` provides custom TestNG event handling.

The listener acts as a centralized hook for test execution events such as:

* Test start
* Test completion
* Pass/failure tracking
* Execution logging
* Reporting hooks
* Failure handling

The framework can be extended with screenshot capture and reporting without changing individual test classes.

---

# 🔧 Configuration Management

Application configuration is externalized through:

```text
src/test/resources/config.properties
```

This keeps environment-specific values separate from Java source code.

Example:

```properties
browser=chrome
baseUrl=<application-url>
```

> Replace placeholder values with the actual application configuration before execution.

---

# 📊 Test Data Management

Shipment-specific test data is maintained separately through:

```text
src/test/resources/shipmentData.properties
```

This allows test payloads to be changed without modifying the test implementation.

Example:

```properties
shipment.type=Express
shipment.priority=High
shipment.country=India
```

---

# 🌐 WebDriver Management

The framework uses **WebDriverManager** to manage browser driver binaries.

This removes the requirement to manually download and maintain browser driver executables for supported browsers.

---

# 📦 Maven Configuration

Maven manages the framework's dependencies and build lifecycle through:

```text
pom.xml
```

The Maven lifecycle is used for:

* Dependency resolution
* Compilation
* Test compilation
* Test execution
* Build management

---

# ▶️ How to Run

## 1️⃣ Clone the Repository

```bash
git clone <repository-url>
```

Navigate to the project:

```bash
cd fastlogistics-selenium
```

---

## 2️⃣ Import the Project

Open the project using:

* IntelliJ IDEA
* Eclipse
* VS Code with Java/Maven support

Import the project as a **Maven project**.

---

## 3️⃣ Compile

```bash
mvn clean test-compile
```

---

## 4️⃣ Run the Complete Test Suite

```bash
mvn test
```

---

## 5️⃣ Run Through TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# 🔄 Test Execution Flow

<div align="center">

```text
TestNG
   │
   ▼
BaseTest
   │
   ▼
WebDriver Initialization
   │
   ▼
Test Class
   │
   ▼
Page Object
   │
   ▼
Selenium WebDriver
   │
   ▼
FastLogistics Application
   │
   ▼
Assertions & Validation
   │
   ▼
TestListener
   │
   ▼
Execution Result
```

</div>

---

# 💡 POM Design Example

The framework keeps Selenium implementation inside Page Objects rather than directly inside test cases.

### ❌ Direct Selenium interaction inside test

```java
driver.findElement(By.id("shipmentId"))
      .sendKeys("SHIP123");

driver.findElement(By.id("search"))
      .click();
```

### ✅ Page Object approach

```java
searchShipmentPage.searchShipment("SHIP123");
```

This keeps test cases focused on **business behavior and validation**, while UI implementation remains inside the relevant Page Object.

---

# 🎯 Automation Design Principles

The framework follows these design principles:

<table>
<tr>
<td>🏗️ <b>Separation of Concerns</b></td>
<td>Page interactions and test execution are separated.</td>
</tr>

<tr>
<td>♻️ <b>Reusability</b></td>
<td>Common functionality is centralized and reused.</td>
</tr>

<tr>
<td>🧹 <b>Maintainability</b></td>
<td>UI changes can be managed within page classes.</td>
</tr>

<tr>
<td>📖 <b>Readability</b></td>
<td>Test cases focus on business scenarios.</td>
</tr>

<tr>
<td>⚙️ <b>Configuration Separation</b></td>
<td>Environment configuration is externalized.</td>
</tr>

<tr>
<td>📊 <b>Data Separation</b></td>
<td>Shipment test data is maintained separately.</td>
</tr>

<tr>
<td>🔌 <b>Extensibility</b></td>
<td>Reporting, CI/CD and database validation can be added.</td>
</tr>

</table>

---

# 🧪 Testing Strategy

The automation suite includes different categories of functional validation:

```text
┌───────────────────────┐
│   Positive Testing    │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│   Negative Testing    │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Boundary Validation   │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Navigation Testing    │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Access Control        │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Workflow Testing      │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Regression Testing    │
└───────────────────────┘
```

---

# 📸 Screenshots

Screenshots can be added to the repository under:

```text
docs/
├── login.png
├── dashboard.png
├── create-shipment.png
├── search-shipment.png
└── test-execution.png
```

Once available, they can be displayed here:

<div align="center">

<!-- Add screenshots when available -->

</div>

---

# 🚀 Future Enhancements

The following improvements are planned for future iterations of the framework:

<table>
<tr>
<th>Enhancement</th>
<th>Status</th>
</tr>

<tr>
<td>Automatic failure screenshots</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>ExtentReports integration</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Allure reporting</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Parallel test execution</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Cross-browser execution</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Selenium Grid</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>GitHub Actions CI/CD</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Jenkins integration</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>JDBC database validation</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Backend state verification</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Retry mechanism</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Advanced logging</td>
<td>🔜 Planned</td>
</tr>

</table>

---

# 🔮 CI/CD Roadmap

Once CI/CD is integrated, the intended execution flow is:

```text
Developer Push
      │
      ▼
GitHub Repository
      │
      ▼
CI/CD Pipeline
      │
      ▼
Maven Build
      │
      ▼
TestNG Execution
      │
      ▼
Selenium Tests
      │
      ▼
Test Results
      │
      ▼
Automation Reports
```

Potential CI/CD platforms:

* GitHub Actions
* Jenkins

---

# 🗄️ Database Validation Roadmap

A future JDBC layer can be introduced to validate backend persistence.

Example workflow:

```text
Create Shipment through UI
          │
          ▼
Validate UI Response
          │
          ▼
Query Database using JDBC
          │
          ▼
Verify Shipment Record
          │
          ▼
Verify Shipment Status
```

This would extend the framework toward combined **UI + backend validation**.

---

# 📈 Framework Evolution

The framework is designed to evolve from a UI-only automation suite into a broader test automation solution:

```text
Current
   │
   ├── Selenium UI Automation
   ├── TestNG
   ├── POM
   ├── Maven
   └── Configuration/Data Separation
        │
        ▼
Future
   │
   ├── Reporting
   ├── Parallel Execution
   ├── Cross-Browser Testing
   ├── CI/CD
   ├── Database Validation
   └── Advanced Test Analytics
```

---

# 👨‍💻 Author

<div align="center">

### Dhrubjyoti Chattopadhyay

**QA Automation Engineer**

<br>

<table>
<tr>
<td align="center"><b>Java</b></td>
<td align="center"><b>Selenium WebDriver</b></td>
<td align="center"><b>TestNG</b></td>
<td align="center"><b>Maven</b></td>
</tr>

<tr>
<td align="center"><b>SQL</b></td>
<td align="center"><b>Git</b></td>
<td align="center"><b>Test Automation</b></td>
<td align="center"><b>POM</b></td>
</tr>
</table>

</div>

---

# 📜 License

This project is intended for **learning, demonstration, portfolio, and QA automation practice purposes**.

---

<div align="center">

### 🚚 FastLogistics Selenium Automation Framework

**Built with Java + Selenium + TestNG**

⭐ If you find the project useful, consider giving the repository a star.

</div>
<div align="center">

# 🚚 FastLogistics Selenium Automation Framework

### Production-Style UI Test Automation Framework

**Java · Selenium WebDriver · TestNG · Maven · Page Object Model · Git · GitHub**

<p>
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium">
  <img src="https://img.shields.io/badge/TestNG-7.x-red?style=for-the-badge" alt="TestNG">
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
</p>

<p>
  <img src="https://img.shields.io/badge/Architecture-POM-blue?style=flat-square" alt="POM">
  <img src="https://img.shields.io/badge/Driver-WebDriverManager-green?style=flat-square" alt="WebDriverManager">
  <img src="https://img.shields.io/badge/Version%20Control-Git-black?style=flat-square&logo=git" alt="Git">
  <img src="https://img.shields.io/badge/Platform-GitHub-181717?style=flat-square&logo=github" alt="GitHub">
</p>

<p>
  <b>End-to-End UI Regression Automation for Shipment Management</b>
</p>

</div>

---

## 📌 About the Project

**FastLogistics Selenium Automation Framework** is a Java-based UI automation framework developed for the **FastLogistics Shipment Management System**.

The framework uses **Selenium WebDriver, TestNG, Maven, WebDriverManager, and the Page Object Model (POM)** to automate functional and regression scenarios across the application's core shipment workflows.

The automation suite covers:

* 🔐 Authentication and access control
* 📊 Dashboard navigation
* 📦 Shipment creation
* 🔎 Shipment search
* 🔄 Shipment status management
* 🔗 End-to-end shipment lifecycle workflows
* ❌ Positive and negative validation scenarios
* 🧪 Regression-oriented UI validation

The framework is structured to keep **test logic, page interactions, configuration, test data, and framework infrastructure separated**, making it easier to maintain and extend.

---

# 🛠️ Technology Stack

<table>
<tr>
<th>Technology</th>
<th>Purpose</th>
</tr>

<tr>
<td><b>Java</b></td>
<td>Core programming language</td>
</tr>

<tr>
<td><b>Selenium WebDriver</b></td>
<td>Browser and UI automation</td>
</tr>

<tr>
<td><b>TestNG</b></td>
<td>Test execution, organization and listeners</td>
</tr>

<tr>
<td><b>Maven</b></td>
<td>Build and dependency management</td>
</tr>

<tr>
<td><b>WebDriverManager</b></td>
<td>Automated browser driver management</td>
</tr>

<tr>
<td><b>Page Object Model</b></td>
<td>Maintainable page-level automation architecture</td>
</tr>

<tr>
<td><b>Git</b></td>
<td>Source code version control</td>
</tr>

<tr>
<td><b>GitHub</b></td>
<td>Repository and source management</td>
</tr>

</table>

---

# 🧪 Test Coverage

<table>
<tr>
<th>Module</th>
<th>Automated Coverage</th>
</tr>

<tr>
<td>🔐 <b>Authentication & Access</b></td>
<td>
Valid and invalid login credentials,
empty field validation,
case sensitivity,
numeric credential handling,
session management,
logout,
post-logout URL restrictions
</td>
</tr>

<tr>
<td>📊 <b>Dashboard Navigation</b></td>
<td>
Page title,
heading,
URL validation,
Create Shipment navigation,
Search Shipment navigation,
Update Status navigation,
logout redirection
</td>
</tr>

<tr>
<td>📦 <b>Shipment Creation</b></td>
<td>
Express and Standard shipments,
mandatory field validation,
negative weight validation,
priority selection,
country selection,
confirmation toast validation
</td>
</tr>

<tr>
<td>🔎 <b>Shipment Search</b></td>
<td>
Existing shipment lookup,
missing shipment validation,
empty ID submission,
special-character query handling
</td>
</tr>

<tr>
<td>🔄 <b>Status Management</b></td>
<td>
Pending → In Transit → Delivered,
status persistence,
post-update verification,
unassigned shipment validation
</td>
</tr>

<tr>
<td>🔗 <b>End-to-End Workflow</b></td>
<td>
Shipment creation → lookup → status update → verification → dashboard tracking
</td>
</tr>

</table>

---

# 🔄 Shipment Lifecycle

<div align="center">

```text
┌──────────────┐
│    Login     │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│   Dashboard  │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Create    │
│   Shipment   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Search    │
│   Shipment   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Update Status│
└──────┬───────┘
       │
       ▼
┌──────────────────────┐
│ Verify Status        │
│ Pending → In Transit │
│ In Transit →         │
│ Delivered            │
└──────────┬───────────┘
           │
           ▼
┌──────────────┐
│   Dashboard  │
│   Tracking   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Logout    │
└──────────────┘
```

</div>

---

# 🏗️ Framework Architecture

The framework follows the **Page Object Model (POM)** design pattern.

```text
                    ┌──────────────────────┐
                    │      TestNG Suite   │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │      BaseTest       │
                    │ Driver / Setup /    │
                    │ Configuration       │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │     Test Classes     │
                    │ Login / Create /     │
                    │ Search / Update /    │
                    │ End-to-End           │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │     Page Objects     │
                    │ LoginPage            │
                    │ DashboardPage        │
                    │ CreateShipmentPage   │
                    │ SearchShipmentPage   │
                    │ UpdateStatusPage     │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │  Selenium WebDriver  │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │ FastLogistics Web UI │
                    └──────────────────────┘
```

---

# 📂 Project Structure

<details>
<summary><b>Click to expand project structure</b></summary>

```text
fastlogistics-selenium/
│
├── .github/
│
├── src/
│   │
│   ├── main/
│   │   └── java/
│   │       │
│   │       ├── pages/
│   │       │   ├── BasePage.java
│   │       │   ├── CreateShipmentPage.java
│   │       │   ├── DashboardPage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── SearchShipmentPage.java
│   │       │   └── UpdateStatusPage.java
│   │       │
│   │       └── utils/
│   │           └── ConfigReader.java
│   │
│   └── test/
│       │
│       ├── java/
│       │   │
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   │
│       │   ├── listeners/
│       │   │   └── TestListener.java
│       │   │
│       │   └── tests/
│       │       ├── CreateShipmentTest.java
│       │       ├── DashboardTest.java
│       │       ├── EndToEndTest.java
│       │       ├── LoginTest.java
│       │       ├── SearchShipmentTest.java
│       │       └── UpdateStatusTest.java
│       │
│       └── resources/
│           ├── config.properties
│           └── shipmentData.properties
│
├── pom.xml
├── testng.xml
└── README.md
```

</details>

---

# 🧩 Framework Components

## 📄 Page Objects

All application-specific UI interactions are organized inside the `pages` package.

### `BasePage.java`

Provides reusable page-level functionality and common Selenium operations.

### `LoginPage.java`

Responsible for authentication-related interactions:

* Username input
* Password input
* Login action
* Authentication validation
* Logout-related interaction

### `DashboardPage.java`

Responsible for:

* Dashboard validation
* Page navigation
* URL validation
* Logout interaction

### `CreateShipmentPage.java`

Responsible for:

* Shipment type selection
* Shipment data entry
* Priority selection
* Country selection
* Form validation
* Shipment creation
* Confirmation message validation

### `SearchShipmentPage.java`

Responsible for:

* Shipment ID input
* Search execution
* Search result validation
* Negative search scenarios
* Invalid input validation

### `UpdateStatusPage.java`

Responsible for:

* Shipment lookup
* Status selection
* Status update
* Updated status verification
* Invalid status handling

---

# 🧪 Test Classes

<table>
<tr>
<th>Test Class</th>
<th>Purpose</th>
</tr>

<tr>
<td><code>LoginTest.java</code></td>
<td>Authentication and access validation</td>
</tr>

<tr>
<td><code>DashboardTest.java</code></td>
<td>Dashboard and navigation validation</td>
</tr>

<tr>
<td><code>CreateShipmentTest.java</code></td>
<td>Shipment creation and form validation</td>
</tr>

<tr>
<td><code>SearchShipmentTest.java</code></td>
<td>Shipment search and negative scenarios</td>
</tr>

<tr>
<td><code>UpdateStatusTest.java</code></td>
<td>Shipment status lifecycle validation</td>
</tr>

<tr>
<td><code>EndToEndTest.java</code></td>
<td>Complete shipment workflow validation</td>
</tr>

</table>

---

# ⚙️ Base Test Infrastructure

`BaseTest.java` provides the common test execution infrastructure.

### Responsibilities

* WebDriver initialization
* Browser configuration
* Configuration loading
* Test setup
* Test teardown
* Driver lifecycle management

This keeps browser setup and teardown logic centralized rather than duplicated across individual test classes.

---

# 🎧 TestNG Listener

`TestListener.java` provides custom TestNG event handling.

The listener acts as a centralized hook for test execution events such as:

* Test start
* Test completion
* Pass/failure tracking
* Execution logging
* Reporting hooks
* Failure handling

The framework can be extended with screenshot capture and reporting without changing individual test classes.

---

# 🔧 Configuration Management

Application configuration is externalized through:

```text
src/test/resources/config.properties
```

This keeps environment-specific values separate from Java source code.

Example:

```properties
browser=chrome
baseUrl=<application-url>
```

> Replace placeholder values with the actual application configuration before execution.

---

# 📊 Test Data Management

Shipment-specific test data is maintained separately through:

```text
src/test/resources/shipmentData.properties
```

This allows test payloads to be changed without modifying the test implementation.

Example:

```properties
shipment.type=Express
shipment.priority=High
shipment.country=India
```

---

# 🌐 WebDriver Management

The framework uses **WebDriverManager** to manage browser driver binaries.

This removes the requirement to manually download and maintain browser driver executables for supported browsers.

---

# 📦 Maven Configuration

Maven manages the framework's dependencies and build lifecycle through:

```text
pom.xml
```

The Maven lifecycle is used for:

* Dependency resolution
* Compilation
* Test compilation
* Test execution
* Build management

---

# ▶️ How to Run

## 1️⃣ Clone the Repository

```bash
git clone <repository-url>
```

Navigate to the project:

```bash
cd fastlogistics-selenium
```

---

## 2️⃣ Import the Project

Open the project using:

* IntelliJ IDEA
* Eclipse
* VS Code with Java/Maven support

Import the project as a **Maven project**.

---

## 3️⃣ Compile

```bash
mvn clean test-compile
```

---

## 4️⃣ Run the Complete Test Suite

```bash
mvn test
```

---

## 5️⃣ Run Through TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# 🔄 Test Execution Flow

<div align="center">

```text
TestNG
   │
   ▼
BaseTest
   │
   ▼
WebDriver Initialization
   │
   ▼
Test Class
   │
   ▼
Page Object
   │
   ▼
Selenium WebDriver
   │
   ▼
FastLogistics Application
   │
   ▼
Assertions & Validation
   │
   ▼
TestListener
   │
   ▼
Execution Result
```

</div>

---

# 💡 POM Design Example

The framework keeps Selenium implementation inside Page Objects rather than directly inside test cases.

### ❌ Direct Selenium interaction inside test

```java
driver.findElement(By.id("shipmentId"))
      .sendKeys("SHIP123");

driver.findElement(By.id("search"))
      .click();
```

### ✅ Page Object approach

```java
searchShipmentPage.searchShipment("SHIP123");
```

This keeps test cases focused on **business behavior and validation**, while UI implementation remains inside the relevant Page Object.

---

# 🎯 Automation Design Principles

The framework follows these design principles:

<table>
<tr>
<td>🏗️ <b>Separation of Concerns</b></td>
<td>Page interactions and test execution are separated.</td>
</tr>

<tr>
<td>♻️ <b>Reusability</b></td>
<td>Common functionality is centralized and reused.</td>
</tr>

<tr>
<td>🧹 <b>Maintainability</b></td>
<td>UI changes can be managed within page classes.</td>
</tr>

<tr>
<td>📖 <b>Readability</b></td>
<td>Test cases focus on business scenarios.</td>
</tr>

<tr>
<td>⚙️ <b>Configuration Separation</b></td>
<td>Environment configuration is externalized.</td>
</tr>

<tr>
<td>📊 <b>Data Separation</b></td>
<td>Shipment test data is maintained separately.</td>
</tr>

<tr>
<td>🔌 <b>Extensibility</b></td>
<td>Reporting, CI/CD and database validation can be added.</td>
</tr>

</table>

---

# 🧪 Testing Strategy

The automation suite includes different categories of functional validation:

```text
┌───────────────────────┐
│   Positive Testing    │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│   Negative Testing    │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Boundary Validation   │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Navigation Testing    │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Access Control        │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Workflow Testing      │
└───────────┬───────────┘
            │
┌───────────▼───────────┐
│ Regression Testing    │
└───────────────────────┘
```

---

# 📸 Screenshots

Screenshots can be added to the repository under:

```text
docs/
├── login.png
├── dashboard.png
├── create-shipment.png
├── search-shipment.png
└── test-execution.png
```

Once available, they can be displayed here:

<div align="center">

<!-- Add screenshots when available -->

</div>

---

# 🚀 Future Enhancements

The following improvements are planned for future iterations of the framework:

<table>
<tr>
<th>Enhancement</th>
<th>Status</th>
</tr>

<tr>
<td>Automatic failure screenshots</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>ExtentReports integration</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Allure reporting</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Parallel test execution</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Cross-browser execution</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Selenium Grid</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>GitHub Actions CI/CD</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Jenkins integration</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>JDBC database validation</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Backend state verification</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Retry mechanism</td>
<td>🔜 Planned</td>
</tr>

<tr>
<td>Advanced logging</td>
<td>🔜 Planned</td>
</tr>

</table>

---

# 🔮 CI/CD Roadmap

Once CI/CD is integrated, the intended execution flow is:

```text
Developer Push
      │
      ▼
GitHub Repository
      │
      ▼
CI/CD Pipeline
      │
      ▼
Maven Build
      │
      ▼
TestNG Execution
      │
      ▼
Selenium Tests
      │
      ▼
Test Results
      │
      ▼
Automation Reports
```

Potential CI/CD platforms:

* GitHub Actions
* Jenkins

---

# 🗄️ Database Validation Roadmap

A future JDBC layer can be introduced to validate backend persistence.

Example workflow:

```text
Create Shipment through UI
          │
          ▼
Validate UI Response
          │
          ▼
Query Database using JDBC
          │
          ▼
Verify Shipment Record
          │
          ▼
Verify Shipment Status
```

This would extend the framework toward combined **UI + backend validation**.

---

# 📈 Framework Evolution

The framework is designed to evolve from a UI-only automation suite into a broader test automation solution:

```text
Current
   │
   ├── Selenium UI Automation
   ├── TestNG
   ├── POM
   ├── Maven
   └── Configuration/Data Separation
        │
        ▼
Future
   │
   ├── Reporting
   ├── Parallel Execution
   ├── Cross-Browser Testing
   ├── CI/CD
   ├── Database Validation
   └── Advanced Test Analytics
```

---

# 👨‍💻 Author

<div align="center">

### Dhrubjyoti Chattopadhyay

**QA Automation Engineer**

<br>

<table>
<tr>
<td align="center"><b>Java</b></td>
<td align="center"><b>Selenium WebDriver</b></td>
<td align="center"><b>TestNG</b></td>
<td align="center"><b>Maven</b></td>
</tr>

<tr>
<td align="center"><b>SQL</b></td>
<td align="center"><b>Git</b></td>
<td align="center"><b>Test Automation</b></td>
<td align="center"><b>POM</b></td>
</tr>
</table>

</div>

---

# 📜 License

This project is intended for **learning, demonstration, portfolio, and QA automation practice purposes**.

---

<div align="center">

### 🚚 FastLogistics Selenium Automation Framework

**Built with Java + Selenium + TestNG**

⭐ If you find the project useful, consider giving the repository a star.

</div>
