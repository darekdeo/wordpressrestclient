package gq.coderetort.wordpressrest.rest.queries;

import java.util.List;

public class QueryGetPosts extends Query {

    private String context = null;
    private Integer page = null;
    private Integer perPage = null;
    private String search = null;
    private String after = null;
    private List<Integer> author = null;
    private List<Integer> authorExclude = null;
    private String before = null;
    private List<Integer> exclude = null;
    private List<Integer> include = null;
    private Integer offset = null;
    private String order = null;
    private String orderBy = null;
    private List<String> slug = null;
    private List<String> status = null;
    private List<Integer> categories = null;
    private List<Integer> categoriesExclude = null;
    private List<Integer> tags = null;
    private List<Integer> tagsExclude = null;
    private Boolean sticky = null;

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

    public String getAfter() {
        return after;
    }

    public List<Integer> getAuthor() {
        return author;
    }

    public List<Integer> getAuthorExclude() {
        return authorExclude;
    }

    public String getBefore() {
        return before;
    }

    public List<Integer> getExclude() {
        return exclude;
    }

    public List<Integer> getInclude() {
        return include;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getOrder() {
        return order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public List<String> getSlug() {
        return slug;
    }

    public List<String> getStatus() {
        return status;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public List<Integer> getCategoriesExclude() {
        return categoriesExclude;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public List<Integer> getTagsExclude() {
        return tagsExclude;
    }

    public Boolean getSticky() {
        return sticky;
    }

    public QueryGetPosts(Builder builder) {
        this.context = builder.context;
        this.page = builder.page;
        this.perPage = builder.perPage;
        this.search = builder.search;
        this.after = builder.after;
        this.author = builder.author;
        this.authorExclude = builder.authorExclude;
        this.before = builder.before;
        this.exclude = builder.exclude;
        this.include = builder.include;
        this.offset = builder.offset;
        this.order = builder.order;
        this.orderBy = builder.orderBy;
        this.slug = builder.slug;
        this.status = builder.status;
        this.categories = builder.categories;
        this.categoriesExclude = builder.categoriesExclude;
        this.tags = builder.tags;
        this.tagsExclude = builder.tagsExclude;
        this.sticky = builder.sticky;
    }

    public static class Builder {

        private String context = null;
        private Integer page = null;
        private Integer perPage = null;
        private String search = null;
        private String after = null;
        private List<Integer> author = null;
        private List<Integer> authorExclude = null;
        private String before = null;
        private List<Integer> exclude = null;
        private List<Integer> include = null;
        private Integer offset = null;
        private String order = null;
        private String orderBy = null;
        private List<String> slug = null;
        private List<String> status = null;
        private List<Integer> categories = null;
        private List<Integer> categoriesExclude = null;
        private List<Integer> tags = null;
        private List<Integer> tagsExclude = null;
        private Boolean sticky = null;

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
         * Limit response to posts published after a given ISO8601 compliant date.
         * @param after
         * @return
         */
        public Builder after(String after) {
            this.after = after;
            return this;
        }

        /**
         * Limit result set to posts assigned to specific authors.
         * @param authorsId
         * @return
         */
        public Builder authors(List<Integer> authorsId) {
            this.author = authorsId;
            return this;
        }

        /**
         * Ensure result set excludes posts assigned to specific authors.
         * @param authorsIds
         * @return
         */
        public Builder excludeAuthors(List<Integer> authorsIds) {
            this.authorExclude = authorsIds;
            return this;
        }

        /**
         * Limit response to posts published before a given ISO8601 compliant date.
         * @param before
         * @return
         */
        public Builder before(String before) {
            this.before = before;
            return this;
        }

        /**
         * Ensure result set excludes specific IDs.
         * @param postsIds
         * @return
         */
        public Builder exclude(List<Integer> postsIds) {
            this.exclude = postsIds;
            return this;
        }

        /**
         * Limit result set to specific IDs.
         * @param postsIds
         * @return
         */
        public Builder includeOnly(List<Integer> postsIds) {
            this.include = postsIds;
            return this;
        }

        /**
         * Offset the result set by a specific number of items.
         * @param itemsOffset
         * @return
         */
        public Builder offset(Integer itemsOffset) {
            this.offset = itemsOffset;
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
         * Sort collection by object attribute.
         * @param orderBy Default: date; One of: date, relevance, id, include, title, slug
         * @return
         */
        public Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        /**
         * Limit result set to posts with one or more specific slugs.
         * @param slugs
         * @return
         */
        public Builder slug(List<String> slugs) {
            this.slug = slugs;
            return this;
        }

        /**
         * Limit result set to posts assigned one or more statuses.
         * @param statuses Default: publish
         * @return
         */
        public Builder limitToStatuses(List<String> statuses) {
            this.status = statuses;
            return this;
        }

        /**
         * Limit result set to all items that have the specified term assigned in the categories taxonomy.
         * @param categories
         * @return
         */
        public Builder limitToCategories(List<Integer> categories) {
            this.categories = categories;
            return this;
        }

        /**
         * Limit result set to all items except those that have the specified term assigned in the categories taxonomy.
         * @param categories
         * @return
         */
        public Builder excludeCategories(List<Integer> categories) {
            this.categoriesExclude = categories;
            return this;
        }

        /**
         * Limit result set to all items that have the specified term assigned in the tags taxonomy.
         * @param tags
         * @return
         */
        public Builder limitToTags(List<Integer> tags) {
            this.tags = tags;
            return this;
        }

        /**
         * Limit result set to all items except those that have the specified term assigned in the tags taxonomy.
         * @param tags
         * @return
         */
        public Builder excludeTags(List<Integer> tags) {
            this.tagsExclude = tags;
            return this;
        }

        /**
         * Limit result set to items that are sticky.
         * @param sticky true if should limit to sticky
         * @return
         */
        public Builder onlySticky(boolean sticky) {
            this.sticky = sticky;
            return this;
        }

        public QueryGetPosts build() {
            return new QueryGetPosts(this);
        }
    }
}
