package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringFromXmlBuilder {

    private String result;

    public String buildString(String path) {

        try {
            result = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}

