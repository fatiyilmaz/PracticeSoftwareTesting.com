package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class practiceSoftwareTestingURL {

    public static RequestSpecification spec;

    public static void setUp(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.practicesoftwaretesting.com/")
                .build();

        //En guzeli her api icin , url icin bir class olusturmak.
    }
}
