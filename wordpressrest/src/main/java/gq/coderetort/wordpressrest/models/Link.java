package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {

    @JsonProperty("name") String name;
    @JsonProperty("taxonomy") public String taxonomy;
    @JsonProperty("href") public String href;
    @JsonProperty("embeddable") public Boolean embeddable;
    @JsonProperty("templated") public Boolean templated;
}
