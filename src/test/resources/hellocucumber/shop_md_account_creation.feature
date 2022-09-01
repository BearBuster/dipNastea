
Feature: shop md account creation

  Scenario: test inability to buy item which out of stock
    Given I am on account creation form
    When I insert incorrect data
    Then must be error "Error"