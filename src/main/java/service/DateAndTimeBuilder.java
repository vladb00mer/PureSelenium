package service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeBuilder {

    Date date;
    SimpleDateFormat simpleDateFormat;

    public String getFormattedDate(String format) {

        date = new Date();
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}