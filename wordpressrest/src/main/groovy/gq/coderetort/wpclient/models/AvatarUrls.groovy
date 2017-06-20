package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty;

class AvatarUrls {

    @JsonProperty("24") String small
    @JsonProperty("48") String medium
    @JsonProperty("96") String large
}