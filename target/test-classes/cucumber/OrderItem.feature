@tag
Feature: order an item in an ecom site

  Background:
    Given Go to ecommers site

  @tag2
  Scenario Outline: Login with valid credentials
    Given login using "<username>" and "<password>"
    When add product "<Product>" to card
    And checkout "<Product>" and submit order
    Then Pay and Place Order

  Examples:
    | username          | password   | Product     |
    | goutham@gmail.com | Goutham@6  | ZARA COAT 3 |
