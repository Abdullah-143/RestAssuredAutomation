# RestoShort - API Automation Testing Framework

RestoShort is a REST API automation framework built using Java, TestNG, and REST Assured. It provides a modular and scalable structure for validating RESTful endpoints with enhanced reporting using ExtentReports.
---

## ✅ Features

- **Modular framework design** for maintainability and scalability
- **POJO-based request and response modeling**
- **Service layer** for API interaction using REST Assured
- **Custom assertion and reporting utilities**
- **ExtentReports integration** for detailed HTML reports
- **TestNG-based execution** with support for DataProviders
- **config.properties support** for managing environment-specific data
- **Payload-driven testing** using JSON files

---

## ⚙️ Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/RestoShort.git
   cd RestoShort
   ```

2. **Install dependencies:**

   Make sure you have Java and Maven installed.

   ```bash
   mvn clean install
   ```

3. **Configuration:**

   Update the `resources/config.properties` file with the appropriate API base URI and other settings.

4. **Add your payload:**

   Place test payloads in the `resources/payload/` directory.

---

## 🚀 Execution

### 🔹 Using TestNG (Recommended)

You can execute all test cases via `testng.xml`:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

Or, run it directly from your IDE by right-clicking on `testng.xml` and selecting **Run**.

### 🔹 Using Maven

```bash
mvn test
```

---

## 📊 Reports

After execution, ExtentReports will be generated in the `reports/` folder:

```
reports/
└── extent-report.html
```

Open `extent-report.html` in a browser to view the detailed execution report.

---

## 🧪 Technologies Used

- Java
- REST Assured
- TestNG
- ExtentReports
- Maven
- Jackson (for JSON parsing)

---

## 📌 Author

**Abdullah Shaikh**

