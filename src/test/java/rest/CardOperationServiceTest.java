package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import service.DataBaseRequester;
import service.StringFromXmlBuilder;
import java.sql.ResultSet;
import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Запрос CardOperationService")
class CardOperationServiceTest {

    StringFromXmlBuilder stringFromXmlBuilder;
    String request;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    DataBaseRequester dataBaseRequester;
    ResultSet resultSet;
    String url;
    String login;
    String password;
    String value;

    @BeforeAll
    @DisplayName("Инициализация")
    void setUp() {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("")
                .setPort(8080)
                .setBasePath("")
                .setContentType("text/xml;charset=UTF-8")
                .setAccept(ContentType.XML)
                .log(LogDetail.ALL)
                .build();
        RestAssured.requestSpecification = requestSpecification;

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(202)
                .build();
        RestAssured.responseSpecification = responseSpecification;

        stringFromXmlBuilder = new StringFromXmlBuilder();

        url = "";
        login = "";
        password = "";

        dataBaseRequester = new DataBaseRequester(url, login, password);
    }

    @Test
    @Tag("regress")
    @DisplayName("")
    void cardOperationLockCardWAY4Test() {

        request = stringFromXmlBuilder.buildString("./xml/CardOperationService/LockCardRequest.xml");

        given()
                .body(request)
            .when()
                .post()
            .then()
                .log().all();

        resultSet = dataBaseRequester.executeStatement("select");

        value = dataBaseRequester.getResultSetValueByLabel(resultSet, "ac");

        Assertions.assertEquals("05", value, "!Значение не соответствует ожидаемому!");
    }

    @AfterAll
    @DisplayName("Утилизация")
    void tearDown() {

        dataBaseRequester.closeConnection();
        request = null;
        stringFromXmlBuilder = null;
        requestSpecification = null;
        dataBaseRequester = null;
        resultSet = null;
        url = null;
        login = null;
        password = null;
        value = null;
    }
}