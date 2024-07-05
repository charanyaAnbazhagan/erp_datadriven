
@tag
Feature: New User Registration
  I want to use this template for checking New user registration

  @tag1Title
  Scenario: To check New User Registration
   Given I open the browser with URL "http://flights.qedgetech.com"
   Then I should see login page
   When I should click signup link
   And I enter name
   And I enter email Id
   And I select contact number
   And I select gender
   Then Ienter password
   Then I select date of birth
   And I click privacy box
   When I click register link
   Then I should see login page
   