package adactinHotel.stepDefinitions;

import adactinHotel.webUtils.WebUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.AfterClass;

public class BaseStepDefinitions {

    private WebUtilities webUtilities;
    private static ExtentReports extentReport;
    private static ExtentHtmlReporter htmlReporter;

    @Before
    public void setUp() {

        // Initialize ExtentReport
        if (extentReport == null) {
            extentReport = new ExtentReports();
            htmlReporter = new ExtentHtmlReporter(".//reports//ExtentReport.html");
            extentReport.attachReporter(htmlReporter);
        }

        webUtilities = WebUtilities.getInstance();
        String sUrl = "https://adactinhotelapp.com/";
        String sBrowser = "CHROME";

        try {

            webUtilities.setDriver(webUtilities.initializeDriver(sBrowser));
            webUtilities.navigate(sUrl);
            extentReport.createTest("Opening Browser").pass("Browser opened successfully");

        } catch (Exception e) {
            extentReport.createTest("Initialization").fail("Failed to initialize driver and navigate to the URL");
            throw new RuntimeException(e);
        }

    }

    @After
    public void tearDown() {

        try {
            Thread.sleep(5000);
            webUtilities.getDriver().close();
            webUtilities.getDriver().quit();
            extentReport.createTest("Browser Closure").pass("Browser closed successfully");
        } catch (Exception e) {
            extentReport.createTest("Browser Closure").fail("Failed to close the browser");
            throw new RuntimeException(e);
        } finally {

            if (extentReport != null) {
                extentReport.flush();
            }
        }
    }

    // Getter for ExtentReports
    public static ExtentReports getExtentReports() {
        return extentReport;
    }
}
