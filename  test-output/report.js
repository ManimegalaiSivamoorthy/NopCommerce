$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/Customers.feature");
formatter.feature({
  "name": "Customer",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a new customer",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User launches the chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.user_launches_the_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User opens the Url \"https://admin-demo.nopcommerce.com/login?ReturnUrl\u003d%2Fadmin%2F\"",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.user_opens_the_Url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters email as \"admin@yourstore.com\" and password as \"admin\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.user_enters_email_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on login",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.click_on_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view the dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.userCanViewTheDashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on the customer menu",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.userClickOnTheCustomerMenu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on the customer menu item",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.userClickOnTheCustomerMenuItem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on add new button",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.userClickOnAddNewButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view the add new customer page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.userCanViewTheAddNewCustomerPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should enter the customer details",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.userShouldEnterTheCustomerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Save button",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.clickOnSaveButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view the confirmation message \"The new customer has been added successfully.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.userCanViewTheConfirmationMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the Browser",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.close_the_Browser()"
});
formatter.result({
  "status": "passed"
});
});