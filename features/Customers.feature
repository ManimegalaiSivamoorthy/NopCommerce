Feature: Customer
  @sanity
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

  @sanity
  Scenario: Search customer by email id
    Given User launches the chrome browser
    When User opens the Url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    Then User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view the dashboard
    When User click on the customer menu
    And User click on the customer menu item
    And User can view the "Customers / nopCommerce administration" page
    When User enters email id
    And Click on search
    Then User should find the email id in the search table
    And Close the Browser

  Scenario: Search customer by firstname and lastname
    Given User launches the chrome browser
    When User opens the Url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    Then User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view the dashboard
    When User click on the customer menu
    And User click on the customer menu item
    And User can view the "Customers / nopCommerce administration" page
    When User enters firstname and lastname
    And Click on search
    Then User should find the firstname and lastname in the search table
    And Close the Browser