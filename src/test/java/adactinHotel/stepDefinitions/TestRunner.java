package adactinHotel.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/adactinHotel/features"},
        glue = {"adactinHotel.stepDefinitions"},
        plugin = {"summary", "pretty", "html:target/cucumber-reports.html",
                  "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@bookHotelSuccessfully or @deleteBooking or @confirmDeletedBooking",
        monochrome = true
)

public class TestRunner {

}
