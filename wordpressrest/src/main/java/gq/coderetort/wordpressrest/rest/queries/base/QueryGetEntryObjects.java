package gq.coderetort.wordpressrest.rest.queries.base;

import java.util.List;

public abstract class QueryGetEntryObjects extends QueryGetItems {

    private String after = null;
    private List<Integer> author = null;
    private List<Integer> authorExclude = null;
    private String before = null;
    private Integer offset = null;
    private List<String> status = null;

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

    public QueryGetEntryObjects(Builder builder) {
        super(builder);
        after = builder.after;
        author = builder.author;
        authorExclude = builder.authorExclude;
        before = builder.before;
        offset = builder.offset;
        status = builder.status;
    }

    public abstract static class Builder
            <T extends Builder<T, S>, S> extends QueryGetItems.Builder<T, S> {

        private String after = null;
        private List<Integer> author = null;
        private List<Integer> authorExclude = null;
        private String before = null;
        private Integer offset = null;
        private List<String> status = null;

        /**
         * Limit response to posts published after a given ISO8601 compliant date.
         * @param after
         * @return
         */
        public T after(String after) {
            this.after = after;
            return getThis();
        }

        /**
         * Limit result set to posts assigned to specific authors.
         * @param authorsId
         * @return
         */
        public T authors(List<Integer> authorsId) {
            this.author = authorsId;
            return getThis();
        }

        /**
         * Ensure result set excludes posts assigned to specific authors.
         * @param authorsIds
         * @return
         */
        public T excludeAuthors(List<Integer> authorsIds) {
            this.authorExclude = authorsIds;
            return getThis();
        }

        /**
         * Limit response to posts published before a given ISO8601 compliant date.
         * @param before
         * @return
         */
        public T before(String before) {
            this.before = before;
            return getThis();
        }

        /**
         * Offset the result set by a specific number of items.
         * @param itemsOffset
         * @return
         */
        public T offset(int itemsOffset) {
            this.offset = itemsOffset;
            return getThis();
        }

        /**
         * Limit result set to posts assigned one or more statuses.
         * @param statuses Default: publish (or approve if object type is comment)
         * @return
         */
        public T limitToStatuses(List<String> statuses) {
            this.status = statuses;
            return getThis();
        }
    }
}
