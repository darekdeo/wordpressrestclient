package gq.coderetort.wordpressrest.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import gq.coderetort.wordpressrest.models.Links;
import gq.coderetort.wordpressrest.models.Object;

public abstract class Term {

    /**
     * Unique identifier for the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    public Integer id;

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
     * URL of the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    public String link;

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

    /**
     * Meta fields.
     * <p>Context: view, edit</p>
     */
    public List<Object> meta; // todo test if it is indeed list of meta objects

    @JsonProperty("_links") public Links links;
}
