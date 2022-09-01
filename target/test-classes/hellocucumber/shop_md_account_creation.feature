Feature: shop md account creation

  Scenario : test unability to buy item which out of stockk
    Given I am on account creation formm
    When I insert incorrect dataa
    Then must be errorr "Error"