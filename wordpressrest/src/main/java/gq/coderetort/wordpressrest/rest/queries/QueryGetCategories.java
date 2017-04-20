package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetCategories extends QueryGetTerms {

    private Integer parent = null;

    public Integer getParent() {
        return parent;
    }

    public QueryGetCategories(Builder builder) {
        super(builder);
        parent = builder.parent;
    }

    public static class Builder extends QueryGetTerms.Builder<Builder, QueryGetCategories> {

        private Integer parent = null;

        /**
         * Limit result set to terms assigned to a specific parent.
         */
        public Builder limitToParent(int parent) {
            this.parent = parent;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public QueryGetCategories build() {
            return new QueryGetCategories(this);
        }
    }
}
