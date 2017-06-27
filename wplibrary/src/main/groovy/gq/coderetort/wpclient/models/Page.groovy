package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName
import gq.coderetort.wpclient.models.base.Entry

class Page extends Entry {

    /**
     * The id for the parent of the object.
     * <p>Context: view, edit</p>
     */
    Integer parent

    /**
     * The order of the object in relation to other object of its type.
     * <p>Context: view, edit</p>
     */
    @SerializedName("menu_order") Integer menuOrder
}
