package stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import response.ResponseContactCreatedMessage;
import response.ResponseDataRepository;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get_ContactMessage {

    Response response;

    @And("Messages sent in the contact area")
    public void messagesSentInTheContactArea() {
        if (ResponseDataRepository.token == null) {
            System.out.println("Token boş, login yapılmamış!");
            throw new IllegalStateException("Token yok, hook çalışmamış veya login başarısız.");
        }

        response = given()
                .header("Authorization", "Bearer " + ResponseDataRepository.token)
                .when()
                .get("https://api.practicesoftwaretesting.com/messages");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());
    }

    @Then("Successfully created messages are verified")
    public void successfullyCreatedMessagesAreVerified() {
        response.then().statusCode(200);

        ResponseDataRepository.responseMessages = response.jsonPath()
                .getList("data", ResponseContactCreatedMessage.class);

        System.out.println("Toplam mesaj sayısı: " + ResponseDataRepository.responseMessages.size());

        for (int i = 0; i < ResponseDataRepository.responseMessages.size(); i++) {
            ResponseContactCreatedMessage msg = ResponseDataRepository.responseMessages.get(i);
            System.out.println("Mesaj " + (i+1) + ":");
            System.out.println("ID: " + msg.id);
            System.out.println("Name: " + msg.name);
            System.out.println("Email: " + msg.email);
            System.out.println("Subject: " + msg.subject);
            System.out.println("Message: " + msg.message);
            System.out.println("User ID: " + msg.user_id);
            System.out.println("Status: " + msg.status);
            System.out.println("Created At: " + msg.created_at);
            System.out.println("-------------------------");
        }
    }

    @And("The created message is retrieved")
    public void theCreatedMessageIsRetrieved() {
        if (ResponseDataRepository.token == null) {
            throw new IllegalStateException("Token yok!");
        }

        // ✅ POST ile oluşturulan mesajın ID'sini kullan
        if (ResponseDataRepository.createdMessage == null || ResponseDataRepository.createdMessage.id == null) {
            throw new IllegalStateException("Önce mesaj oluşturulmalı! POST MESSAGE senaryosunu çalıştırın.");
        }

        String messageId = ResponseDataRepository.createdMessage.id;
        System.out.println("Getirilen mesaj ID'si: " + messageId);

        response = given()
                .header("Authorization", "Bearer " + ResponseDataRepository.token)
                .when()
                .get("https://api.practicesoftwaretesting.com/messages/" + messageId);

        System.out.println("Tek mesaj response:");
        System.out.println("response.prettyPrint() = " + response.prettyPrint());
    }

    @Then("The correct creation of the message created by the user is verified")
    public void theCorrectCreationOfTheMessageCreatedByTheUserIsVerified() {
        response.then().statusCode(200);

        ResponseContactCreatedMessage actualMsg = response.as(ResponseContactCreatedMessage.class);
        ResponseContactCreatedMessage expectedMsg = ResponseDataRepository.createdMessage;

        // ✅ Doğrulama: POST ile oluşturulan mesaj ile GET ile alınan mesaj aynı mı?
        assertEquals("ID eşleşmiyor!", expectedMsg.id, actualMsg.id);
        assertEquals("Name eşleşmiyor!", expectedMsg.name, actualMsg.name);
        assertEquals("Email eşleşmiyor!", expectedMsg.email, actualMsg.email);
        assertEquals("Subject eşleşmiyor!", expectedMsg.subject, actualMsg.subject);
        assertEquals("Message eşleşmiyor!", expectedMsg.message, actualMsg.message);

        System.out.println("✅ POST ile oluşturulan mesaj başarıyla GET ile alındı!");
        System.out.println("Mesaj detayları:");
        System.out.println("ID: " + actualMsg.id);
        System.out.println("Name: " + actualMsg.name);
        System.out.println("Email: " + actualMsg.email);
        System.out.println("Subject: " + actualMsg.subject);
        System.out.println("Message: " + actualMsg.message);
    }
}