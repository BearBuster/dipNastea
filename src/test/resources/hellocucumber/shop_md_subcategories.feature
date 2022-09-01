# Created by dmitrii at 9/1/2022
Feature: shop md subcategories

  Scenario: test links to subcategories
    Given I on page with navbar
    Then I click on subcategories
    When I "redirected" to page of this category