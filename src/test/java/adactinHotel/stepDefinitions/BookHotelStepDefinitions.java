package adactinHotel.stepDefinitions;

import adactinHotel.pageObjects.WebFunctions;
import adactinHotel.webUtils.ExcelUtility;
import adactinHotel.webUtils.WebUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookHotelStepDefinitions {

    WebUtilities webUtilities;
    WebFunctions functions;
    ExcelUtility excelUtility;
    final String excelPath = ".//testData//TestData.xlsx";

    public BookHotelStepDefinitions(){

        webUtilities = WebUtilities.getInstance();
        functions = new WebFunctions();
        excelUtility = new ExcelUtility();

    }


    // Common steps for multiple scenarios
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        System.out.println("------Welcome to Login Page------");
    }

    @When("User enters username and password and clicks the login button")
    public void userEntersUsernameAndPasswordAndClicksTheLoginButton() {

        final String loginSheet = "LoginCredentials";

        List<Map<String, String>> loginCredentials = excelUtility.readExcelData(excelPath, loginSheet);

        try{

            for (Map<String, String> loginData : loginCredentials){

                functions.logIn(webUtilities.getDriver(),
                        loginData.get("Username"),
                        loginData.get("Password"));

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Then("User is navigated to the search hotel page")
    public void userIsNavigatedToTheSearchHotelPage() {

        System.out.println("------Welcome to Search Hotel Page------");
    }

    // Common steps for all scenarios
    @Given("User is on the search hotel page")
    public void userIsOnTheSearchHotelPage() {
    }

    // Book Hotel Successfully scenario
    @When("User fills in all required information and clicks the search button")
    public void userFillsInAllRequiredInformationAndClicksTheSearchButton() {
    }

    @And("user selects a hotel and clicks the continue button")
    public void userSelectsAHotelAndClicksTheContinueButton() {
    }

    @And("User enters all required billing information and clicks the book now button")
    public void userEntersAllRequiredBillingInformationAndClicksTheBookNowButton() {
    }

    @Then("User successfully books a hotel, and an order number is generated")
    public void userSuccessfullyBooksAHotelAndAnOrderNumberIsGenerated() {
    }

    // Delete existing booking scenario
    @When("the user clicks on booked itinerary")
    public void theUserClicksOnBookedItinerary() {
    }

    @And("the user searches for a booking with the order number and clicks go")
    public void theUserSearchesForABookingWithTheOrderNumberAndClicksGo() {
    }

    @And("User selects the booking to cancel and clicks the cancel selected button and accepts the alert")
    public void userSelectsTheBookingToCancelAndClicksTheCancelSelectedButtonAndAcceptsTheAlert() {
    }

    @Then("the booking is deleted successfully")
    public void theBookingIsDeletedSuccessfully() {
    }

    // Confirm booking was deleted successfully scenarios, inherits steps from Delete existing booking scenario
    @Then("no record of the order number is found")
    public void noRecordOfTheOrderNumberIsFound() {
    }
}
