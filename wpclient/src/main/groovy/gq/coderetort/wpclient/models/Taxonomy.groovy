package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName
import gq.coderetort.wpclient.models.base.BasePostType

class Taxonomy extends BasePostType {

    /**
     * Whether or not the term cloud should be displayed.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @SerializedName("show_cloud") Boolean showCloud

    /**
     * Types associated with the taxonomy.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    List<String> types
}