package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetTags extends QueryGetTerms {

    private Integer offset;

    public Integer getOffset() {
        return offset;
    }

    public QueryGetTags(Builder builder) {
        super(builder);
        offset = builder.offset;
    }

    public static class Builder extends QueryGetTerms.Builder<Builder> {

        private Integer offset;

        /**
         * Offset the result set by a specific number of items.
         * @param itemsOffset
         * @return
         */
        public Builder offset(int itemsOffset) {
            offset = itemsOffset;
            return this;
        }

        public QueryGetTags build() {
            return new QueryGetTags(this);
        }
    }
}
