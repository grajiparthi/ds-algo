
@tag
Feature: Test DS Algo Home Page Feature

 

 Scenario: Verify the Data Structures entries in the drop down
    When The User opens URL "https://dsportalapp.herokuapp.com/home"
    And The User clicks "Data Structures" drop down
    Then The User should see 6 different data structure entries in that dropdown
    
 
 Scenario: Verify the error message when the User clicks on Get Started buttons without Signing in
    When The User opens URL "https://dsportalapp.herokuapp.com/home"
    And The User clicks any of the "Get Started" buttons below the data structures 
    Then It should alert the user with a message "You are not logged in"
    
 Scenario: Verify the error message when the User selects data structures item from drop down without Signing in
     When The User opens URL "https://dsportalapp.herokuapp.com/home"
     And The User selects any data structures item from the drop down without Sign in
     Then It should alert the user with a message "You are not logged in"  
    
 Scenario: Verify Sign in page is displayed when the User clicks on Sign in
     When The User opens URL "https://dsportalapp.herokuapp.com/home"
     And The User clicks "Sign in"
     Then The User should be redirected to Sign in page    
    
 Scenario: Verify Register page is displayed when the User clicks on Register
     When The User opens URL "https://dsportalapp.herokuapp.com/home"
     And The User clicks "Register"
     Then The User should be redirected to Register form        