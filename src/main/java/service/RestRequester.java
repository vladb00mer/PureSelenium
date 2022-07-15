package service;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RestRequester {

    @Step("Отправка запроса по ссылке {url} и проверка status = {statusCode}")
    public ValidatableResponse sendRequest(String url, int statusCode, String request) {

        Allure.addAttachment("request", request);

        return given()
                .contentType("text/xml;charset=UTF-8")
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

    @Step("Получение значения параметра из String")
    public String getValueFromStringResponse(String response, String param) {

        String value = "!Default value from string response!";

        value = new XmlPath(response).getString("**.find { it.name() == '"+param+"' }");

        return value;
    }

    @Step("Получение значения параметра из ValidatableResponse")
    public String getValueFromValidatableResponse(ValidatableResponse response, String param) {

        String value = "!Default value from response!";

        value = response.extract().xmlPath().getString("**.findAll { it.name() == 'tracking."+param+"' }");

        return value;
    }
}
