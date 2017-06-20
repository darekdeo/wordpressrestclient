package gq.coderetort.wpclient.models.base

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.Object

abstract class Entry extends Creation {

    /**
     * The content for the object.
     * <p>Context: view, edit</p>
     */
    Object content

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
}
