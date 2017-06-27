package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName

class Link {

    @SerializedName("name") String name
    @SerializedName("taxonomy") String taxonomy
    @SerializedName("href") String href
    @SerializedName("embeddable") Boolean embeddable
    @SerializedName("templated") Boolean templated
    @SerializedName("post_type") String postType
}
