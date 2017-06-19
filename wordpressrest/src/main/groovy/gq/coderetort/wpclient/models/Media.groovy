package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.Creation

class Media extends Creation {

    /**
     * Alternative text to display when resource is not displayed.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("alt_text") String altText

    /**
     * The caption for the resource.
     * <p>Context: view, edit</p>
     */
    String caption

    /**
     * The description for the resource.
     * <p>Context: view, edit</p>
     */
    String description

    /**
     * Type of resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: image, file</p>
     */
    @JsonProperty("media_type") String mediaType

    /**
     * MIME type of resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("mime_type") String mimeType

    /**
     * Details about the resource file, specific to its type.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("media_details") Object mediaDetails

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
    @JsonProperty("source_url") String sourceUrl
}