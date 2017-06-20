package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.FeaturedObject;

class Taxonomy extends FeaturedObject {

    /**
     * Whether or not the taxonomy should have children.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    Boolean hierarchical

    /**
     * All capabilities used by the taxonomy.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    List<Object> capabilities

    /**
     * Human-readable labels for the taxonomy for various contexts.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    List<Object> labels

    /**
     * Whether or not the term cloud should be displayed.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("show_cloud") Boolean showCloud

    /**
     * Types associated with the taxonomy.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    List<String> types

    /**
     * REST base route for the taxonomy.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("rest_base") String restBase
}