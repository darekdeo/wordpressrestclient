package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty

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
    @JsonProperty("date_format") String dateFormat

    /**
     * A time format for all time strings.
     */
    @JsonProperty("time_format") String timeFormat

    /**
     * A day number of the week that the week should start on.
     */
    @JsonProperty("start_of_week") String startOfWeek

    /**
     * WordPress locale code.
     */
    String language

    /**
     * Convert emoticons like :-) and :-P to graphics on display.
     */
    @JsonProperty("use_smilies") Boolean useSmilies

    /**
     * Default category.
     */
    @JsonProperty("default_category") Integer defaultCategory

    /**
     * Default post format.
     */
    @JsonProperty("default_post_format") String defaultPostFormat

    /**
     * Blog pages show at most.
     */
    @JsonProperty("posts_per_page") Integer postsPerPage
}