package stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import request.BankDetails;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class Post_Payment {

    Response response;
    BankDetails bankDetails;


    @Given("the user sends a POST request with valid payment data")
    public void theUserSendsAPOSTRequestWithValidPaymentData() {
        // Request data
        bankDetails = new BankDetails("Test","Test",1);

        // POST request ve response kaydetme
        response = given()
                .header("Content-Type", "application/json")
                .body(bankDetails)
                .when()
                .post("https://api.practicesoftwaretesting.com/payment/check");

        // prettyPrint sadece log için
        response.prettyPrint();
    }


    @Then("the API response status code must be successful")
    public void theAPIResponseStatusCodeMustBeSuccessful() {
        Assert.assertEquals(200, response.statusCode());

    }

    @And("the paymentStatus should be {string}")
    public void thePaymentStatusShouldBe(String expectedStatus) {
        assertTrue(response.prettyPrint().contains(expectedStatus));

    }
}
