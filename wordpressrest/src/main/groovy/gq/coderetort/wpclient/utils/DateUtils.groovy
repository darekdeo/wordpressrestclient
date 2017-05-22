package gq.coderetort.wpclient.utils

import java.text.ParseException
import java.text.SimpleDateFormat

public class DateUtils {

    public static Date parseISO8601(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault())
        Date dateObject = null
        try {
            dateObject = sdf.parse(date)
        } catch (ParseException e) {
            e.printStackTrace()
        }
        dateObject
    }

    public static String parseISO8601(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault())
        sdf.format(date)
    }
}
