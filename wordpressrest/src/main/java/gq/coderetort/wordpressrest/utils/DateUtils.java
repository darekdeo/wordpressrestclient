package gq.coderetort.wordpressrest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static Date parseISO8601(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date dateObject = null;
        try {
            dateObject = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateObject;
    }

    public static String parseISO8601(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        return sdf.format(date);
    }
}
