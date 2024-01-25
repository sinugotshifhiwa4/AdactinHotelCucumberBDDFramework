#Author: Tshifhiwa Sinugo
# Description: Book Hotel successfully, delete booked hotel, and confirm deleted booked hotel is successful
#Date: 25/01/2024

Feature: Book Hotel Feature

  Background: User must log in
    Given User is on the login page
    When User enters username and password and clicks the login button
    Then User is navigated to the search hotel page

  @bookHotelSuccessfully
  Scenario: Book Hotel Successfully
    Given User is on the search hotel page
    When User fills in all required information and clicks the search button
    And user selects a hotel and clicks the continue button
    And User enters all required billing information and clicks the book now button
    Then User successfully books a hotel, and an order number is generated

  @deleteBooking
  Scenario: Delete existing booking
    Given User is on the search hotel page
    When the user clicks on booked itinerary
    And the user searches for a booking with the order number and clicks go
    And User selects the booking to cancel and clicks the cancel selected button and accepts the alert
    Then the booking is deleted successfully

  @confirmDeletedBooking
  Scenario: Confirm booking was deleted successfully
    Given User is on the search hotel page
    When the user clicks on booked itinerary
    And the user searches for a booking with the order number and clicks go
    Then no record of the order number is found