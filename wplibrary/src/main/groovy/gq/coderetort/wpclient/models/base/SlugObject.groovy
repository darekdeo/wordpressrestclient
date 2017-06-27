package gq.coderetort.wpclient.models.base;

class SlugObject extends BaseObject {

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