package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty;

class MediaSize {

    String file
    Integer width
    Integer height
    @JsonProperty("mime_type") String mimeType
    @JsonProperty("source_url") String sourceUrl
}