package gq.coderetort.wordpressrest.rest.queries;

import java.util.List;

public class QueryGetCategories extends Query {

    private String context = null;
    private Integer page = null;
    private Integer perPage = null;
    private String search = null;
    private List<Integer> exclude = null;
    private List<Integer> include = null;
    private String order = null;
    private String orderBy = null;
    private Boolean hideEmpty = null;
    private Integer parent = null;
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

    public Integer getParent() {
        return parent;
    }

    public Integer getPost() {
        return post;
    }

    public String getSlug() {
        return slug;
    }

    public QueryGetCategories(Builder builder) {
        context = builder.context;
        page = builder.page;
        perPage = builder.perPage;
        search = builder.search;
        exclude = builder.exclude;
        include = builder.include;
        order = builder.order;
        orderBy = builder.orderBy;
        hideEmpty = builder.hideEmpty;
        parent = builder.parent;
        post = builder.post;
        slug = builder.slug;
    }

    public static class Builder {

        private String context = null;
        private Integer page = null;
        private Integer perPage = null;
        private String search = null;
        private List<Integer> exclude = null;
        private List<Integer> include = null;
        private String order = null;
        private String orderBy = null;
        private Boolean hideEmpty = null;
        private Integer parent = null;
        private Integer post = null;
        private String slug = null;

        /**
         * Scope under which the request is made; determines fields present in response.
         * <p>Default: view</p>
         * @param context Default: view; One of: view, embed, edit
         * @return
         */
        public Builder context(String context) {
            this.context = context;
            return this;
        }

        /**
         * Current page of the collection.
         * @param page Default: 1
         * @return
         */
        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Maximum number of items to be returned in result set. Default: 10
         * @param perPage Default: 10
         * @return
         */
        public Builder itemsPerPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        /**
         * Limit results to those matching a string.
         * @param search string to search
         * @return
         */
        public Builder searchFor(String search) {
            this.search = search;
            return this;
        }

        /**
         * Ensure result set excludes specific IDs.
         * @param categoriesIds
         * @return
         */
        public Builder exclude(List<Integer> categoriesIds) {
            this.exclude = categoriesIds;
            return this;
        }

        /**
         * Limit result set to specific IDs.
         * @param categoriesIds
         * @return
         */
        public Builder includeOnly(List<Integer> categoriesIds) {
            this.include = categoriesIds;
            return this;
        }

        /**
         * Order sort attribute ascending or descending.
         * @param order Default: desc; One of: asc, desc
         * @return
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

        /**
         * Sort collection by term attribute.
         * @param orderBy Default: date; One of: id, include, name, slug, term_group, description, count
         * @return
         */
        public Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        /**
         * Whether to hide terms not assigned to any posts.
         */
        public Builder hideEmpty(Boolean hideEmpty) {
            this.hideEmpty = hideEmpty;
            return this;
        }

        /**
         * Limit result set to terms assigned to a specific parent.
         */
        public Builder limitToParent(Integer parent) {
            this.parent = parent;
            return this;
        }

        /**
         * Limit result set to terms assigned to a specific post.
         */
        public Builder limitToPost(Integer post) {
            this.post = post;
            return this;
        }

        /**
         * Limit result set to terms with a specific slug.
         */
        public Builder limitToSlug(String slug) {
            this.slug = slug;
            return this;
        }
    }
}
