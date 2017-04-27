package gq.coderetort.wordpressrest.rest.queries;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetEntryObject;

public class QueryGetPost extends QueryGetEntryObject {

    public QueryGetPost(Builder builder) {
        super(builder);

    }

    public static class Builder extends QueryGetEntryObject.Builder<Builder, QueryGetPost> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetPost build() {
            return new QueryGetPost(this);
        }
    }
}
