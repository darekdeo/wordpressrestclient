package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty

class Object {

    @JsonProperty("rendered") String rendered
    @JsonProperty("protected") Boolean isProtected
}
