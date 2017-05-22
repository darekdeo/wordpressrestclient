package gq.coderetort.wpclient.models.base

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.Object
import gq.coderetort.wpclient.utils.DateUtils

abstract class BaseEntryObject extends BaseObject {

    /**
     * The ID for the author of the object, if author was a user.
     * <p>Context: view, edit, embed</p>
     */
    Integer author

    /**
     * The content for the object.
     * <p>Context: view, edit</p>
     */
    Object content

    /**
     * A named status for the object.
     * <p>Context: edit</p>
     * <p>One of: publish, future, draft, pending, private</p>
     */
    String status

    /**
     * Type of Post/Comment for the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    String type

    /**
     * The date the object was published, in the site's timezone. (ISO8601)
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("date") String date

    /**
     * The date the object was published, as GMT. (ISO8601)
     * <p>Context: view, edit</p>
     */
    @JsonProperty("date_gmt") String dateGmt

    /**
     * The date the object was published, in the site’s timezone.
     * @return date or null
     */
    Date getDate() {
        return DateUtils.parseISO8601(date)
    }

    /**
     * The date the object was published, in the site’s timezone.
     * @param date
     */
    void setDate(Date date) {
        this.date = DateUtils.parseISO8601(date)
    }

    /**
     * The date the object was published, as GMT.
     * @return
     */
    Date getDateGmt() {
        return DateUtils.parseISO8601(dateGmt)
    }

    /**
     * The date the object was published, as GMT.
     * @param dateGmt
     */
    void setDateGmt(Date dateGmt) {
        this.dateGmt = DateUtils.parseISO8601(dateGmt)
    }
}
