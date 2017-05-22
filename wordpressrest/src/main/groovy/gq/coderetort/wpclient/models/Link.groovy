package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty

class Link {

    @JsonProperty("name") String name
    @JsonProperty("taxonomy") String taxonomy
    @JsonProperty("href") String href
    @JsonProperty("embeddable") Boolean embeddable
    @JsonProperty("templated") Boolean templated
    @JsonProperty("post_type") String postType
}
