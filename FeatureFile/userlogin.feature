
@tag
Feature: user login
  I want to use this template for valid user login

  @tag1
  Scenario: To check valid user login
    Given I open the browser with URL "http://flights.qedgetech.com"
    Then I should see login page
    And I enter EmailId as "saranyaanbazhagan05@gmail.com"
    And i enter password as "saran123"
    When I click login
    Then I should see booking page
    When i click logout
    Then close the browser
    
    
