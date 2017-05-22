package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.BaseEntryObject

class Comment extends BaseEntryObject {

    /**
     * Email address for the object author.
     * <p>Context: edit</p>
     */
    @JsonProperty("author_email") String authorEmail

    /**
     * IP address for the object author.
     * <p>Context: edit</p>
     */
    @JsonProperty("author_ip") String authorIp

    /**
     * Display name for the object author.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("author_name") String authorName

    /**
     * URL for the object author.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("author_url") String authorUrl

    /**
     * User agent for the object author.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("author_user_agent") String authorUserAgent

    /**
     * Karma for the object.
     * <p>Context: edit</p>
     */
    Integer karma

    /**
     * The id for the parent of the object.
     * <p>Context: view, edit, embed</p>
     */
    Integer parent

    /**
     * The id of the associated post object.
     * <p>Context: view, edit</p>
     */
    Integer post

    /**
     * Avatar URLs for the object author.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("author_avatar_urls") Map<Integer, String> authorAvatarUrls
}
