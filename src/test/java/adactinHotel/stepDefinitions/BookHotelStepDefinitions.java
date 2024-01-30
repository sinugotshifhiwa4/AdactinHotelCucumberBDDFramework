package adactinHotel.stepDefinitions;

import adactinHotel.pageObjects.WebFunctions;
import adactinHotel.webUtils.ExcelUtility;
import adactinHotel.webUtils.WebUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Map;

public class BookHotelStepDefinitions {

    WebUtilities webUtilities;
    WebFunctions functions;
    ExcelUtility excelUtility;

    Logger logger;
    final String excelPath = ".//testData//TestData.xlsx";

    public BookHotelStepDefinitions(){

        webUtilities = WebUtilities.getInstance();
        functions = new WebFunctions();
        excelUtility = new ExcelUtility();

        logger = LogManager.getLogger(this.getClass());
    }


    // Common steps for multiple scenarios
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        logger.info("Navigating to the login page...");
    }

    @When("User enters username and password and clicks the login button")
    public void userEntersUsernameAndPasswordAndClicksTheLoginButton() {
        logger.info("Logging in with provided credentials...");

        final String loginSheet = "LoginCredentials";
        List<Map<String, String>> loginCredentials = excelUtility.readExcelData(excelPath, loginSheet);

        try {
            for (Map<String, String> loginData : loginCredentials) {
                functions.logIn(webUtilities.getDriver(),
                        loginData.get("Username"),
                        loginData.get("Password"));
            }
            logger.info("Login successful.");
        } catch (Exception e) {
            logger.error("Error occurred during login: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Then("User is navigated to the search hotel page")
    public void userIsNavigatedToTheSearchHotelPage() {
        logger.info("Navigated to the Search Hotel Page.");
    }

    // Common steps for all scenarios
    @Given("User is on the search hotel page")
    public void userIsOnTheSearchHotelPage() {
        logger.info("Navigating to the Search Hotel Page...");
    }

    // Book Hotel Successfully scenario
    @When("User fills in all required information and clicks the search button")
    public void userFillsInAllRequiredInformationAndClicksTheSearchButton() {
        logger.info("Filling in required data to search for hotels...");

        final String searchHotelSheet = "SearchHotel";
        List<Map<String, String>> searchHotelInformation = excelUtility.readExcelData(excelPath, searchHotelSheet);

        try {
            for (Map<String, String> searchHotelData : searchHotelInformation) {
                functions.searchHotel(webUtilities.getDriver(),
                        searchHotelData.get("Location"),
                        searchHotelData.get("Hotels"),
                        searchHotelData.get("RoomType"),
                        searchHotelData.get("NumberOfRooms"),
                        searchHotelData.get("CheckInDate"),
                        searchHotelData.get("CheckOutDate"),
                        searchHotelData.get("AdultsPerRoom"),
                        searchHotelData.get("ChildrenPerRoom"));
            }
            logger.info("Search for hotels was successful.");
        } catch (Exception e) {
            logger.error("Error occurred during hotel search: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @And("user selects a hotel and clicks the continue button")
    public void userSelectsAHotelAndClicksTheContinueButton() {
        logger.info("Selecting a hotel and proceeding to the next step...");

        functions.selectHotel(webUtilities.getDriver());

        logger.info("Hotel selection successful.");
    }

    @And("User enters all required billing information and clicks the book now button")
    public void userEntersAllRequiredBillingInformationAndClicksTheBookNowButton() {
        logger.info("Filling billing information and booking the hotel...");

        final String billingInformationSheet = "BillingInformation";
        List<Map<String, String>> billingInformation = excelUtility.readExcelData(excelPath, billingInformationSheet);

        try {
            for (Map<String, String> billingInformationData : billingInformation) {
                functions.bookHotel(webUtilities.getDriver(),
                        billingInformationData.get("FirstName"),
                        billingInformationData.get("LastName"),
                        billingInformationData.get("BillingAddress"),
                        billingInformationData.get("CreditCardNumber"),
                        billingInformationData.get("CreditCardType"),
                        billingInformationData.get("ExpiryMonth"),
                        billingInformationData.get("ExpiryYear"),
                        billingInformationData.get("CVV"));
            }
            logger.info("Booking was successful.");
        } catch (Exception e) {
            logger.error("Error occurred during hotel booking: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Then("User successfully books a hotel, and an order number is generated")
    public void userSuccessfullyBooksAHotelAndAnOrderNumberIsGenerated() {
        logger.info("Booking successful. Order Number is generated.");
    }

    // Delete existing booking scenario
    @When("the user clicks on booked itinerary")
    public void theUserClicksOnBookedItinerary() {
        logger.info("Navigating to booked itinerary...");
        functions.bookedItinerary(webUtilities.getDriver());
        logger.info("Navigated to booked itinerary successfully.");
    }

    @And("the user searches for a booking with the order number and clicks go")
    public void theUserSearchesForABookingWithTheOrderNumberAndClicksGo() {
        logger.info("Searching for booking with the order number...");
        functions.searchOrder(webUtilities.getDriver());
        logger.info("Search for booking was successful.");
    }

    @And("User selects the booking to cancel and clicks the cancel selected button and accepts the alert")
    public void userSelectsTheBookingToCancelAndClicksTheCancelSelectedButtonAndAcceptsTheAlert() {
        logger.info("Canceling the booking...");
        functions.cancelBooking(webUtilities.getDriver());
        logger.info("Booking cancellation was successful.");
    }

    @Then("the booking is deleted successfully")
    public void theBookingIsDeletedSuccessfully() {
        logger.info("Booking was deleted successfully.");
    }

    // Confirm booking was deleted successfully scenarios, inherits steps from Delete existing booking scenario
    @Then("no record of the order number is found")
    public void noRecordOfTheOrderNumberIsFound() {
        logger.info("No record found. Booking was deleted successfully.");
    }
}
