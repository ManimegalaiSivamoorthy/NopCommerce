package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPageObject;

public class MyStepdefs {
    public WebDriver driver;
    public LoginPageObject loginPageObject;

    @Given("User launches the chrome browser")
    public void user_launches_the_chrome_browser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPageObject = new LoginPageObject(driver);
    }

    @When("User opens the Url {string}")
    public void user_opens_the_Url(String url) {
        driver.get(url);
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


}
