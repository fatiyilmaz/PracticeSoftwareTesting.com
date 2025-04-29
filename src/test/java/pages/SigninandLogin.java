package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SigninandLogin {
    public SigninandLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //register
    @FindBy(xpath = "//a[@href='/auth/login']")
    public WebElement signIn;
    @FindBy(xpath = "//a[@href='/auth/register']")
    public WebElement register;
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement fistNameBox;
    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastNameBox;
    @FindBy(xpath = "//input[@id='dob']")
    public WebElement dobBox;
    @FindBy(xpath = "//input[@id='street']")
    public WebElement streetBox;
    @FindBy(xpath = "//input[@id='postal_code']")
    public WebElement postalCodeBox;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityBox;
    @FindBy(xpath = "//input[@id='state']")
    public WebElement stateBox;
    @FindBy(xpath = "//select[@id='country']")
    public WebElement countryBox;
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneBox;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerBox;

    //login
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBox;
    @FindBy(xpath = "//*[contains(text(),'Here you can manage your profile, favorites and orders.')]")
    public WebElement accountVerification;



}
