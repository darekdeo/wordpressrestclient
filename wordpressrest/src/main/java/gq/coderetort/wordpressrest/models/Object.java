package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Object {

    String rendered;
    @JsonProperty("protected") Boolean isProtected;
}
