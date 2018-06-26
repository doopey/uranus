package com.doopey.uranus.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2018/5/25.
 */
public class DateUtils {

    static ThreadLocal<DateFormat> localDateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static String today() {
        Date date = new Date(System.currentTimeMillis());
        return localDateFormat.get().format(date);
    }
}
