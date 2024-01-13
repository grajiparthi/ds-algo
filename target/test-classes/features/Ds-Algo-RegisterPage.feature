
@tag
Feature: Test DS Algo Register Page feature
 
  Background: 
   Given The User opens the Register Page

  @tag1
  Scenario: Test to click Register button with all fields empty
    Given The User opens the Register Page 
    When The User clicks "Register" button with all fields empty
    Then It should display an error "Please fill out this field" below Username textbox
    
   Scenario: Test to click Register button only with Username entry
    Given The User opens the Register Page 
    When The User clicks "Register" button after entering Username with other fields empty
    Then It should display an error "Please fill out this field" below Password textbox
    
   Scenario: Test to click Register button with Password Confirmation field empty
    Given The User opens the Register Page 
    When The User clicks "Register" button after entering Username and password with Password Confirmation field empty
    Then It should display an error "Please fill out this field" Password Confirmation textbox
    
   Scenario: Test to click Register button with different Passwords in Password and Password Confirmation fields
    Given The User opens the Register Page 
    When The User clicks "Register" button after entering different passwords in Password and Password Confirmation fields 
    Then It should display an error message "password_mismatch:The two password fields didn’t match."
    
   Scenario: Verify entering a password with characters less than 8
    Given The User opens the Register Page 
    When The User enters a Password with characters less than 8 
    Then It should display an error message "Password should contain atleast 8 characters"
    
    Scenario: Verify successful Registration
    Given The User opens the Register Page 
    When The User enters a valid username and matching passwords in Password and Password confirmations fields
    Then The user should be redirected to Homepage with the message "New Account Created. You are logged in as <username>"
    
  
    
  