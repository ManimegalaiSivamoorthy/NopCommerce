package stepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObject.AddCustomerPageObject;
import pageObject.LoginPageObject;
import pageObject.SearchCustomerByemail;

public class Base {
    public WebDriver driver;
    public LoginPageObject loginPageObject;
    public AddCustomerPageObject addCustomerPageObject;
    public SearchCustomerByemail searchCustomerByemail;

    //Created for generating unique email id
    public static String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(6);
        return generatedString;
    }
}
