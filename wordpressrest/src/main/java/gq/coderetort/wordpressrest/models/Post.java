package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

import gq.coderetort.wordpressrest.utils.DateUtils;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Post {

    /**
     * The date the object was published, in the site's timezone. (ISO8601)
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    @JsonProperty("date") public String date;

    /**
     * The date the object was published, as GMT. (ISO8601)
     * <p>
     *     Context: view, edit
     * </p>
     */
    @JsonProperty("date_gmt") public String dateGmt;

    /**
     * The globally unique identifier for the object.
     * <p>
     *     Read only
     * </p>
     * <p>
     *     Context: view, edit
     * </p>
     */
    public Object guid;

    /**
     * Unique identifier for the object.
     * <p>
     *     Read only
     * </p>
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public Integer id;

    /**
     * URL to the object.
     * <p>
     *     Read only
     * </p>
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public String link;

    /**
     * The date the object was last modified, in the site’s timezone. (ISO8601)
     * <p>
     *     Read only
     * </p>
     * <p>
     *     Context: view, edit
     * </p>
     */
    public String modified;

    /**
     * The date the object was last modified, as GMT. (ISO8601)
     * <p>
     *     Read only
     * </p>
     * <p>
     *     Context: view, edit
     * </p>
     */
    @JsonProperty("modified_gmt") public String modifiedGmt;

    /**
     * An alphanumeric identifier for the object unique to its type.
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public String slug;

    /**
     * A named status for the object.
     * <p>
     *     Context: edit
     * </p>
     * <p>
     *     One of: publish, future, draft, pending, private
     * </p>
     */
    public String status;

    /**
     * Type of Post for the object.
     * <p>
     *     Read only
     * </p>
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public String type;

    /**
     * A password to protect access to the content and excerpt.
     * <p>
     *     Context: edit
     * </p>
     */
    public String password;

    /**
     * The title for the object.
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public Object title;

    /**
     * The content for the object.
     * <p>
     *     Context: view, edit
     * </p>
     */
    public Object content;

    /**
     * The ID for the author of the object.
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public Integer author;

    /**
     * The excerpt for the object.
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    public Object excerpt;

    /**
     * The ID of the featured media for the object.
     * <p>
     *     Context: view, edit
     * </p>
     */
    @JsonProperty("featured_media") public Integer featuredMedia;

    /**
     * Whether or not comments are open on the object.
     * <p>
     *     Context: view, edit
     * </p>
     * <p>
     *     One of: open, closed
     * </p>
     */
    @JsonProperty("comment_status") public String commentStatus;

    /**
     * Whether or not the object can be pinged.
     * <p>
     *     Context: view, edit
     * </p>
     * <p>
     *     Context: open, closed
     * </p>
     */
    @JsonProperty("ping_status") public String pingStatus;

    /**
     * The format for the object.
     * <p>
     *     Context: view, edit
     * </p>
     * <p>
     *     One of: standard
     * </p>
     */
    public String format;

    /**
     * Meta fields.
     * <p>
     *     Context: view, edit
     * </p>
     */
    public List<Object> meta; // todo test if it is indeed list of meta objects

    /**
     * Whether or not the object should be treated as sticky.
     * <p>
     *     Context: view, edit
     * </p>
     */
    public Boolean sticky;

    /**
     * The theme file to use to display the object.
     * <p>
     *     Context: view, edit
     * </p>
     * <p>
     *     One of:
     * </p>
     */
    public String template;

    /**
     * The terms assigned to the object in the category taxonomy.
     * <p>
     *     Context: view, edit
     * </p>
     */
    public List<Integer> categories;

    /**
     * The terms assigned to the object in the post_tag taxonomy.
     * <p>
     *     Context: view, edit
     * </p>
     */
    public List<Integer> tags;

    /**
     * The number of Liveblog Likes the post has.
     * <p>
     *     Context: view, edit, embed
     * </p>
     */
    @JsonProperty("liveblog_likes") public Integer liveblogLikes;

    @JsonProperty("_links") public Links links;

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

    /**
     * The date the object was last modified, in the site’s timezone. <p>Read only</p>
     * @return
     */
    public Date getModified() {
        return DateUtils.parseISO8601(modified);
    }

    /**
     * The date the object was last modified, as GMT. <p>Read only</p>
     * @return
     */
    public Date getModifiedGmt() {
        return DateUtils.parseISO8601(modifiedGmt);
    }
}
