package adactinHotel.pageObjects;

import adactinHotel.webPageObjects.LoginPage;
import adactinHotel.webPageObjects.SearchHotelPage;
import adactinHotel.webUtils.CustomExceptions;
import adactinHotel.webUtils.WebActions;
import org.openqa.selenium.WebDriver;

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
                            String AdultPerRoom, String ChildrenPerRoom){

        SearchHotelPage searchHotelPage = new SearchHotelPage(driver);


        try{

            selectObjects(searchHotelPage.location, driver, "SELECTBYVISIBLETEXT", Location);
            selectObjects(searchHotelPage.hotels, driver, "SELECTBYVISIBLETEXT", Hotels);
            selectObjects(searchHotelPage.roomType, driver, "SELECTBYVISIBLETEXT", RoomType);
            selectObjects(searchHotelPage.numberOfRooms, driver, "SELECTBYVISIBLETEXT", NumberOfRooms);
            passObjects(searchHotelPage.checkInDate, driver, CheckInDate);
            passObjects(searchHotelPage.checkOutDate, driver, CheckOutDate);
            selectObjects(searchHotelPage.adultPerRoom, driver, "SELECTBYVISIBLETEXT", AdultPerRoom);
            selectObjects(searchHotelPage.childrenPerRoom, driver, "SELECTBYVISIBLETEXT", ChildrenPerRoom);

            clickObjects(searchHotelPage.searchBtn, driver);


        } catch (Exception e) {
            handleException("searchHotel", e);
        }
    }
}
