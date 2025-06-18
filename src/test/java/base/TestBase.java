package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentReportManager;

import java.lang.reflect.Method;

public class TestBase {
    public static ExtentReports extent;

    @BeforeSuite
    public void setupSuite() {
        // Setup RestAssured base URI from config
        RestAssured.baseURI = ConfigManager.get("baseURI");
        // Initialize ExtentReports
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void beforeTestMethod(Method method) {
        ExtentTest test = extent.createTest(method.getName());
        ExtentReportManager.setTest(test);
    }

    @AfterMethod
    public void afterTestMethod(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }

        ExtentReportManager.removeTest();
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }
}
