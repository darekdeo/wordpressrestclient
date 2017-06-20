package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.BasePostType

class Taxonomy extends BasePostType {

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
}