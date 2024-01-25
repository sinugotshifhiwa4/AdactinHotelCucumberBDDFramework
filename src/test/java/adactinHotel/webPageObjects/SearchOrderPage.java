package adactinHotel.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchOrderPage {

    protected WebDriver driver;

    public SearchOrderPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='order_id_text']\n")
    public WebElement searchOrderIdTextBox;

    @FindBy(xpath = "//input[@id='search_hotel_id']")
    public WebElement goBtn;

}
