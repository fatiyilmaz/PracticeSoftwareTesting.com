package stepdefinitions;

import baseURL.practiceSoftwareTestingURL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_ContactMessage {

    Response getAllMessage;

    @And("Messages sent in the contact area")
    public void messagesSentInTheContactArea() {
        getAllMessage = given()
                .spec(practiceSoftwareTestingURL.spec)
                .when()
                .get("/messages");

        getAllMessage.prettyPrint();
    }

    @Then("Successfully created messages are verified")
    public void successfullyCreatedMessagesAreVerified() {
        assertEquals(200, getAllMessage.statusCode());
        System.out.println("Response: " + getAllMessage.statusCode());
    }

    @And("The created message is retrieved")
    public void theCreatedMessageIsRetrieved() {
    }

    @Then("The correct creation of the message created by the user is verified")
    public void theCorrectCreationOfTheMessageCreatedByTheUserIsVerified() {
    }

}


