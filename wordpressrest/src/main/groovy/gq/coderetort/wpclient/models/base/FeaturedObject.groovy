package gq.coderetort.wpclient.models.base

abstract class FeaturedObject extends BaseObject {

    /**
     * Description of the resource.
     * <p>Context: view, edit, embed</p>
     */
    String description

    /**
     * Name for the resource.
     * <p>Context: view, edit, embed</p>
     */
    String name

    /**
     * An alphanumeric identifier for the resource.
     * <p>Context: view, edit, embed</p>
     */
    String slug
}