package service;

import io.qameta.allure.Step;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringFromXmlBuilder {

    private String result;

    @Step("Переводим xml в строку")
    public String buildString(String path) {

        result = "!Default!";

        try {
            result = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
