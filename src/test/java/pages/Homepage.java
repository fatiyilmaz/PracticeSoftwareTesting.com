package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //products
    @FindBy(xpath = "//div[@class='col-md-9']//a[@class='card']")
    public List<WebElement> homepageProducts;
    @FindBy(xpath = "//div[@class='mt-3']//a[number(text()) >= 1 and number(text()) <= 5]")
    public List<WebElement> pageCount;
    @FindBy(xpath = "//h2[contains(text(),'Related products')]")
    public WebElement relatedProductsText;
    @FindBy(xpath = "//div[@class='col']//*[@class='card']")
    public List<WebElement> relatedProducts;

    //categories
    @FindBy(xpath = "//a[contains(text(),' Categories ')]")
    public WebElement categoriesDropdown;
    @FindBy(xpath = "//ul[@class='dropdown-menu show']//li//a")
    public List<WebElement> categories;

    //sort
    @FindBy(xpath = "//select[@class='form-select']")
    public WebElement dropdownSort;
    @FindBy(xpath = "//a//img")
    public List<WebElement> firstPageSort;

    //SearchBox
    @FindBy(xpath = "//input[@id='search-query']")
    public WebElement searchBox;
    @FindBy(xpath = "//button[@data-test='search-submit']")
    public WebElement searchBoxClick;
    @FindBy(xpath = "//div[@data-test='search_completed']//a")
    public List<WebElement> hammerProducts;
    @FindBy(xpath = "//html[@lang='en']")
    public WebElement wholePage;
    @FindBy(xpath = "//div[contains(text(),'There are no products found.')]")
    public WebElement warningText;

    //contact
    @FindBy(xpath = "//*[contains(text(),'Contact')]")
    public WebElement contactTab;
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement contactFirstName;
    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement contactLastName;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement contactEmail;
    @FindBy(xpath = "//select[@id='subject']")
    public WebElement contactSubjectDropdown;
    @FindBy(xpath = "//*[@id='message']")
    public WebElement contactMessage;
    @FindBy(xpath = "//input[@id='attachment']")
    public WebElement contactChooseFile;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement contactSendBox;
    @FindBy(xpath = "//div[contains(text(),' Thanks for your message! We will contact you shortly. ')]")
    public WebElement contactMessageText;
    @FindBy(xpath = "//*[contains(text(),'required')]")
    public List<WebElement> contactRequired;

    //languages
    @FindBy(xpath = "//button[@id='language']")
    public WebElement buttonLangage;
    //div[@class='btn-group dropdown']
    @FindBy(xpath = "//div[@class='btn-group dropdown']")
    public WebElement buttonLangagee;

    @FindBy(xpath = "//ul[@id='dropdown-animated']//li")
    public List<WebElement> dropdownLanguages;

    @FindBy(xpath = "//a[normalize-space()='DE']")//ul[@id='dropdown-animated']//li[1]
    public WebElement dropdownLanguage1;

    @FindBy(xpath = "//a[normalize-space()='EN']")//ul[@id='dropdown-animated']//li[2]
    public WebElement dropdownLanguage2;

    @FindBy(xpath = "//ul[@id='dropdown-animated']//li[3]")
    public WebElement dropdownLanguage3;

    @FindBy(xpath = "//ul[@id='dropdown-animated']//li[4]")
    public WebElement dropdownLanguage4;

    @FindBy(xpath = "//ul[@id='dropdown-animated']//li[5]")
    public WebElement dropdownLanguage5;

    @FindBy(xpath = "//ul[@id='dropdown-animated']//li[6]")
    public WebElement dropdownLanguage6;

    @FindBy(xpath = "//a[contains(text(),'Sign in') or " +
            "contains(text(),'Einloggen') or " +
            "contains(text(),'Iniciar sesión') or " +
            "contains(text(),'Se connecter') or " +
            "contains(text(),'Inloggen') or " +
            "contains(text(),'Giriş Yap')]")
    public WebElement languageChangeVerifications;

}
