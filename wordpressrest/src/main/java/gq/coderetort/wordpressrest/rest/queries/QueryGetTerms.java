package gq.coderetort.wordpressrest.rest.queries;

import java.util.List;

public abstract class QueryGetTerms extends Query {

    private String context = null;
    private Integer page = null;
    private Integer perPage = null;
    private String search = null;
    private List<Integer> exclude = null;
    private List<Integer> include = null;
    private String order = null;
    private String orderBy = null;
    private Boolean hideEmpty = null;
    private Integer post = null;
    private String slug = null;

    public String getContext() {
        return context;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String getSearch() {
        return search;
    }

    public List<Integer> getExclude() {
        return exclude;
    }

    public List<Integer> getInclude() {
        return include;
    }

    public String getOrder() {
        return order;
    }

    public String getOrderBy() {
        return orderBy;
    }

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
        context = builder.context;
        page = builder.page;
        perPage = builder.perPage;
        search = builder.search;
        exclude = builder.exclude;
        include = builder.include;
        order = builder.order;
        orderBy = builder.orderBy;
        hideEmpty = builder.hideEmpty;
        post = builder.post;
        slug = builder.slug;
    }

    public abstract static class Builder<T extends Builder> {

        private String context = null;
        private Integer page = null;
        private Integer perPage = null;
        private String search = null;
        private List<Integer> exclude = null;
        private List<Integer> include = null;
        private String order = null;
        private String orderBy = null;
        private Boolean hideEmpty = null;
        private Integer post = null;
        private String slug = null;

        /**
         * Scope under which the request is made; determines fields present in response.
         * <p>Default: view</p>
         * @param context Default: view; One of: view, embed, edit
         * @return
         */
        public T context(String context) {
            this.context = context;
            return (T) this;
        }

        /**
         * Current page of the collection.
         * @param page Default: 1
         * @return
         */
        public T page(int page) {
            this.page = page;
            return (T) this;
        }

        /**
         * Maximum number of items to be returned in result set. Default: 10
         * @param perPage Default: 10
         * @return
         */
        public T itemsPerPage(int perPage) {
            this.perPage = perPage;
            return (T) this;
        }

        /**
         * Limit results to those matching a string.
         * @param search string to search
         * @return
         */
        public T searchFor(String search) {
            this.search = search;
            return (T) this;
        }

        /**
         * Ensure result set excludes specific IDs.
         * @param categoriesIds
         * @return
         */
        public T exclude(List<Integer> categoriesIds) {
            this.exclude = categoriesIds;
            return (T) this;
        }

        /**
         * Limit result set to specific IDs.
         * @param categoriesIds
         * @return
         */
        public T includeOnly(List<Integer> categoriesIds) {
            this.include = categoriesIds;
            return (T) this;
        }

        /**
         * Order sort attribute ascending or descending.
         * @param order Default: desc; One of: asc, desc
         * @return
         */
        public T order(String order) {
            this.order = order;
            return (T) this;
        }

        /**
         * Sort collection by term attribute.
         * @param orderBy Default: date; One of: id, include, name, slug, term_group, description, count
         * @return
         */
        public T orderBy(String orderBy) {
            this.orderBy = orderBy;
            return (T) this;
        }

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
