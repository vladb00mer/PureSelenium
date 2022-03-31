package service;

import java.util.concurrent.TimeUnit;

public class Waiter {

    public static void waitForMilliSecs(long milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForMsTs(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
