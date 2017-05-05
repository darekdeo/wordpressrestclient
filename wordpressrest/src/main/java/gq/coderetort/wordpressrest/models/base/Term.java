package gq.coderetort.wordpressrest.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import gq.coderetort.wordpressrest.models.Links;

public abstract class Term extends BaseObject {

    /**
     * Number of published posts for the term.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    public Integer count;

    /**
     * HTML description of the term.
     * <p>Context: view, edit</p>
     */
    public String description;

    /**
     * HTML title for the term.
     * <p>Context: view, edit, embed</p>
     */
    public String name;

    /**
     * An alphanumeric identifier for the term unique to its type.
     * <p>Context: view, edit, embed</p>
     */
    public String slug;

    /**
     * Type attribution for the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: category, post_tag, nav_menu, link_category, post_format</p>
     */
    public String taxonomy;

    @JsonProperty("_links") public Links links;
}
