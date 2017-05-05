package gq.coderetort.wordpressrest.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import gq.coderetort.wordpressrest.models.Object;
import gq.coderetort.wordpressrest.utils.DateUtils;

public abstract class BaseEntryObject extends BaseObject {

    /**
     * The ID for the author of the object, if author was a user.
     * <p>Context: view, edit, embed</p>
     */
    public Integer author;

    /**
     * The content for the object.
     * <p>Context: view, edit</p>
     */
    public Object content;

    /**
     * A named status for the object.
     * <p>Context: edit</p>
     * <p>One of: publish, future, draft, pending, private</p>
     */
    public String status;

    /**
     * Type of Post/Comment for the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    public String type;

    /**
     * The date the object was published, in the site's timezone. (ISO8601)
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("date") public String date;

    /**
     * The date the object was published, as GMT. (ISO8601)
     * <p>Context: view, edit</p>
     */
    @JsonProperty("date_gmt") public String dateGmt;

    /**
     * The date the object was published, in the site’s timezone.
     * @return date or null
     */
    public Date getDate() {
        return DateUtils.parseISO8601(date);
    }

    /**
     * The date the object was published, in the site’s timezone.
     * @param date
     */
    public void setDate(Date date) {
        this.date = DateUtils.parseISO8601(date);
    }

    /**
     * The date the object was published, as GMT.
     * @return
     */
    public Date getDateGmt() {
        return DateUtils.parseISO8601(dateGmt);
    }

    /**
     * The date the object was published, as GMT.
     * @param dateGmt
     */
    public void setDateGmt(Date dateGmt) {
        this.dateGmt = DateUtils.parseISO8601(dateGmt);
    }
}
