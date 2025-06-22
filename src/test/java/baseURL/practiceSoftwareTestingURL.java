package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class practiceSoftwareTestingURL {

    protected RequestSpecification spec;//protectec koymak; extend yapilmadan ulasilcak, kismi encapsualtion

    public void setUp(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://api.practicesoftwaretesting.com/").build();

        //En guzeli her api icin , url icin bir class olusturmak.
    }
}
