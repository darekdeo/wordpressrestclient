package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetTag extends QueryGetItem {

    public QueryGetTag(Builder builder) {
        super(builder);
    }

    public static class Builder extends QueryGetItem.Builder<Builder, QueryGetTag> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetTag build() {
            return new QueryGetTag(this);
        }
    }
}
