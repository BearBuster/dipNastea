Feature: shop md
  Test feature for shop md

  Scenario Outline: test apparel select
    Given I am on the shop md web site on home page
    When I select "<option>" option in navbar
    Then the page title should start with "<Title>"

    Examples:
      | option   | Title              |
      | Food     | Buy Food           |
      | Apparel  | Buy Online Apparel |
      | Homeware | Buy Homeware       |