package gq.coderetort.wordpressrest.rest.queries;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetItem;

public class QueryGetCategory extends QueryGetItem {

    public QueryGetCategory(Builder builder) {
        super(builder);
    }

    public static class Builder extends QueryGetItem.Builder<Builder, QueryGetCategory> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetCategory build() {
            return new QueryGetCategory(this);
        }
    }
}
