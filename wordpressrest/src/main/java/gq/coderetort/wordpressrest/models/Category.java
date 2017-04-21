package gq.coderetort.wordpressrest.models;

import gq.coderetort.wordpressrest.models.base.Term;

public class Category extends Term {

    /**
     * The parent term ID.
     * <p>Context: view, edit</p>
     */
    public Integer parent;
}
