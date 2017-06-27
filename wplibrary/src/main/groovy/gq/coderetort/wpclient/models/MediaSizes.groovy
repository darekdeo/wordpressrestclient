package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName;

class MediaSizes {

    MediaSize thumbnail
    MediaSize medium
    @SerializedName("medium_large") MediaSize mediumLarge
    MediaSize large
    @SerializedName("twentyseventeen-thumbnail-avatar") MediaSize twentyseventeenThumbnailAvatar
    MediaSize full
}