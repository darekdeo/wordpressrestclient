package gq.coderetort.wpclient.models

import com.google.gson.annotations.SerializedName

class Settings {

    /**
     * Site title.
     */
    String title

    /**
     * Site description.
     */
    String description

    /**
     * Site url.
     */
    String url

    /**
     * This address is used for admin purposes.
     * If you change this we will send you an email at your new address to confirm it.
     * The new address will not become active until confirmed.
     */
    String email

    /**
     * A city in the same timezone as you.
     */
    String timezone

    /**
     * A date format for all date strings.
     */
    @SerializedName("date_format") String dateFormat

    /**
     * A time format for all time strings.
     */
    @SerializedName("time_format") String timeFormat

    /**
     * A day number of the week that the week should start on.
     */
    @SerializedName("start_of_week") String startOfWeek

    /**
     * WordPress locale code.
     */
    String language

    /**
     * Convert emoticons like :-) and :-P to graphics on display.
     */
    @SerializedName("use_smilies") Boolean useSmilies

    /**
     * Default category.
     */
    @SerializedName("default_category") Integer defaultCategory

    /**
     * Default post format.
     */
    @SerializedName("default_post_format") String defaultPostFormat

    /**
     * Blog pages show at most.
     */
    @SerializedName("posts_per_page") Integer postsPerPage
}