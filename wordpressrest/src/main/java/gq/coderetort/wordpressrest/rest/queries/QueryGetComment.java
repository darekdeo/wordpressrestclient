package gq.coderetort.wordpressrest.rest.queries;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetItem;

public class QueryGetComment extends QueryGetItem {

    public QueryGetComment(Builder builder) {
        super(builder);
    }

    public static class Builder extends QueryGetItem.Builder<Builder, QueryGetComment> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetComment build() {
            return new QueryGetComment(this);
        }
    }
}
