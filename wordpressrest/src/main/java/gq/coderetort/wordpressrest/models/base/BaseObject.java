package gq.coderetort.wordpressrest.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import gq.coderetort.wordpressrest.models.Links;

public abstract class BaseObject {

    /**
     * Unique identifier for the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    public Integer id;

    /**
     * URL of the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    public String link;

    /**
     * Meta fields.
     * <p>Context: view, edit</p>
     */
    public List<Object> meta; // todo test if it is indeed list of meta objects

    @JsonProperty("_links") public Links links;
}
