package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName
import gq.coderetort.wpclient.models.base.Creation

class Media extends Creation {

    /**
     * Alternative text to display when resource is not displayed.
     * <p>Context: view, edit, embed</p>
     */
    @SerializedName("alt_text") String altText

    /**
     * The caption for the resource.
     * <p>Context: view, edit</p>
     */
    Object caption

    /**
     * The description for the resource.
     * <p>Context: view, edit</p>
     */
    Object description

    /**
     * Type of resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: image, file</p>
     */
    @SerializedName("media_type") String mediaType

    /**
     * MIME type of resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @SerializedName("mime_type") String mimeType

    /**
     * Details about the resource file, specific to its type.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @SerializedName("media_details") MediaDetails mediaDetails

    /**
     * The id for the associated post of the resource.
     * <p>Context: view, edit</p>
     */
    Integer post

    /**
     * URL to the original resource file.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @SerializedName("source_url") String sourceUrl
}