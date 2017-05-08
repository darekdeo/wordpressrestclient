package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import gq.coderetort.wordpressrest.models.base.BaseEntryObject;

public class Comment extends BaseEntryObject {

    /**
     * Email address for the object author.
     * <p>Context: edit</p>
     */
    @JsonProperty("author_email") public String authorEmail;

    /**
     * IP address for the object author.
     * <p>Context: edit</p>
     */
    @JsonProperty("author_ip") public String authorIp;

    /**
     * Display name for the object author.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("author_name") public String authorName;

    /**
     * URL for the object author.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("author_url") public String authorUrl;

    /**
     * User agent for the object author.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("author_user_agent") public String authorUserAgent;

    /**
     * Karma for the object.
     * <p>Context: edit</p>
     */
    public Integer karma;

    /**
     * The id for the parent of the object.
     * <p>Context: view, edit, embed</p>
     */
    public Integer parent;

    /**
     * The id of the associated post object.
     * <p>Context: view, edit</p>
     */
    public Integer post;

    /**
     * Avatar URLs for the object author.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("author_avatar_urls") public Map<Integer, String> authorAvatarUrls;
}
