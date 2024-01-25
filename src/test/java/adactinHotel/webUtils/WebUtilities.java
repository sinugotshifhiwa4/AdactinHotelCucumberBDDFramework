package adactinHotel.webUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebUtilities {

    private static WebUtilities instance;

    private WebDriver driver;

    private WebUtilities(){}

    public static WebUtilities getInstance(){

        if(instance == null){
            instance = new WebUtilities();
        }

        return instance;
    }

    public WebDriver getDriver(){return driver;}

    public void setDriver(WebDriver driverTest){this.driver = driverTest;}

    public WebDriver initializeDriver(String sBrowser){

        switch (sBrowser.toUpperCase()){

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }

    public void navigate(String sUrl) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(sUrl);
    }
}
