package stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static baseURL.practiceSoftwareTestingURL.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Get_Categories {

    Response getCategoriResponse;

    @And("The categories on the page are visible.")
    public void theCategoriesOnThePageAreVisible() {
        getCategoriResponse = given()
                .spec(spec)
                .when()
                .get("/categories/tree");

        getCategoriResponse.prettyPrint();
    }

    @Then("All parent and child categories are confirmed to have arrived successfully with a {int} status code")
    public void allParentAndChildCategoriesAreConfirmedToHaveArrivedSuccessfullyWithAStatusCode(int expectedStatusCode) {
        int actualStatusCode = getCategoriResponse.statusCode();
        assertEquals(expectedStatusCode, actualStatusCode);

        System.out.println("Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
    }

    @When("the request contains categoryId {string} and send a GET request")
    public void theRequestContainsCategoryIdAndSendAGETRequest(String categoryId) {
        getCategoriResponse = given()
                .spec(spec)
                .pathParam("id", categoryId)
                .when()
                .get("/categories/tree/{id}");

        getCategoriResponse.prettyPrint();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedPositiveStatusCode) {
        int actualStatusCode = getCategoriResponse.statusCode();
        assertEquals(expectedPositiveStatusCode, actualStatusCode);

        System.out.println("Expected: " + expectedPositiveStatusCode + ", Actual: " + actualStatusCode);
    }

    @And("the response should contain product list")
    public void theResponseShouldContainProductList() {
        List<?> subCategories = getCategoriResponse.jsonPath().getList("sub_categories");
        assertThat("Sub categories should not be null", subCategories, is(notNullValue()));
        assertThat("Sub categories should not be empty", subCategories, is(not(empty())));

        System.out.println("Sub categories count: " + subCategories.size());
    }

    @And("all products should have categoryId {string}")
    public void allProductsShouldHaveCategoryId(String expectedCategoryId) {
        List<String> parentIds = getCategoriResponse.jsonPath().getList("sub_categories.parent_id");
        List<String> subCategoryNames = getCategoriResponse.jsonPath().getList("sub_categories.name");

        assertThat("Parent IDs should not be null", parentIds, is(notNullValue()));
        assertThat("Parent IDs should not be empty", parentIds, is(not(empty())));

        for (int i = 0; i < parentIds.size(); i++) {
            assertThat("Parent ID for " + subCategoryNames.get(i),
                    parentIds.get(i), equalTo(expectedCategoryId));
        }

        System.out.println("Verified " + parentIds.size() + " sub-categories with parent_id: " + expectedCategoryId);
        System.out.println("Verified sub-categories: " + subCategoryNames);
    }


    @When("the request contains categoryId {string} and send a GET requestt")
    public void theRequestContainsCategoryIdAndSendAGETRequestt(String categoryId) {
        getCategoriResponse = given()
                .spec(spec)
                .pathParam("id", categoryId)
                .when()
                .get("/categories/tree/{id}");

        getCategoriResponse.prettyPrint();
    }

    @Then("the response status code should bee {int}")
    public void theResponseStatusCodeShouldBee(int expectedStatusCode) {
        int actualStatusCode = getCategoriResponse.statusCode();
        assertEquals(expectedStatusCode, actualStatusCode);

        System.out.println("Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
    }

    @Then("the response message should be {string}")
    public void theResponseMessageShouldBe(String expectedMessage) {
        String actualMessage = getCategoriResponse.jsonPath().getString("message");
        assertEquals(expectedMessage, actualMessage);

        System.out.println("Expected Message: " + expectedMessage + ", Actual Message: " + actualMessage);
    }
}
