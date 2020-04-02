package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
    public WebDriver localDriver;
    public LoginPageObject(WebDriver remoteDriver){
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }
    @FindBy(id = "Email")
    @CacheLookup
    WebElement textEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement textPassword;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    @CacheLookup
    WebElement loginButton;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement logoutButton;

    public void setTextEmail(String email){
        textEmail.clear();
        textEmail.sendKeys(email);
    }
    public void setTextPassword(String password){
        textPassword.clear();
        textPassword.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickLogoutButton(){
        logoutButton.click();
    }
}
