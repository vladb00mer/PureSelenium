package service;

import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public class Waiter {

    @Step("Ждем {milliSeconds} милисекунд")
    public static void waitForMilliSecs(long milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Ждем {milliSeconds} милисекунд")
    public static void waitForMsTs(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
