package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.SlugObject;

class PostStatus extends SlugObject {

    /**
     * Whether posts with this resource should be private.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("private") Boolean isPrivate

    /**
     * Whether posts with this resource should be protected.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("protected") Boolean isProtected

    /**
     * Whether posts of this resource should be shown in the front end of the site.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @JsonProperty("public") Boolean isPublic

    /**
     * Whether posts with this resource should be publicly-queryable.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    Boolean queryable

    /**
     * Whether to include posts in the edit listing for their post type.
     * <p>Read only</p>
     * <p>Context: edit
     */
    @JsonProperty("show_in_list") Boolean showInList
}