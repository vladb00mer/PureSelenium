package rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestTest {

    static String baseUri;

    @BeforeAll
    @DisplayName("preconditions")
    public static void setUpAll() {
        baseUri = "ya.ru";
    }

    @Test
    public void restTest() {
        given()
                .when().get()
                .then().assertThat().statusCode(200);
    }

    @AfterAll
    @DisplayName("finalization")
    public static void tearDown() {
        baseUri = null;
        RestAssured.reset();
    }

}
