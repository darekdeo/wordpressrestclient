package gq.coderetort.wordpressrest.rest.queries;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetEntryObject;

public class QueryGetPage extends QueryGetEntryObject {

    public QueryGetPage(Builder builder) {
        super(builder);
    }

    public static class Builder extends QueryGetEntryObject.Builder<Builder, QueryGetPage> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetPage build() {
            return new QueryGetPage(this);
        }
    }
}
