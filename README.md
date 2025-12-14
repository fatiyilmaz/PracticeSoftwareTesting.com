#  PracticeSoftwareTesting.com - API Automation Test Suite

## 🎯 About

This project is a comprehensive **Test Automation Framework** built with **Selenium WebDriver**, **Rest Assured**, and **Cucumber BDD** for testing the Practice Software Testing web application and its API endpoints. The framework follows industry best practices and design patterns including **Page Object Model (POM)** and **Behavior-Driven Development (BDD)**.

### Application Under Test
- **Website**: https://practicesoftwaretesting.com/
- **API**: https://api.practicesoftwaretesting.com/

---

## ✨ Features

### UI Testing
- ✅ User Registration & Login flows
- ✅ Product browsing and search functionality
- ✅ Shopping cart operations
- ✅ User profile management
- ✅ Contact form submission
- ✅ Cross-browser testing support

### API Testing
- ✅ User registration & authentication
- ✅ Contact message CRUD operations
- ✅ Token-based authorization
- ✅ Response validation with POJO classes
- ✅ Comprehensive error handling

### Framework Features
- 🔄 BDD approach with Cucumber
- 📊 Detailed HTML reports
- 🎯 Page Object Model design pattern
- 🔐 Secure credential management
- 📝 Extensive logging
- ♻️ Reusable utility methods
- 🏷️ Tag-based test execution

---

## 🛠️ Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17+ | Programming Language |
| Selenium WebDriver | 4.x | UI Test Automation |
| Rest Assured | 5.x | API Test Automation |
| Cucumber | 7.x | BDD Framework |
| TestNG | 7.x | Test Execution Framework |
| Maven | 3.x | Build & Dependency Management |
| Jackson | 2.x | JSON Serialization/Deserialization |

---

## 📋 Prerequisites

Before running this project, ensure you have:

- ☑️ **Java JDK 17** or higher
- ☑️ **Maven 3.6** or higher
- ☑️ **Chrome/Firefox/Edge** browser
- ☑️ **Git** for version control
- ☑️ An IDE (IntelliJ IDEA, Eclipse, or VS Code)

---

## 🚀 Installation

### 1. Clone the Repository
```bash
git clone https://github.com/fatiyilmaz/PracticeSoftwareTesting.com.git
cd PracticeSoftwareTesting.com
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Verify Installation
```bash
mvn test -Dtest=TestRunner
```
