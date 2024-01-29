package adactinHotel.stepDefinitions;

import adactinHotel.pageObjects.WebFunctions;
import adactinHotel.webUtils.WebUtilities;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseStepDefinitions {

    private WebUtilities webUtilities;

    @Before
    public void setUp() {

        webUtilities = WebUtilities.getInstance();
        String sUrl = "https://adactinhotelapp.com/";
        String sBrowser = "CHROME";

        try {

            webUtilities.setDriver(webUtilities.initializeDriver(sBrowser));
            webUtilities.navigate(sUrl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @AfterStep
    public void takeScreenshot(Scenario scenario){

        final byte [] screenshot = ((TakesScreenshot) webUtilities.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    @After
    public void tearDown() {

        try {

            //logout
            WebFunctions functions = new WebFunctions();
            functions.logOut(webUtilities.getDriver());

            Thread.sleep(5000);
            webUtilities.getDriver().close();
            webUtilities.getDriver().quit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
