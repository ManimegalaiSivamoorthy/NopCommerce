Feature: Customer
  Scenario: Add a new customer
    Given User launches the chrome browser
    When User opens the Url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    Then User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view the dashboard
    When User click on the customer menu
    And User click on the customer menu item
    Then User click on add new button
    And User can view the add new customer page
    Then User should enter the customer details
    When click on Save button
    Then User can view the confirmation message "The new customer has been added successfully."
    And Close the Browser
