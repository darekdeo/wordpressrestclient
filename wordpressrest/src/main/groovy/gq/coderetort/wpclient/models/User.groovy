package gq.coderetort.wpclient.models

import com.fasterxml.jackson.annotation.JsonProperty
import gq.coderetort.wpclient.models.base.FeaturedObject

class User extends FeaturedObject {

    /**
     * Login name for the user.
     * <p>Context: edit</p>
     */
    String username

    /**
     * First name for the user.
     * <p>Context: edit</p>
     */
    @JsonProperty("first_name") String firstName

    /**
     * Last name for the user.
     * <p>Context: edit</p>
     */
    @JsonProperty("last_name") String lastName

    /**
     * The email address for the user.
     * <p>Context: edit</p>
     */
    String email

    /**
     * URL of the user.
     * <p>Context: view, edit, embed</p>
     */
    String url

    /**
     * Locale for the user.
     * <p>Context: edit</p>
     * <p>One of: en_US</p>
     */
    String locale

    /**
     * The nickname for the user.
     * <p>Context: edit</p>
     */
    String nickname

    /**
     * Registration date for the user.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("registered_date") String registeredDate

    /**
     * Roles assigned to the user.
     * <p>Context: edit</p>
     */
    List<String> roles

    /**
     * Password for the user (never included).
     */
    String password

    /**
     * All capabilities assigned to the user.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    List<Object> capabilities

    /**
     * Any extra capabilities assigned to the user.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @JsonProperty("extra_capabilities") List<Object> extraCapabilities

    /**
     * Avatar URLs for the user.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @JsonProperty("avatar_urls") Map<Integer, String> avatarUrls
}