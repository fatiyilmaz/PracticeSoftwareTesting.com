package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.Homepage;
import pages.Payment;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertTrue;

public class PaymentSD {

    Homepage homepage = new Homepage();
    Random random = new Random();
    Payment payment = new Payment();

    @Given("A product is randomly selected from the homepage")//Bir ürün ana sayfadan rastgele seçilir
    public void aProductIsRandomlySelectedFromTheHomepage() {
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
        ReusableMethods.waitFor(2);
    }

    @And("Click the Add to Cart button")
    public void clickTheAddToCartButton() {//Sepete Ekle düğmesini tıklayın
        ReusableMethods.clickElementByJS(payment.addtocartButton);
        ReusableMethods.waitFor(2);
    }

    @And("Click on the cart to purchase the added product")//Eklenen ürünü satın almak için sepete tıklayın
    public void clickOnTheCartToPurchaseTheAddedProduct() {
        ReusableMethods.clickElementByJS(payment.checkoutCart);
        ReusableMethods.waitFor(2);
    }

    @And("They see the product they selected in the cart")//Seçtikleri ürünü sepetlerinde görürler
    public void theySeeTheProductTheySelectedInTheCart() {
        System.out.println("Selected product = " + payment.productInTheCart.getText());
        ReusableMethods.waitFor(2);
    }

    @And("Click the Proceed to Checkout button")//Ödemeye Devam Et düğmesine tıklayın
    public void clickTheProceedToCheckoutButton() {
        payment.proceedToCheckout.click();
        ReusableMethods.waitFor(2);
    }

    @And("The session account is verified. You are prompted to proceed to the payment screen")//Oturum hesabı doğrulandı. Ödeme ekranına geçmeniz isteniyor.
    public void theSessionAccountIsVerifiedYouArePromptedToProceedToThePaymentScreen() {
        System.out.println(payment.accountInformationVerification.getText());
        System.out.println("Account verified. " + payment.accountName.getText() + " You have logged in." + payment.accountInformationVerification.getText().contains(payment.accountName.getText()));
        ReusableMethods.waitFor(2);
        payment.proceedToCheckout2.click();
    }

    @And("The Billing Address fields appear to be filled in, and you can proceed")//Fatura Adresi alanları doldurulmuş görünüyor ve devam edebilirsiniz.
    public void theBillingAddressFieldsAppearToBeFilledInAndYouCanProceed() {
        String text = "Billing Address";
        assertTrue(payment.billingAddresVerification.getText().contains(text));
        System.out.println("You are at the billing address.");

        List<WebElement> billingFields = Arrays.asList(
                payment.streetBox,
                payment.cityBox,
                payment.stateBox,
                payment.country,
                payment.postalCode
        );

        for (WebElement eachField : billingFields) {
            String value = eachField.getAttribute("value");
            Assert.assertTrue(!value.isEmpty(), "Alan boş geldi: " + eachField.toString());
            ReusableMethods.waitFor(2);
        }

        payment.proceedToCheckout3.click();
    }

    @And("Bank transfer payment method is selected")//Banka havalesi ödeme yöntemi seçildi
    public void bankTransferPaymentMethodIsSelected() {

        Select select = new Select(payment.paymentMethodDropdown);
        select.selectByVisibleText("Bank Transfer");
    }

    @And("Enter the bank name")
    public void enterTheBankName() {
        payment.bankNameButton.sendKeys("Test");
        ReusableMethods.waitFor(1);
    }

    @And("Enter account name")
    public void enterAccountName() {
        payment.accountNameButton.sendKeys("Test");
        ReusableMethods.waitFor(1);
    }

    @And("Enter account number")
    public void enterAccountNumber() {
        payment.accountNumberButton.sendKeys("1");
        ReusableMethods.waitFor(1);
    }

    @Then("Payment successfully verified")//Ödeme başarıyla doğrulandı
    public void paymentSuccessfullyVerified() {
        payment.confirm.click();
        ReusableMethods.waitFor(2);

        String text = "Payment was successful";

        assertTrue(payment.paymentSuccessfullyVerified.getText().contains(text));
        System.out.println("Payment successfully verified");
        ReusableMethods.waitFor(2);
    }

}
