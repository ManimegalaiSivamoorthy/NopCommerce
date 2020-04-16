Feature: Login

Scenario: Successful login with valid credentials
    Given User launches the chrome browser
    When User opens the Url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "admin@yourstore.com" and password as "admin"
    Then Click on login
    And Page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout
    Then Page title should be "Your store. Login"
    And Close the Browser

Scenario Outline: Login Data Driven
    Given User launches the chrome browser
    When User opens the Url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "<email>" and password as "<password>"
    Then Click on login
    And Page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout
    Then Page title should be "Your store. Login"
    And Close the Browser

    Examples:
            | email | password |
            | admin@yourstore.com | admin |
            | admin1@yourstore.com | admin123 |
