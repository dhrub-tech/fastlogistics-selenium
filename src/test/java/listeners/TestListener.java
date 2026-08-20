package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass =
                result.getInstance();

        try {

            org.openqa.selenium.WebDriver driver =
                    ((base.BaseTest) testClass).getDriver();

            String testName =
                    result.getTestClass()
                            .getRealClass()
                            .getSimpleName()
                    + "_"
                    + result.getMethod()
                            .getMethodName();

            String screenshot =
                    ScreenshotUtil.takeScreenshot(
                            driver,
                            testName
                    );

            System.out.println(
                    "FAILED TEST: "
                            + testName
            );

            System.out.println(
                    "SCREENSHOT: "
                            + screenshot
            );

        } catch (Exception e) {

            System.out.println(
                    "Unable to capture screenshot: "
                            + e.getMessage()
            );
        }
    }
}