package gq.coderetort.wpclient.utils

import java.text.ParseException

class DateUtils {

    static String format = "yyyy-MM-dd'T'hh:mm:ss"

    static Date parseISO8601(String date) {
        Date dateObject = null
        try {
            dateObject = Date.parse(format, date)
        } catch (ParseException e) {
            e.printStackTrace()
        }
        dateObject
    }

    static String parseISO8601(Date date) {
        date.format(format)
    }
}
