package service;

import io.qameta.allure.Step;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeBuilder {

    Date date;
    SimpleDateFormat simpleDateFormat;

    @Step("Получение текущей даты и времени в формате {format}")
    public String getFormattedDate(String format) {

        date = new Date();
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}