package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName;

class MediaSize {

    String file
    Integer width
    Integer height
    @SerializedName("mime_type") String mimeType
    @SerializedName("source_url") String sourceUrl
}