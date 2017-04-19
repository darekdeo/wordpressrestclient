package gq.coderetort.wordpressrest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Links {

    @JsonProperty("self") List<Link> self;
    @JsonProperty("collection") List<Link> collection;
    @JsonProperty("about") List<Link> about;
    @JsonProperty("author") List<Link> author;
    @JsonProperty("replies") List<Link> replies;
    @JsonProperty("version-history") List<Link> versionHistory;
    @JsonProperty("wp:attachment") List<Link> attachment;
    @JsonProperty("wp:featuredmedia") public List<Link> featuredMedia;
    @JsonProperty("wp:term") List<Link> term;
    @JsonProperty("curies") List<Link> curies;
    @JsonProperty("up") List<Link> up;
    @JsonProperty("wp:post_type") List<Link> postType;
}
