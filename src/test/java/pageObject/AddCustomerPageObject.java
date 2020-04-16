package pageObject;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.XpiDriverService;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class AddCustomerPageObject {
    public WebDriver localDriver;
    public AddCustomerPageObject(WebDriver remoteDriver){
        localDriver = remoteDriver;
        PageFactory.initElements(localDriver, this);
    }

    //located elements in the page

    @FindBy(xpath = "//a[@href = '#'] //span[contains(text() , 'Customers')]")
    @CacheLookup
    WebElement customerMenu;

    @FindBy(xpath = "//span[@class='menu-item-title'][contains(text(),'Customers')]")
    @CacheLookup
    WebElement customerMenuItem;

    @FindBy(xpath = "//a[@class='btn bg-blue']")
    @CacheLookup
    WebElement addButton;

    @FindBy(id = "Email")
    @CacheLookup
    WebElement textEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement textPassword;

    @FindBy(id = "FirstName")
    @CacheLookup
    WebElement firstName;

    @FindBy(id = "LastName")
    @CacheLookup
    WebElement lastName;

    @FindBy(id = "Gender_Male")
    @CacheLookup
    WebElement genderMaleRadioButton;

    @FindBy(id = "Gender_Female")
    @CacheLookup
    WebElement genderFemaleRadioButton;

    @FindBy(xpath = "//input[@id = 'DateOfBirth']")
    @CacheLookup
    WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id = 'Company']")
    @CacheLookup
    WebElement companyName;

    @FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement customerRoles;

    @FindBy(xpath = "//*[@class = 'k-multiselect-wrap k-floatwrap']//span[contains(text(), 'Registered')]")
    @CacheLookup
    WebElement customerRolesRegistered;

    @FindBy(xpath = "//li[contains(text(), 'Administrators')]")
    @CacheLookup
    WebElement customerRolesAdministrator;

    @FindBy(xpath = "//li[contains(text(), 'Forum Moderators')]")
    @CacheLookup
    WebElement customerRolesForumModerators;

    @FindBy(xpath = "//li[contains(text(), 'Guests')]")
    @CacheLookup
    WebElement customerRolesGuests;

    @FindBy(xpath = "//li[contains(text(), 'Vendors')]")
    @CacheLookup
    WebElement customerRolesVendors;

    @FindBy(xpath = "//select[@id='VendorId']")
    @CacheLookup
    WebElement dropDownManagerOfVendor;

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    @CacheLookup
    WebElement adminContent;

    @FindBy(xpath = "//button[@name = 'save']")
    @CacheLookup
    WebElement saveButton;

    //Action methods

    public void clickCustomerMenu(){
        customerMenu.click();
    }

    public void clickCustomerMenuItem(){
        customerMenuItem.click();
    }

    public void clickAddNewButton(){
        addButton.click();
    }

    public void setTextEmail(String email){
        textEmail.clear();
        textEmail.sendKeys(email);
    }

    public void setTextPassword(String password){
        textPassword.clear();
        textPassword.sendKeys(password);
    }

    public void setFirstName(String fName){
        firstName.clear();
        firstName.sendKeys(fName);
    }

    public void setLastName(String lName){
        lastName.clear();
        lastName.sendKeys(lName);
    }

    public void setGender(String gender){
        if(gender.equals("Male")){
            genderMaleRadioButton.click();
        }else if(gender.equals("Female")){
            genderFemaleRadioButton.click();
        }else{
            genderMaleRadioButton.click();
        }
    }

    public void setDateOfBirth(String dob){
        dateOfBirth.clear();
        dateOfBirth.sendKeys(dob);
    }

    public void setCompanyName(String companyname){
        companyName.clear();
        companyName.sendKeys(companyname);
    }

    public void setCustomerRoles(String role) throws InterruptedException {
        if(role.equals("Guests")){
            localDriver.findElement(By.xpath("//span[@class = 'k-icon k-delete']")).click();
        }
        customerRoles.click();
        Thread.sleep(5000);
        WebElement listItem;
        switch (role) {
            case "Administrators":
                listItem = customerRolesAdministrator;
                break;
            case "Forum Moderators":
                listItem = customerRolesForumModerators;
                break;
            case "Registered":
                listItem = customerRolesRegistered;
                break;
            case "Vendors":
                listItem = customerRolesVendors;
                break;
            default:
                listItem = customerRolesGuests;
                break;
        }
        listItem.click();
    }

    public void setDropDownManagerOfVendor(String vendor){
        Select dropDown = new Select(dropDownManagerOfVendor);
        dropDown.selectByVisibleText(vendor);
    }

    public void setAdminContent(String message){
        adminContent.clear();
        adminContent.sendKeys(message);
    }

    public void clickSaveButton(){
        saveButton.click();
    }
}
