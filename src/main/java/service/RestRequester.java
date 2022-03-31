package service;

import io.qameta.allure.Allure;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RestRequester {

    public ValidatableResponse sendRequest(String url, int statusCode, String request) {

        Allure.addAttachment("request", request);

        return given()
                .contentType("text/xml;charset=UTF-8")
                .accept(ContentType.JSON)
                .log().all()
                .baseUri(url)
                .body(request)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(statusCode);
    }

    public String getValueFromStringResponse(String response, String param) {

        String value = "!Default!";

        value = response.substring(response.indexOf(">"), response.indexOf("</"+param+">"));

        return value;
    }

    public String getValueFromValidatableResponse(ValidatableResponse response, String param) {

        String value = "!Default!";

        value = response.extract().xmlPath().getString("**.findAll { it.name() == 'tracking."+param+"' }");

        return value;
    }
}
