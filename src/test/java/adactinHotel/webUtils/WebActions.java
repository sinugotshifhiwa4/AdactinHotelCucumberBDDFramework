package adactinHotel.webUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WebActions {

    public Wait<WebDriver> createFluentWait(WebDriver driver){

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5000))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(WebDriverException.class);
    }

    public void clickObjects(WebElement element, WebDriver driver){

        try{
            Wait<WebDriver> wait = createFluentWait(driver);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        } catch (Exception e) {
            handleException("clickObjects", e);
        }
    }

    public void passObjects(WebElement element, WebDriver driver, String vValue){

        try{
            Wait<WebDriver> wait = createFluentWait(driver);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(vValue);

        } catch (Exception e) {
            handleException("passObjects", e);
        }
    }

    public void selectObjects(WebElement element, WebDriver driver, String selectMethod, Object vValue){

        Select select = new Select(element);

        try{
            Wait<WebDriver> wait = createFluentWait(driver);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            switch (selectMethod.toUpperCase()){

                case "SELECTBYINDEX":
                    select.selectByIndex((Integer) vValue);
                    break;

                case "SELECTBYVALUE":
                    select.selectByValue((String) vValue);
                    break;

                case "SELECTBYVISIBLETEXT":
                    select.selectByVisibleText((String) vValue);
                    break;
            }

        } catch (Exception e) {
            handleException("selectObjects", e);
        }
    }

    public void webDriverWait(WebElement element, WebDriver driver){

        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {
            handleExceptionOnWebDriverWait("Element: " + element.toString(), e);
        }
    }

    // Exception handling methods
    private void handleException(String methodName, Exception e){

        throw new CustomExceptions("Exception occurred in " + methodName + ": " + e.getMessage(),e);
    }

    private void handleExceptionOnWebDriverWait(String errorDetails, Exception e) {
        // Handle exceptions using the CustomExceptions class
        throw new CustomExceptions("Exception occurred in " + "webDriverWait" + ": " + errorDetails, e);
    }
}
