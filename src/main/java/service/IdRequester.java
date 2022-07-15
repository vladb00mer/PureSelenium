package service;

import io.qameta.allure.Step;
import java.util.concurrent.ThreadLocalRandom;

public class IdRequester {

    @Step("Генерация ID {size} порядка")
    public String getId(int size) {

        String res = "";

        for(int i = 0; i<size; i++) {

            res+=String.valueOf((int)(Math.random()*10));
        }
        return res;
    }
}
