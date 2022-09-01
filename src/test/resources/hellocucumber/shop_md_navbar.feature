# Created by dmitrii at 9/1/2022
Feature: shop md navbar

  Scenario: test navbar dropdowns
    Given I am on any page of shop md
    When I hover on element
    Then dropdown must be "displayed"