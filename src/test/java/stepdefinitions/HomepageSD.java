package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.Homepage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class HomepageSD {

    Homepage homepage = new Homepage();
    Random random = new Random();

    @Given("Sees nine products on the homepage")
    public void seesNineProductsOnTheHomepage() {
        String homepageProductCount = "9";
        System.out.println("Homepage Product Count = " + homepage.homepageProducts.size());
        ReusableMethods.waitFor(1);
        String homepageProducts = String.valueOf(homepage.homepageProducts.size());
        assertEquals(homepageProducts, homepageProductCount);
        ReusableMethods.waitFor(1);
    }

    @And("Goes to page five and sees nine products on each page")
    public void goesToPageFiveAndSeesNineProductsOnEachPage() {
        String count = "9";
        for (WebElement pageCount : homepage.pageCount) {
            pageCount.click();
            String productCount = String.valueOf(homepage.homepageProducts.size());
            assertEquals(count, productCount);
            ReusableMethods.waitFor(1);
        }
    }

    @And("Random clicks on a product and verifies that your has entered the product")
    public void randomClicksOnAProductAndVerifiesThatYourHasEnteredTheProduct() {
        int randomIndex = random.nextInt(homepage.homepageProducts.size());
        WebElement element = homepage.homepageProducts.get(randomIndex);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
        ReusableMethods.waitFor(2);
        System.out.println("Product Index: " + randomIndex);
        ReusableMethods.waitFor(1);
        String url = Driver.getDriver().getCurrentUrl();
        String sku = url.substring(url.lastIndexOf("/") + 1).trim(); // Son '/' sonrası kısmı al ve trim et
        System.out.println("Product SKU: " + sku);

    }

    @And("Should be able to see more products in the related products section")
    public void shouldBeAbleToSeeMoreProductsInTheRelatedProductsSection() {
        String relatedProducts = "Related products";
        String text = homepage.relatedProductsText.getText();
        assertEquals(relatedProducts,text);
        ReusableMethods.waitFor(1);
        int relatedProductsCount = homepage.relatedProducts.size();
        System.out.println("Related Products Count = " + relatedProductsCount);
        ReusableMethods.waitFor(1);
    }

    @Given("Must be able to see the Categories dropdown")
    public void mustBeAbleToSeeTheCategoriesDropdown() {
        String categoriesText = "Categories";
        String categories = homepage.categoriesDropdown.getText();
        assertEquals(categoriesText,categories);
        ReusableMethods.waitFor(1);
    }

    @And("Ability to see five different categories in the Categories tab")
    public void abilityToSeeFiveDifferentCategoriesInTheCategoriesTab() {
        homepage.categoriesDropdown.click();
        int count = 1;
        for (int i = 0; i < homepage.categories.size(); i++) {
            System.out.println(count + ". " + "Categori = " + homepage.categories.get(i).getText());
            count++;
        }
        ReusableMethods.waitFor(1);
    }

    @Then("Enters these categories and verifies that it is on the right page")
    public void entersTheseCategoriesAndVerifiesThatItIsOnTheRightPage() {
        for (int i = 0; i < homepage.categories.size(); i++) {
            homepage.categories.get(i).click();
            i++;
        }
    }


}
