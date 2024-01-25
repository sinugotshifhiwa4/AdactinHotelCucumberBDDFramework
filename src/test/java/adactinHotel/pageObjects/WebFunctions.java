package adactinHotel.pageObjects;

import adactinHotel.webPageObjects.BookHotelPage;
import adactinHotel.webPageObjects.LoginPage;
import adactinHotel.webPageObjects.SearchHotelPage;
import adactinHotel.webPageObjects.SelectHotelPage;
import adactinHotel.webUtils.CustomExceptions;
import adactinHotel.webUtils.FileGenerator;
import adactinHotel.webUtils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebFunctions extends WebActions {

    // Exception handling methods
    private void handleException(String methodName, Exception e){

        throw new CustomExceptions("Exception occurred in " + methodName + ": " + e.getMessage(),e);
    }

    public void logIn(WebDriver driver, String Username, String Password){

        LoginPage loginPage = new LoginPage(driver);

        try{
            passObjects(loginPage.txtUsernme, driver, Username);
            passObjects(loginPage.txtPassword, driver, Password);
            clickObjects(loginPage.btnLogin, driver);

        } catch (Exception e) {
            handleException("logIn", e);
        }
    }

    public void searchHotel(WebDriver driver, String Location, String Hotels, String RoomType, String NumberOfRooms, String CheckInDate, String CheckOutDate,
                            String AdultsPerRoom, String ChildrenPerRoom){

        SearchHotelPage searchHotelPage = new SearchHotelPage(driver);


        try{

            selectObjects(searchHotelPage.location, driver, "SELECTBYVISIBLETEXT", Location);
            selectObjects(searchHotelPage.hotels, driver, "SELECTBYVISIBLETEXT", Hotels);
            selectObjects(searchHotelPage.roomType, driver, "SELECTBYVISIBLETEXT", RoomType);
            selectObjects(searchHotelPage.numberOfRooms, driver, "SELECTBYVISIBLETEXT", NumberOfRooms);
            passObjects(searchHotelPage.checkInDate, driver, CheckInDate);
            passObjects(searchHotelPage.checkOutDate, driver, CheckOutDate);
            selectObjects(searchHotelPage.adultPerRoom, driver, "SELECTBYVISIBLETEXT", AdultsPerRoom);
            selectObjects(searchHotelPage.childrenPerRoom, driver, "SELECTBYVISIBLETEXT", ChildrenPerRoom);

            clickObjects(searchHotelPage.searchBtn, driver);

        } catch (Exception e) {
            handleException("searchHotel", e);
        }
    }

    public void selectHotel(WebDriver driver){

        SelectHotelPage selectHotelPage = new SelectHotelPage(driver);

        try{

            clickObjects(selectHotelPage.selectHotelRadioBtn, driver);
            clickObjects(selectHotelPage.continueBtn, driver);

        } catch (Exception e) {
            handleException("selectHotel", e);
        }
    }

    public void bookHotel(WebDriver driver, String FirstName, String LastName, String BillingAddress, String CreditCardNo, String CreditCardType,
                          String ExpMonth, String ExpYear, String CVV){

        BookHotelPage bookHotelPage = new BookHotelPage(driver);
        FileGenerator generator = new FileGenerator();

        try{

            passObjects(bookHotelPage.firstName, driver, FirstName);
            passObjects(bookHotelPage.lastName, driver, LastName);
            passObjects(bookHotelPage.billingAddress, driver, BillingAddress);
            passObjects(bookHotelPage.creditCardNumber, driver, CreditCardNo);
            selectObjects(bookHotelPage.creditCardType, driver, "SELECTBYVISIBLETEXT", CreditCardType);
            selectObjects(bookHotelPage.expMonth, driver, "SELECTBYVISIBLETEXT", ExpMonth);
            selectObjects(bookHotelPage.expYear, driver, "SELECTBYVISIBLETEXT", ExpYear);
            passObjects(bookHotelPage.cvvNumber, driver, CVV);

            clickObjects(bookHotelPage.bookNowBtn, driver);

            //add dynamic wait

            WebElement orderNumber = bookHotelPage.orderNumberCreated;
            String _orderNumber = orderNumber.getAttribute("value");
            generator.writeToFile(_orderNumber);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
