package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SigninandLogin;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SigninandLoginSD {

    WebDriverWait wait;
    String expectedUrl;
    SigninandLogin signinandLogin = new SigninandLogin();

    //register

    @Given("Homepage login")
    public void homepageLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("practicesoftwaretesting"));
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        expectedUrl = Driver.getDriver().getCurrentUrl();
        ReusableMethods.waitFor(1);
    }

    @And("Verify homepage")
    public void verifyHomepage() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assert expectedUrl.contains(actualUrl);
        ReusableMethods.waitFor(2);
    }

    @Given("Sees sign in and clicks")
    public void seesSignInAndClicks() {
        System.out.println(signinandLogin.signIn.isDisplayed());
        ReusableMethods.waitFor(1);
        signinandLogin.signIn.click();
        ReusableMethods.waitFor(1);
    }

    @And("Clicks Register your account because your does not have an account")
    public void clicksRegisterYourAccountBecauseYourDoesNotHaveAnAccount() {
        signinandLogin.register.click();
        ReusableMethods.waitFor(1);
    }

    @And("Sees that you are on the Register page")
    public void seesThatYouAreOnTheRegisterPage() {
        assert Driver.getDriver().getCurrentUrl().contains("register");
        ReusableMethods.waitFor(1);
    }

    @And("Enters a string value in the First name box")
    public void entersAStringValueInTheFirstNameBox() {
        signinandLogin.fistNameBox.sendKeys("Kral", Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Enters a string value in the Last name box")
    public void entersAStringValueInTheLastNameBox() {
        signinandLogin.lastNameBox.sendKeys("Alex", Keys.ENTER);
        ReusableMethods.waitFor(1);
    }

    @And("Selects date from Date of birth field")
    public void selectsDateFromDateOfBirthField() {
        signinandLogin.dobBox.sendKeys("12.02.1998");
        ReusableMethods.waitFor(1);
    }

    @And("Enters string and valid value in the Street box")
    public void entersStringAndValidValueInTheStreetBox() {
        signinandLogin.streetBox.sendKeys("California 1212");
        ReusableMethods.waitFor(1);
    }

    @And("Enters valid value in Postal code")
    public void entersValidValueInPostalCode() {
        signinandLogin.postalCodeBox.sendKeys("903424");
        ReusableMethods.waitFor(1);
    }

    @And("Enters string value in the City box")
    public void entersStringValueInTheCityBox() {
        signinandLogin.cityBox.sendKeys("California");
        ReusableMethods.waitFor(1);
    }

    @And("Enters string in the State box")
    public void entersStringInTheStateBox() {
        signinandLogin.stateBox.sendKeys("California");
        ReusableMethods.waitFor(1);
    }

    @And("Selects a country from the country field")
    public void selectsACountryFromTheCountryField() {
        Select select = new Select(signinandLogin.countryBox);
        select.selectByVisibleText("United States of America (the)");
        ReusableMethods.waitFor(1);
    }

    @And("Enters valid value in the phone box")
    public void entersValidValueInThePhoneBox() {
        signinandLogin.phoneBox.sendKeys("5555555555");
        ReusableMethods.waitFor(1);
    }

    @And("Enters string and valid value in Email box")
    public void entersStringAndValidValueInEmailBox() {
        signinandLogin.emailBox.sendKeys("testusa1212@gmail.com");
        ReusableMethods.waitFor(1);
    }

    @And("The password box is filled in according to the criteria")
    public void thePasswordBoxIsFilledInAccordingToTheCriteria() {
        signinandLogin.passwordBox.sendKeys("asdfg12345Ff*");
        ReusableMethods.waitFor(1);
    }

    @And("Clicks on the Register box")
    public void clicksOnTheRegisterBox() {
        signinandLogin.registerBox.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Verifies that the registration")
    public void verifiesThatTheRegistration() {
        assert Driver.getDriver().getCurrentUrl().contains("login");
        ReusableMethods.waitFor(1);
    }

    //login

    @Given("Clicks sign in to log in")
    public void clicksSignInToLogIn() {
        signinandLogin.signIn.click();
        ReusableMethods.waitFor(1);
    }

    @And("Sees that you are on the Login page")
    public void seesThatYouAreOnTheLoginPage() {
        assert Driver.getDriver().getCurrentUrl().contains("login");
        ReusableMethods.waitFor(1);
    }

    @And("Enters string and valid value in the Email address box")
    public void entersStringAndValidValueInTheEmailAddressBox() {
        signinandLogin.emailBox.sendKeys("testusa1212@gmail.com");
        ReusableMethods.waitFor(1);
    }

    @And("Fill in the password box")
    public void fillInThePasswordBox() {
        signinandLogin.passwordBox.sendKeys("asdfg12345Ff*");
        ReusableMethods.waitFor(1);
    }

    @And("Clicks on the Login box")
    public void clicksOnTheLoginBox() {
        signinandLogin.loginBox.click();
        ReusableMethods.waitFor(1);
    }


    @Then("Verifies that you have successfully opened your account")
    public void verifiesThatYouHaveSuccessfullyOpenedYourAccount() {
        String verification = "Here you can manage your profile, favorites and orders.";
        assertTrue(verification.contains(signinandLogin.accountVerification.getText()));
        ReusableMethods.waitFor(1);
    }
}
