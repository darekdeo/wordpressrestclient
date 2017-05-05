package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import gq.coderetort.wordpressrest.models.base.EntryObject;

public class Post extends EntryObject {

    /**
     * A password to protect access to the content and excerpt.
     * <p>Context: edit</p>
     */
    public String password;

    /**
     * The format for the object.
     * <p>Context: view, edit</p>
     * <p>One of: standard</p>
     */
    public String format;

    /**
     * Whether or not the object should be treated as sticky.
     * <p>Context: view, edit</p>
     */
    public Boolean sticky;

    /**
     * The terms assigned to the object in the category taxonomy.
     * <p>Context: view, edit</p>
     */
    public List<Integer> categories;

    /**
     * The terms assigned to the object in the post_tag taxonomy.
     * <p>Context: view, edit</p>
     */
    public List<Integer> tags;

    /**
     * The number of Liveblog Likes the post has.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("liveblog_likes") public Integer liveblogLikes;
}
