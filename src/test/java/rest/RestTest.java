package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@Test
public class RestTest {

    private static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://ya.ru")
            .setContentType(ContentType.JSON)
            .build();

    private static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("Яндекс"))
            .build();

    @BeforeSuite
    static void setUpAll() {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test(priority = 3, groups = "rest")
    void restTest() {
        given().when().get();
    }

    @AfterSuite
    static void tearDown() {
        RestAssured.reset();
    }
}
