
Feature: Search the Product on the Home page and PlaceOrder
 

  @tag1
  Scenario Outline: Search Experience in the both Home and Deals
    Given Use is on GreenCart landing page
    When User search with shortname <Veg> and extract the actual name
    Then User will search for the <Veg> shortname in Deal page 
    And Validate productname in offers page matches with Home page
 Examples:
 |Veg|
 |Tom|
 |Carr|
 |Beet|
