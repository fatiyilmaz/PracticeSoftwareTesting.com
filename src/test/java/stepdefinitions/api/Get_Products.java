package stepdefinitions.api;

import baseURL.practiceSoftwareTestingURL;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_Products {

    Response getProductsResponse;

    @And("user sends a GET request to retrieve all products")
    public void userSendsAGETRequestToRetrieveAllProducts() {
        getProductsResponse = given()
                .spec(practiceSoftwareTestingURL.spec)
                .when()
                .get("/products");

        getProductsResponse.prettyPrint();
    }


    @Then("verify that the products are listed and response is successful")
    public void verifyThatTheProductsAreListedAndResponseIsSuccessful() {
        assertEquals(200,getProductsResponse.statusCode());
        System.out.println("Response: " + getProductsResponse.statusCode());

        List<String> allProductIds = new ArrayList<>();
        int currentPage = 1;
        int totalPages = 1; // İlk başta bilmediğimiz için 1 verdik

        do {
            Response response = given()
                    .spec(practiceSoftwareTestingURL.spec)
                    .queryParam("page", currentPage)
                    .when()
                    .get("/products");

            assertEquals(200, response.statusCode());

            // data listesini al
            List<Map<String, Object>> products = response.jsonPath().getList("data");
            for (Map<String, Object> product : products) {
                allProductIds.add(product.get("id").toString());
            }

            // Toplam sayfa sayısını ilk sayfadan sonra alıyoruz
            if (currentPage == 1) {
                totalPages = response.jsonPath().getInt("last_page");
            }

            currentPage++;

        } while (currentPage <= totalPages);

        System.out.println("Toplam ürün ID sayısı: " + allProductIds.size());
        for (String id : allProductIds) {
            System.out.println("Ürün ID: " + id);
        }


    }

}
