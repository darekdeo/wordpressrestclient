package gq.coderetort.wpclient.models.base

abstract class Term extends FeaturedObject {

    /**
     * Number of published posts for the term.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    Integer count

    /**
     * Type attribution for the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: category, post_tag, nav_menu, link_category, post_format</p>
     */
    String taxonomy
}
