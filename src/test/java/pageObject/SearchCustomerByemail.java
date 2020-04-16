package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.sql.Driver;
import java.util.List;

public class SearchCustomerByemail {
    public WebDriver localDriver;
    public WaitHelper waitHelper;
    public SearchCustomerByemail(WebDriver remoteDriver){
        localDriver = remoteDriver;
        PageFactory.initElements(localDriver, this);
        waitHelper = new WaitHelper(localDriver);
    }

    //Locating elements in the page

    @FindBy(xpath = "//input[@id='SearchEmail']")
    @CacheLookup
    WebElement searchEmailId;


    @FindBy(xpath = "//button[@id='search-customers']")
    @CacheLookup
    WebElement searchButton;

    @FindBy(xpath = "//input[@id='SearchFirstName']")
    @CacheLookup
    WebElement searchFirstName;

    @FindBy(xpath = "//input[@id='SearchLastName']")
    @CacheLookup
    WebElement searchLastName;

    @FindBy(xpath = "//table[@role='grid']")
    @CacheLookup
    WebElement tableSearchResult;

    @FindBy(xpath = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;



    // Action methods
    public Integer getNoOfRows(){
        return tableRows.size();
    }

    public Integer getNoOfColumns(){
        return tableColumns.size();
    }

    public void setSearchEmailId(String email){
        waitHelper.waitForElement(searchEmailId, 30);
        searchEmailId.clear();
        searchEmailId.sendKeys(email);
    }

    public void setSearchFirstName(String firstName){
        waitHelper.waitForElement(searchFirstName,20);
        searchFirstName.clear();
        searchFirstName.sendKeys(firstName);
    }

    public void setSearchLastName(String lastName){
        waitHelper.waitForElement(searchLastName,20);
        searchLastName.clear();
        searchLastName.sendKeys(lastName);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public Boolean searchCustomerByid(String email){
        Boolean flag = false;
        for(int i = 1; i <= getNoOfRows(); i++){
            String id = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
            if(id.equals("victoria_victoria@nopCommerce.com")){
                flag = true;
            }
        }
        return flag;
    }

    public Boolean searchCustomerByName(String firstName, String lastName){
//        Boolean flag = false;
        for(int i = 1; i <= getNoOfRows(); i++){
            String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
            System.out.println(name);
            if(name.equals(firstName+" "+lastName)){
//                flag = true;
                return true;
            }
        }
        return false;
    }
}
