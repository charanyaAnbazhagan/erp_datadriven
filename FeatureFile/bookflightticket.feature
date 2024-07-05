@tag
Feature: To Book Flight ticket
  I want to use this template for booking flight Ticket

  @tag1
  Scenario: To book Flight ticket
    Given I open the browser with URL "http://flights.qedgetech.com"
    Then I should see login page
    And I enter EmailId as "saranyaanbazhagan05@gmail.com"
    And i enter password as "saran123"
    When I click login
    Then I should see booking page
    When I need to select date of Flight
    And I need to select place of FlyFrom
    And i need to select place of FlyTo
    When I click Search Flight
    Then I should see Flight Available
    And I need to select the ticket
    Then I need to give name of traveller
    When I click insert order
    Then i need to see ticket booked msg
    When i click logout
    Then close the browser