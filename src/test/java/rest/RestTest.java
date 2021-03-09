package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


public class RestTest {

    private static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://ya.ru")
            .setContentType(ContentType.JSON)
            .build();

    private static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("Яндекс"))
            .build();

    @BeforeAll
    static void setUpAll() {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    @DisplayName("Rest Test")
    @Tag("rest")
    void restTest() {
        Response response = given().when().get();
        System.out.println(response.asPrettyString());
    }

    @AfterAll
    static void tearDown() {
        RestAssured.reset();
    }
}
