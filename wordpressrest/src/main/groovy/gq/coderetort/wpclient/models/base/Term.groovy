package gq.coderetort.wpclient.models.base

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.Links

abstract class Term extends BaseObject {

    /**
     * Number of published posts for the term.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    Integer count

    /**
     * HTML description of the term.
     * <p>Context: view, edit</p>
     */
    String description

    /**
     * HTML title for the term.
     * <p>Context: view, edit, embed</p>
     */
    String name

    /**
     * An alphanumeric identifier for the term unique to its type.
     * <p>Context: view, edit, embed</p>
     */
    String slug

    /**
     * Type attribution for the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: category, post_tag, nav_menu, link_category, post_format</p>
     */
    String taxonomy

    @JsonProperty("_links") Links links
}
