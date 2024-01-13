@tag
Feature: Test DS Algo Portal feature

 Scenario: Test DS Algo Portal Page
    Given User opens URL "https://dsportalapp.herokuapp.com"
    And click on "Get Started" button
    
    Then Page Title should be "NumpyNinja"
