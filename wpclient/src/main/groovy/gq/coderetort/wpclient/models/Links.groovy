package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("self") List<Link> self
    @SerializedName("collection") List<Link> collection
    @SerializedName("about") List<Link> about
    @SerializedName("author") List<Link> author
    @SerializedName("replies") List<Link> replies
    @SerializedName("version-history") List<Link> versionHistory
    @SerializedName("wp:attachment") List<Link> attachment
    @SerializedName("wp:featuredmedia") List<Link> featuredMedia
    @SerializedName("wp:term") List<Link> term
    @SerializedName("curies") List<Link> curies
    @SerializedName("up") List<Link> up
    @SerializedName("wp:post_type") List<Link> postType
    @SerializedName("in-reply-to") List<Link> inReplyTo
    @SerializedName("children") List<Link> children
    @SerializedName("wp:items") List<Link> items
    @SerializedName("archives") List<Link> archives
}
