package gq.coderetort.wordpressrest.rest.queries;

import java.util.List;

public abstract class QueryGetEntryObjects extends QueryGetItems {

    private String after = null;
    private List<Integer> author = null;
    private List<Integer> authorExclude = null;
    private String before = null;
    private Integer offset = null;
    private List<String> status = null;
    private List<String> slug = null;

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

    public Integer getOffset() {
        return offset;
    }

    public List<String> getStatus() {
        return status;
    }

    public List<String> getSlug() {
        return slug;
    }

    public QueryGetEntryObjects(Builder builder) {
        super(builder);
        after = builder.after;
        author = builder.author;
        authorExclude = builder.authorExclude;
        before = builder.before;
        offset = builder.offset;
        status = builder.status;
        slug = builder.slug;
    }

    public abstract static class Builder<T extends Builder<T, S>, S> extends QueryGetItems.Builder<Builder<T, S>, S> {

        private String after = null;
        private List<Integer> author = null;
        private List<Integer> authorExclude = null;
        private String before = null;
        private Integer offset = null;
        private List<String> status = null;
        private List<String> slug = null;

        /**
         * Limit response to posts published after a given ISO8601 compliant date.
         * @param after
         * @return
         */
        public T after(String after) {
            this.after = after;
            return (T) this;
        }

        /**
         * Limit result set to posts assigned to specific authors.
         * @param authorsId
         * @return
         */
        public T authors(List<Integer> authorsId) {
            this.author = authorsId;
            return (T) this;
        }

        /**
         * Ensure result set excludes posts assigned to specific authors.
         * @param authorsIds
         * @return
         */
        public T excludeAuthors(List<Integer> authorsIds) {
            this.authorExclude = authorsIds;
            return (T) this;
        }

        /**
         * Limit response to posts published before a given ISO8601 compliant date.
         * @param before
         * @return
         */
        public T before(String before) {
            this.before = before;
            return (T) this;
        }

        /**
         * Offset the result set by a specific number of items.
         * @param itemsOffset
         * @return
         */
        public T offset(int itemsOffset) {
            this.offset = itemsOffset;
            return (T) this;
        }

        /**
         * Limit result set to posts assigned one or more statuses.
         * @param statuses Default: publish
         * @return
         */
        public T limitToStatuses(List<String> statuses) {
            this.status = statuses;
            return (T) this;
        }

        /**
         * Limit result set to posts with one or more specific slugs.
         * @param slugs
         * @return
         */
        public T slug(List<String> slugs) {
            this.slug = slugs;
            return (T) this;
        }
    }
}
