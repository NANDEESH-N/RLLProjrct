@FirstCry
Feature: Find Preschool Locator

  Background: 
    Given User navigate to the FirstCry URL
   When User log into the application with credentials

  Scenario Outline: Search for a city in the Preschool Locator
    
    When user can click on storeandpreschool
    And user can click on findpreschool
    And user switches focus to new tab
    Then user should be on "<preschool>" tab
    And user search for "<city>"
    And click on findmy preschool
    Then User should see preschools in "<expectedText>"

    Examples: 
      | city      |expectedText|preschool|
      | Agra      |            |				 |
      
