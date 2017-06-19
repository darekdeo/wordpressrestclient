package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.Entry

class Post extends Entry {

    /**
     * A password to protect access to the content and excerpt.
     * <p>Context: edit</p>
     */
    String password

    /**
     * The format for the object.
     * <p>Context: view, edit</p>
     * <p>One of: standard</p>
     */
    String format

    /**
     * Whether or not the object should be treated as sticky.
     * <p>Context: view, edit</p>
     */
    Boolean sticky

    /**
     * The terms assigned to the object in the category taxonomy.
     * <p>Context: view, edit</p>
     */
    List<Integer> categories

    /**
     * The terms assigned to the object in the post_tag taxonomy.
     * <p>Context: view, edit</p>
     */
    List<Integer> tags

    /**
     * The number of Liveblog Likes the post has.
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("liveblog_likes") Integer liveblogLikes
}
