
@tag
Feature: Login Feature
  

  @tag1
  Scenario: Successful login with valid credentials
    Given The User is on the login page
    When The User enters a valid username and password
    And The User clicks on the login button
    Then The User should be logged in successfully
   
  @tag2
  Scenario Outline: Unsuccessful login with invalid credentials
    Given The User is on the login page
    When The User enters invalid "<username>" and "<password>"
    And The User clicks on the login button
    Then The User should see an error message indicating "<error_message>"

    Examples: 
      | username       |   password              |      error_message             |
      | winterchamps   |   invalidpassword       |  Invalid Username and Password |
      | helloworld     |   password123!@         |  Invalid Username and Password |
			| invalidusername|	 Testwinter1           |  Invalid Username and Password |