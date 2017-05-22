package gq.coderetort.wpclient.utils

import java.text.ParseException
import java.text.SimpleDateFormat

class DateUtils {

    static def format = "YYYY-MM-DD'T'hh:mm:ss"

    static Date parseISO8601(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault())
        Date dateObject = null
        try {
            dateObject = sdf.parse(date)
        } catch (ParseException e) {
            e.printStackTrace()
        }
        dateObject
    }

    static String parseISO8601(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault())
        sdf.format(date)
    }
}
