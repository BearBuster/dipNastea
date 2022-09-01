# Created by dmitrii at 8/31/2022
Feature: shop md login

  Scenario: test login
    Given I am on home page
    When I insert incorrect data into login form
    Then must be "error" in login form