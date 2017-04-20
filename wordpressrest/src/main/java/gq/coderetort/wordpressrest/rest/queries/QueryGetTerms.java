package gq.coderetort.wordpressrest.rest.queries;

public abstract class QueryGetTerms extends QueryGetItems {

    private Boolean hideEmpty = null;
    private Integer post = null;
    private String slug = null;

    public Boolean getHideEmpty() {
        return hideEmpty;
    }

    public Integer getPost() {
        return post;
    }

    public String getSlug() {
        return slug;
    }

    public QueryGetTerms(Builder builder) {
        super(builder);
        hideEmpty = builder.hideEmpty;
        post = builder.post;
        slug = builder.slug;
    }

    public abstract static class Builder<T extends Builder<T, S>, S> extends QueryGetItems.Builder<Builder<T, S>, S> {

        private Boolean hideEmpty = null;
        private Integer post = null;
        private String slug = null;

        /**
         * Whether to hide terms not assigned to any posts.
         */
        public T hideEmpty(boolean hideEmpty) {
            this.hideEmpty = hideEmpty;
            return (T) this;
        }

        /**
         * Limit result set to terms assigned to a specific post.
         */
        public T limitToPost(int post) {
            this.post = post;
            return (T) this;
        }

        /**
         * Limit result set to terms with a specific slug.
         */
        public T limitToSlug(String slug) {
            this.slug = slug;
            return (T) this;
        }
    }
}
