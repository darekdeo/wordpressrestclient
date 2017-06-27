package gq.coderetort.wpclient.models.base

import com.google.gson.annotations.SerializedName
import gq.coderetort.wpclient.models.Object

abstract class BasePostType extends FeaturedObject {

    /**
     * Whether or not the resource should have children.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    Boolean hierarchical

    /**
     * All capabilities used by the resource.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    List<Object> capabilities

    /**
     * Human-readable labels for the resource for various contexts.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    List<Object> labels

    /**
     * REST base route for the resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @SerializedName("rest_base") String restBase
}