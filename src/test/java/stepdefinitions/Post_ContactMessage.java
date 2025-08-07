package stepdefinitions;

import baseURL.practiceSoftwareTestingURL;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import request.ContactCreatedMessage;
import response.ResponseContactCreatedMessage;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_ContactMessage extends practiceSoftwareTestingURL {

    Response messageResponse;
    ContactCreatedMessage expectedData;

    @Given("Creates a message")
    public void createsAMessage() {
        expectedData = new ContactCreatedMessage("Test Fatih", "testfatih@gmail.com", "Payments", "Follow your dreams, never ever give up on them!");

        messageResponse = given()
                .spec(practiceSoftwareTestingURL.spec)
                .body(expectedData)
                .when()
                .post("/messages");

        messageResponse.prettyPrint();
    }

    @Then("The message is verified")
    public void theMessageIsVerified() {
        int statusCode = messageResponse.statusCode();
        if (statusCode != 200) {

            System.out.println("Beklenmeyen response: " + statusCode);
            System.out.println(messageResponse.prettyPrint());
            return;
        }

        ResponseContactCreatedMessage actualData = messageResponse.as(ResponseContactCreatedMessage.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, messageResponse.statusCode());
        assertEquals(expectedData.getName(), actualData.name);
        assertEquals(expectedData.getEmail(), actualData.email);
        assertEquals(expectedData.getSubject(), actualData.subject);
        assertEquals(expectedData.getMessage(), actualData.message);
    }
}


