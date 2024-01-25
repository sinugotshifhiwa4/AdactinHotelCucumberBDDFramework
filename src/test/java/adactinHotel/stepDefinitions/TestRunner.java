package adactinHotel.stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/adactinHotel/features"},
        glue = {"adactinHotel.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@bookHotelSuccessfully",
        monochrome = true
)

public class TestRunner {

}