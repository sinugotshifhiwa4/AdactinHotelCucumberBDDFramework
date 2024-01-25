package adactinHotel.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CancelBookingPage {

    protected WebDriver driver;

    public CancelBookingPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@name='ids[]']\n")
    public WebElement selectRadioBtn;

    @FindBy(xpath = "//input[@name='cancelall' and @type='submit' and @class='reg_button' and @value='Cancel Selected']\n")
    public WebElement cancelSelectedBtn;

}
