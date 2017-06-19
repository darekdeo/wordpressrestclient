package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty;

class MediaSizes {

    MediaSize thumbnail
    MediaSize medium
    @JsonProperty("medium_large") MediaSize mediumLarge
    MediaSize large
    @JsonProperty("twentyseventeen-thumbnail-avatar") MediaSize twentyseventeenThumbnailAvatar
    MediaSize full
}