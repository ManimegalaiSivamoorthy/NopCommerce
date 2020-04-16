package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AddCustomerPageObject;
import pageObject.LoginPageObject;
import pageObject.SearchCustomerByemail;

public class MyStepdefs extends Base{

    @Given("User launches the chrome browser")
    public void user_launches_the_chrome_browser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPageObject = new LoginPageObject(driver);
    }

    @When("User opens the Url {string}")
    public void user_opens_the_Url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
        loginPageObject.setTextEmail(email);
        loginPageObject.setTextPassword(password);
        Thread.sleep(3000);
    }

    @Then("Click on login")
    public void click_on_login() {
        loginPageObject.clickLoginButton();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String pagetitle) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(pagetitle, driver.getTitle());
        }
    }

    @When("User clicks on logout")
    public void user_clicks_on_logout() throws InterruptedException {
        loginPageObject.clickLogoutButton();
        Thread.sleep(5000);
    }


    @Then("Close the Browser")
    public void close_the_Browser() {
        driver.close();
        driver.quit();
    }

    //step definition for add a new customer feature

    @Then("User can view the dashboard")
    public void userCanViewTheDashboard() {
        addCustomerPageObject = new AddCustomerPageObject(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
    }

    @When("User click on the customer menu")
    public void userClickOnTheCustomerMenu() throws InterruptedException {
        Thread.sleep(300);
        addCustomerPageObject.clickCustomerMenu();
    }

    @And("User click on the customer menu item")
    public void userClickOnTheCustomerMenuItem() throws InterruptedException {
        Thread.sleep(2000);
        addCustomerPageObject.clickCustomerMenuItem();
    }

    @Then("User click on add new button")
    public void userClickOnAddNewButton() throws InterruptedException {
        Thread.sleep(2000);
        addCustomerPageObject.clickAddNewButton();
    }

    @And("User can view the add new customer page")
    public void userCanViewTheAddNewCustomerPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
    }

    @Then("User should enter the customer details")
    public void userShouldEnterTheCustomerDetails() throws InterruptedException {
        String email = randomString() + "@gamil.com";
        addCustomerPageObject.setTextEmail(email);
        addCustomerPageObject.setTextPassword("test123");
        addCustomerPageObject.setFirstName("Pavan");
        addCustomerPageObject.setLastName("Kumar");
        addCustomerPageObject.setGender("Male");
        addCustomerPageObject.setDateOfBirth("09/11/1984");
        addCustomerPageObject.setCompanyName("TestingAutomation");
        addCustomerPageObject.setCustomerRoles("Guests");
        addCustomerPageObject.setDropDownManagerOfVendor("Vendor 2");
        addCustomerPageObject.setAdminContent("This is Testing....");
    }

    @When("click on Save button")
    public void clickOnSaveButton() {
        addCustomerPageObject.clickSaveButton();
    }

    @Then("User can view the confirmation message {string}")
    public void userCanViewTheConfirmationMessage(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
    }

    //Search customer using email id

    @And("User can view the {string} page")
    public void userCanViewThePage(String pageTitle) {
        Assert.assertEquals("Customers / nopCommerce administration", driver.getTitle());
    }

    @When("User enters email id")
    public void userEntersEmailId() {
        searchCustomerByemail = new SearchCustomerByemail(driver);
        searchCustomerByemail.setSearchEmailId("victoria_victoria@nopCommerce.com");
    }

    @And("Click on search")
    public void clickOnSearch() {
        searchCustomerByemail.clickSearchButton();
    }

    @Then("User should find the email id in the search table")
    public void userShouldFindTheEmailIdInTheSearchTable() {
       Boolean status = searchCustomerByemail.searchCustomerByid("victoria_victoria@nopCommerce.com");
       Assert.assertTrue(status);
    }

    //search customer by firstname and lastname

    @When("User enters firstname and lastname")
    public void userEntersFirstnameAndLastname() {
        searchCustomerByemail = new SearchCustomerByemail(driver);
        searchCustomerByemail.setSearchFirstName("victoria");
        searchCustomerByemail.setSearchLastName("Terces");
    }

    @Then("User should find the firstname and lastname in the search table")
    public void userShouldFindTheFirstnameAndLastnameInTheSearchTable() {
        Boolean status = searchCustomerByemail.searchCustomerByName("Victoria", "Terces");
        Assert.assertEquals(true, status);
    }
}
