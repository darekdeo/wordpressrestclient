package gq.coderetort.wpclient.models.base

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.Object
import gq.coderetort.wpclient.utils.DateUtils

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
abstract class EntryObject extends BaseEntryObject {

    /**
     * The globally unique identifier for the object.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    Object guid

    /**
     * The date the object was last modified, in the site’s timezone. (ISO8601)
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    String modified

    /**
     * The date the object was last modified, as GMT. (ISO8601)
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @JsonProperty("modified_gmt") String modifiedGmt

    /**
     * An alphanumeric identifier for the object unique to its type.
     * <p>Context: view, edit, embed</p>
     */
    String slug

    /**
     * The title for the object.
     * <p>Context: view, edit, embed</p>
     */
    Object title

    /**
     * The excerpt for the object.
     * <p>Context: view, edit, embed</p>
     */
    Object excerpt

    /**
     * The ID of the featured media for the object.
     * <p>Context: view, edit</p>
     */
    @JsonProperty("featured_media") Integer featuredMedia

    /**
     * Whether or not comments are open on the object.
     * <p>Context: view, edit</p>
     * <p>One of: open, closed</p>
     */
    @JsonProperty("comment_status") String commentStatus

    /**
     * Whether or not the object can be pinged.
     * <p>Context: view, edit</p>
     * <p>Context: open, closed</p>
     */
    @JsonProperty("ping_status") String pingStatus

    /**
     * The theme file to use to display the object.
     * <p>Context: view, edit</p>
     * <p>One of:</p>
     */
    String template

    /**
     * The date the object was last modified, in the site’s timezone. <p>Read only</p>
     * @return
     */
    Date getModified() {
        return DateUtils.parseISO8601(modified)
    }

    /**
     * The date the object was last modified, as GMT. <p>Read only</p>
     * @return
     */
    Date getModifiedGmt() {
        return DateUtils.parseISO8601(modifiedGmt)
    }
}
