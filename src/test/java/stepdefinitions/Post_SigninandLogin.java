package stepdefinitions;

import baseURL.practiceSoftwareTestingURL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import request.AddressUserRegister;
import request.UserRegister;
import request.UserRegisterResponse;
import response.ResponseDataRepository;
import utilities.ReusableMethods;
import java.util.UUID;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post_SigninandLogin extends practiceSoftwareTestingURL {

    Response registerResponse;
    UserRegister expectedData;
    AddressUserRegister addressData;
    public static String email;
    Response loginResponse;



    //apiPostRegister
    @Given("user goes to the site {string}")
    public void userGoesToTheSiteString(String url) {
        setUp();
    }

    @And("post makes the process")
    public void postMakesTheProcess() {
        String dob = "1998-02-12";
        addressData = new AddressUserRegister("California 1212", "California", "California", "United States of America (the)", "903424");

        // Benzersiz e-posta oluşturuluyor
        this.email = "fatih" + UUID.randomUUID().toString().substring(0, 6) + "@gmail.com";

        expectedData = new UserRegister("Kral", "Alex", addressData, "5555555555", dob, "asdfg12345Ff*", email);
        System.out.println("Kayıt için kullanılan e-mail: " + email);

        // Global erişim için kaydet
        ResponseDataRepository.email = expectedData.getEmail();
        ResponseDataRepository.password = expectedData.getPassword();

        registerResponse = given()
                .spec(spec)
                .body(expectedData)
                .when()
                .post("/users/register");

        registerResponse.prettyPrint();
    }

    @Then("response verifies")
    public void responseVerifies() {
        int statusCode = registerResponse.statusCode();
        if (statusCode != 200) {

            System.out.println("Beklenmeyen response: " + statusCode);
            System.out.println(registerResponse.prettyPrint());
            return;
        }

        UserRegisterResponse actualData = registerResponse.as(UserRegisterResponse.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, registerResponse.statusCode());
        assertEquals(expectedData.getFirst_name(), actualData.getRegister().getFirst_name());
        assertEquals(expectedData.getLast_name(), actualData.getRegister().getLast_name());
        assertEquals(expectedData.getPassword(), actualData.getRegister().getPassword());
        //assertEquals(expectedData.getDob(),actualData.getRegister().getDob());
        assertTrue(expectedData.getDob().contains(actualData.getRegister().getDob()));
        assertTrue(expectedData.getEmail().contains(actualData.getRegister().getEmail()));
        //assertEquals(expectedData.getEmail(),actualData.getRegister().getEmail());
        assertEquals(addressData.getStreet(), actualData.getRegister().getAddress().getStreet());
        assertEquals(addressData.getCity(), actualData.getRegister().getAddress().getCity());
        assertEquals(addressData.getState(), actualData.getRegister().getAddress().getState());
        assertEquals(addressData.getCountry(), actualData.getRegister().getAddress().getCountry());
        assertEquals(addressData.getPostal_code(), actualData.getRegister().getAddress().getPostal_code());

    }




    //apiPostLogin
    @And("user should be able to log in with the information they registered with")
    public void userShouldBeAbleToLogInWithTheInformationTheyRegisteredWith() {

        // TestDataStore'dan login bilgileri alınıyor
        String email = ResponseDataRepository.email;
        String password = ResponseDataRepository.password;

        if (email == null || password == null) {
            throw new IllegalStateException("Email veya şifre null, kayıt adımı doğru çalışmamış olabilir.");
        }

        JSONObject loginBody = new JSONObject();
        loginBody.put("email", email);
        loginBody.put("password", password);

        loginResponse = given()
                .contentType(ContentType.JSON)
                .body(loginBody.toString())
                .when()
                .post("https://api.practicesoftwaretesting.com/users/login");
    }


    @Then("user verifies that they are logged in")
    public void userVerifiesThatTheyAreLoggedIn() {
        // Login başarılı mı diye kontrol
        loginResponse.then().statusCode(200);

        // Gerekli alanları çekiyoruz
        String accessToken = loginResponse.jsonPath().getString("access_token");
        String tokenType = loginResponse.jsonPath().getString("token_type");
        int expiresIn = loginResponse.jsonPath().getInt("expires_in");

        // Token'ı diğer sınıflarda da kullanabilmek için saklıyoruz
        ResponseDataRepository.token = accessToken;

        // Kontrol amaçlı yazdır
        System.out.println("Access Token: " + accessToken);
        System.out.println("Token Type: " + tokenType);
        System.out.println("Expires In: " + expiresIn + " seconds");
        ReusableMethods.waitFor(2);
    }
}
