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


}
