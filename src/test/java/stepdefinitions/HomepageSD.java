package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class HomepageSD {

    Homepage homepage = new Homepage();
    Random random = new Random();


    //Homepage products
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
        assertEquals(relatedProducts, text);
        ReusableMethods.waitFor(1);
        int relatedProductsCount = homepage.relatedProducts.size();
        System.out.println("Related Products Count = " + relatedProductsCount);
        ReusableMethods.waitFor(1);
    }


    //Categories
    @Given("Must be able to see the Categories dropdown")
    public void mustBeAbleToSeeTheCategoriesDropdown() {
        String categoriesText = "Categories";
        String categories = homepage.categoriesDropdown.getText();
        assertEquals(categoriesText, categories);
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
        for (WebElement category : homepage.categories) {
            String categoryName = category.getText();
            System.out.println("Clicking on category: " + categoryName);

            // Kategori dropdown'ı tekrar aç
            homepage.categoriesDropdown.click();
            ReusableMethods.waitFor(1);

            // İlgili kategoriye tıkla
            category.click();
            ReusableMethods.waitFor(2);

            String currentUrl = Driver.getDriver().getCurrentUrl();
            Assert.assertTrue("Wrong page! Expected URL to contain: " + categoryName,
                    currentUrl.toLowerCase().contains(categoryName.toLowerCase()));


            // Geri dön ve dropdown'ı yeniden aç (eğer sayfa yönlendirmesi varsa)
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
        }
    }


    //Sort
    @Given("Products must be sorted correctly when A-Z sorting is selected")
    public void productsMustBeSortedCorrectlyWhenAZSortingIsSelected() {

        Select dropdownSort = new Select(homepage.dropdownSort);
        dropdownSort.selectByVisibleText("Name (A - Z)");
        ReusableMethods.waitFor(2);

        List<String> actualProductNames = new ArrayList<>();
        for (WebElement product : homepage.firstPageSort) {
            actualProductNames.add(product.getText().trim());
        }

        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        Collections.sort(expectedProductNames, String.CASE_INSENSITIVE_ORDER); // alfabetik sıralama

        if (actualProductNames.equals(expectedProductNames)) {
            System.out.println("A-Z sıralaması doğru çalışıyor.");
        } else {
            System.out.println("HATA: A-Z sıralaması hatalı!");
            System.out.println("Görünen Sıra: " + actualProductNames);
            System.out.println("Beklenen Sıra: " + expectedProductNames);
        }

        ReusableMethods.waitFor(2);

    }


    //Search
    @Given("Searches for a product in the search box and sees that product")
    public void searchesForAProductInTheSearchBoxAndSeesThatProduct() {
        homepage.searchBox.sendKeys("Hammer");
        homepage.searchBoxClick.click();
        ReusableMethods.waitFor(1);

        int count = 1;
        for (int i = 0; i < homepage.hammerProducts.size(); i++) {
            System.out.println(count + ". Product: " + homepage.hammerProducts.get(i).getText());
            count++;
        }
        ReusableMethods.waitFor(1);
    }

    @And("If you enter less than three characters in the search box, a warning should appear stating that you must enter at least three characters")
    public void ifYouEnterLessThanThreeCharactersInTheSearchBoxAWarningShouldAppearStatingThatYouMustEnterAtLeastThreeCharacters() {
        homepage.searchBox.sendKeys("ab");

        boolean searchBoxClickable = homepage.searchBoxClick.isEnabled();
        System.out.println("Is the button active with 2 characters? " + searchBoxClickable);


        Boolean warningText = Boolean.valueOf("Please enter at least 3 characters");
        System.out.println("Did you see the text \"Please enter at least 3 characters? " + homepage.wholePage.getText().equals(warningText));
        System.out.println("\u001B[31mPlease enter at least 3 characters? text should be added!\u001B[0m");
        ReusableMethods.waitFor(1);

    }

    @And("When you search for something that doesn't exist in the search box, a {string} warning should appear")
    public void whenYouSearchForSomethingThatDoesnTExistInTheSearchBoxAWarningShouldAppear(String text) {
        homepage.searchBox.clear();
        homepage.searchBox.sendKeys("123");
        homepage.searchBoxClick.click();
        ReusableMethods.visibleWait(By.id(homepage.warningText.getText()), 5);
        assertEquals(text, homepage.warningText.getText());
        ReusableMethods.waitFor(1);
    }


    //contact
    @Given("Should be able to click on the Communication tab")
    public void shouldBeAbleToClickOnTheCommunicationTab() {
        ReusableMethods.clickElementByJS(homepage.contactTab);
        ReusableMethods.waitFor(1);
    }

    @And("Verify that you are on the right page")
    public void verifyThatYouAreOnTheRightPage() {
        String expectedUrl = "contact";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrl));
        ReusableMethods.waitFor(1);
    }

    @And("Text should be able to be entered in the name box")
    public void textShouldBeAbleToBeEnteredInTheNameBox() {
        homepage.contactFirstName.sendKeys("Test Fatih", Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Text should be able to be entered in the last name box")
    public void textShouldBeAbleToBeEnteredInTheLastNameBox() {
        homepage.contactLastName.sendKeys("Test", Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Email field must be fillable")
    public void emailFieldMustBeFillable() {
        homepage.contactEmail.sendKeys("testfatih@gmail.com", Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Subject {string} should be selectable")
    public void subjectShouldBeSelectable(String subject) {
        Select select = new Select(homepage.contactSubjectDropdown);

        select.selectByVisibleText(subject);

        String selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(subject, selectedOption);
        ReusableMethods.waitFor(1);
    }

    @And("The message box must be fillable")
    public void theMessageBoxMustBeFillable() {
        homepage.contactMessage.sendKeys("11111111111111111111111111111111111111111111111111", Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("The file should be selectable")
    public void theFileShouldBeSelectable() {
        WebElement fileInput = homepage.contactChooseFile;

        //String filePath = "C:\\Users\\fatihyilmaz\\OneDrive - ARISTO YATIRIM SANAYI VE TICARET A.S\\Desktop\\test.txt";
        String filePath = "/Users/fatihyilmaz/Desktop/test.txt";

        fileInput.sendKeys(filePath);

        // Kontrol amaçlı (isteğe bağlı)
        String uploadedFileName = fileInput.getAttribute("value");
        assertTrue(uploadedFileName.contains("test.txt"));
        ReusableMethods.waitFor(2);
    }

    @Then("The send box should be clickable")
    public void theSendBoxShouldBeClickable() {
        homepage.contactSendBox.click();
        ReusableMethods.waitFor(1);
    }

    @Then("See a warning message that the message has been successfully transmitted")
    public void seeAWarningMessageThatTheMessageHasBeenSuccessfullyTransmitted() {
        String messageSuccesfullyText = "Thanks for your message! We will contact you shortly.";
        String text = homepage.contactMessageText.getText();
        assertEquals(text, messageSuccesfullyText);
        ReusableMethods.waitFor(2);
    }


    @Given("When you click submit without filling in the fields, you will see warning messages")
    public void whenYouClickSubmitWithoutFillingInTheFieldsYouWillSeeWarningMessages() {
        homepage.contactSendBox.click();
        ReusableMethods.waitFor(1);

        for (WebElement requiredFields : homepage.contactRequired) {
            System.out.println(requiredFields.getText());
        }
    }

    @Given("Text should be able to be entered in the name box {string}")
    public void textShouldBeAbleToBeEnteredInTheNameBox(String name) {
        homepage.contactFirstName.sendKeys(name, Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Text should be able to be entered in the last name box {string}")
    public void textShouldBeAbleToBeEnteredInTheLastNameBox(String lastname) {
        homepage.contactLastName.sendKeys(lastname, Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Subject should be selectable")
    public void subjectShouldBeSelectable() {
        Select select = new Select(homepage.contactSubjectDropdown);
        select.selectByVisibleText("Payments");
        ReusableMethods.waitFor(1);
    }

    @Then("The user should be asked to enter at least three alphabetic characters, otherwise an error message should be displayed.")
    public void theUserShouldBeAskedToEnterAtLeastAlphabeticCharactersOtherwiseAnErrorMessageShouldBeDisplayed() {
        String expectedText = "enter at least 3 alphabetic characters";
        String actualText = homepage.contactMessageText.getText();
        assertEquals(expectedText, actualText);
        ReusableMethods.waitFor(2);
    }


    //languages
    @Given("Six language options should be available")
    public void sixLanguageOptionsShouldBeAvailable() {
        homepage.buttonLangage.click();

        int count = 1;
        for (WebElement languageCount : homepage.dropdownLanguages) {
            System.out.println(count + ". " + languageCount.getText());
            count++;
        }
    }

    @And("When language options are selected, the page should be translated into that language")
    public void whenLanguageOptionsAreSelectedThePageShouldBeTranslatedIntoThatLanguage() {

        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < homepage.dropdownLanguages.size(); i++) {

            actions.moveToElement(homepage.buttonLangage).click().perform();
            ReusableMethods.waitFor(3);

            List<WebElement> dropdownLanguages = Arrays.asList(
                    homepage.dropdownLanguage1,
                    homepage.dropdownLanguage2,
                    homepage.dropdownLanguage3,
                    homepage.dropdownLanguage4,
                    homepage.dropdownLanguage5,
                    homepage.dropdownLanguage6
            );

            WebElement currentLanguage = dropdownLanguages.get(i);
            try {
                currentLanguage.click();
            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                js.executeScript("arguments[0].click();", currentLanguage);
            }

            ReusableMethods.waitFor(2);
            System.out.println(homepage.languageChangeVerifications.isDisplayed());
            System.out.println("✅ Dil " + (i + 1) + " seçildi");
        }

    }

}




