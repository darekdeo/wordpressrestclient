package gq.coderetort.wpclient.models.base

abstract class BaseTerm extends BaseObject {

    /**
     * HTML description of the term.
     * <p>Context: view, edit</p>
     */
    String description

    /**
     * HTML title for the term.
     * <p>Context: view, edit, embed</p>
     */
    String name

    /**
     * An alphanumeric identifier for the term unique to its type.
     * <p>Context: view, edit, embed</p>
     */
    String slug
}