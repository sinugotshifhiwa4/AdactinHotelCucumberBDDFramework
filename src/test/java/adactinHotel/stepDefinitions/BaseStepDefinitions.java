package adactinHotel.stepDefinitions;

import adactinHotel.webUtils.WebUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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

    @After
    public void tearDown() {

        try {
            Thread.sleep(5000);
            webUtilities.getDriver().close();
            webUtilities.getDriver().quit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
