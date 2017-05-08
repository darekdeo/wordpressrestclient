package gq.coderetort.wordpressrest.rest.queries;

import java.util.List;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetEntryObjects;

public class QueryGetPosts extends QueryGetEntryObjects {

    private List<Integer> categories = null;
    private List<Integer> categoriesExclude = null;
    private List<Integer> tags = null;
    private List<Integer> tagsExclude = null;
    private Boolean sticky = null;
    private List<String> slug = null;

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

    public List<String> getSlug() {
        return slug;
    }

    public QueryGetPosts(Builder builder) {
        super(builder);
        this.categories = builder.categories;
        this.categoriesExclude = builder.categoriesExclude;
        this.tags = builder.tags;
        this.tagsExclude = builder.tagsExclude;
        this.sticky = builder.sticky;
        this.slug = builder.slug;
    }

    public static class Builder extends QueryGetEntryObjects.Builder<Builder, QueryGetPosts> {

        private List<Integer> categories = null;
        private List<Integer> categoriesExclude = null;
        private List<Integer> tags = null;
        private List<Integer> tagsExclude = null;
        private Boolean sticky = null;
        private List<String> slug = null;

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

        /**
         * Limit result set to posts with one or more specific slugs.
         * @param slugs
         * @return
         */
        public Builder slug(List<String> slugs) {
            this.slug = slugs;
            return getThis();
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetPosts build() {
            return new QueryGetPosts(this);
        }
    }
}
