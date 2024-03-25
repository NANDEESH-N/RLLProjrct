 @FirstCry
Feature: Find Stores

Background:
   Given User navigate to the FirstCry URL
   When User log into the application with credentials

 Scenario Outline: User must be able to find FirstCry store results
    When User must hover over the stores&preschool
    And User must click on the find stores from drop down
    And User switches focus to the new tab
    Then User should be on storelocator page
    When User select the "<storeType>","<state>" and "<city>"
    And User click on the search button
    Then User must be able to view the "<storeresult>"
 Examples:
    |   storeType     |       state      |         city          | storeresult |
    |    FirstCry     |  Andhra Pradesh  |   Anakapalle Town     |             |
  
