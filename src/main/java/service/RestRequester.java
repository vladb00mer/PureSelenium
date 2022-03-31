package service;

import io.qameta.allure.Allure;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RestRequester {

    String value = "!Default!";

    public ValidatableResponse sendRequest(String url, int statusCode, String request) {

        Allure.addAttachment("request", request);

        return given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
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

        value = response.substring(response.indexOf(">"), response.indexOf("</"+param+">"));

        return value;
    }

    public String getValueFromValidatableResponse(ValidatableResponse response, String param) {

        value = response.extract().xmlPath().getString("**.findAll { it.name() == 'tracking."+param+"' }");

        return value;
    }
}
