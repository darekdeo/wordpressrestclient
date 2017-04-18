package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Object {

    @JsonProperty("rendered") public String rendered;
    @JsonProperty("protected") public Boolean isProtected;
}
