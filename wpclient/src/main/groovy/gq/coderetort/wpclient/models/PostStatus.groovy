package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName
import gq.coderetort.wpclient.models.base.SlugObject

class PostStatus extends SlugObject {

    /**
     * Whether posts with this resource should be private.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @SerializedName("private") Boolean isPrivate

    /**
     * Whether posts with this resource should be protected.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @SerializedName("protected") Boolean isProtected

    /**
     * Whether posts of this resource should be shown in the front end of the site.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @SerializedName("public") Boolean isPublic

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
    @SerializedName("show_in_list") Boolean showInList
}