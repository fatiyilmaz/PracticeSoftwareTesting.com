package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Payment {
    public Payment(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='btn-add-to-cart']")
    public WebElement addtocartButton;
    @FindBy(xpath = "//span[@id='lblCartCount']")
    public WebElement checkoutCart;
    @FindBy(xpath = "//table[@class='table table-hover']")
    public WebElement productInTheCart;
    @FindBy(xpath = "(//button[contains(text(),'Proceed to checkout')][1])")
    public WebElement proceedToCheckout;
    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    public WebElement accountInformationVerification;
    @FindBy(xpath = "//a[@id='menu']")
    public WebElement accountName;
    @FindBy(xpath = "//button[@data-test='proceed-2']")
    public WebElement proceedToCheckout2;
    @FindBy(xpath = "//h3[contains(text(),'Billing Address')]")
    public WebElement billingAddresVerification;
    @FindBy(xpath = "//input[@id='street']")
    public WebElement streetBox;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityBox;
    @FindBy(xpath = "//input[@id='state']")
    public WebElement stateBox;
    @FindBy(xpath = "//input[@id='country']")
    public WebElement country;
    @FindBy(xpath = "//input[@id='postal_code']")
    public WebElement postalCode;
    @FindBy(xpath = "//button[@data-test='proceed-3']")
    public WebElement proceedToCheckout3;
    @FindBy(xpath = "//select[@id='payment-method']")
    public WebElement paymentMethodDropdown;
    @FindBy(xpath = "//input[@id='bank_name']")
    public WebElement bankNameButton;
    @FindBy(xpath = "//input[@id='account_name']")
    public WebElement accountNameButton;
    @FindBy(xpath = "//input[@id='account_number']")
    public WebElement accountNumberButton;
    @FindBy(xpath = "//button[contains(text(),' Confirm ')]")
    public WebElement confirm;
    @FindBy(xpath = "//div[contains(text(),'Payment was successful')]")
    public WebElement paymentSuccessfullyVerified;
}
