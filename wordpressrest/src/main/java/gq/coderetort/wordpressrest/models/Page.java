package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Page extends EntryObject {

    /**
     * The id for the parent of the object.
     * <p>
     *     Context: view, edit
     * </p>
     */
    public Integer parent;

    /**
     * The order of the object in relation to other object of its type.
     * <p>
     *     Context: view, edit
     * </p>
     */
    @JsonProperty("menu_order") public Integer menuOrder;
}
