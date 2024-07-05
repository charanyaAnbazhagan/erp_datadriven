@tag
Feature: To Delete booked Ticket
  I want to use this template for to delete ticket

  @tag1
  Scenario: To delete book delete
    Given I open the browser with URL "http://flights.qedgetech.com"
    Then I should see login page
    And I enter EmailId as "saranyaanbazhagan05@gmail.com"
    And i enter password as "saran123"
    When I click login
    Then I click booking page
    Then I should see ticket
    And I delete ticket
    When i click logout
    Then close the browser
    
  