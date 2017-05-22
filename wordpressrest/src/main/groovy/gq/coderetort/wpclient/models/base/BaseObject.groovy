package gq.coderetort.wpclient.models.base

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.Links

abstract class BaseObject {

    /**
     * Unique identifier for the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    Integer id

    /**
     * URL of the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    String link

    /**
     * Meta fields.
     * <p>Context: view, edit</p>
     */
    List<Object> meta // todo test if it is indeed list of meta objects

    @JsonProperty("_links") Links links
}
