package gq.coderetort.wordpressrest.rest.queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetEntryObjects;

public class QueryGetComments extends QueryGetEntryObjects {

    private List<Integer> parent = null;
    private List<Integer> parentExclude = null;
    private String authorEmail = null;
    private Integer karma = null;
    private List<Integer> post = null;
    private List<String> type = null;

    public List<Integer> getParent() {
        return parent;
    }

    public List<Integer> getParentExclude() {
        return parentExclude;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public Integer getKarma() {
        return karma;
    }

    public List<Integer> getPost() {
        return post;
    }

    public List<String> getType() {
        return type;
    }

    public QueryGetComments(Builder builder) {
        super(builder);
        parent = builder.parent;
        parentExclude = builder.parentExclude;
        authorEmail = builder.authorEmail;
        karma = builder.karma;
        post = builder.post;
        type = builder.type;
    }

    public static class Builder extends QueryGetEntryObjects.Builder<Builder, QueryGetComments> {

        private List<Integer> parent = null;
        private List<Integer> parentExclude = null;
        private String authorEmail = null;
        private Integer karma = null;
        private List<Integer> post = null;
        private List<String> type = null;

        /**
         * Limit result set to that from a specific author email. Requires authorization.
         */
        public Builder authorEmail(String authorEmail) {
            this.authorEmail = authorEmail;
            return this;
        }

        /**
         * Limit result set to that of a particular comment karma. Requires authorization.
         */
        public Builder karma(Integer karma) {
            this.karma = karma;
            return this;
        }

        /**
         * Limit result set to resources of specific parent ids.
         */
        public Builder limitToParent(Integer... parent) {
            this.parent = new ArrayList<>(Arrays.asList(parent));
            return this;
        }

        public Builder excludeParent(Integer... parentExclude) {
            this.parentExclude = new ArrayList<>(Arrays.asList(parentExclude));
            return this;
        }

        /**
         * Limit result set to resources assigned to specific post ids.
         */
        public Builder post(Integer... post) {
            this.post = new ArrayList<>(Arrays.asList(post));
            return this;
        }

        /**
         * Limit result set to comments assigned a specific type. Requires authorization. Default: comment
         */
        public Builder type(String... type) {
            this.type = new ArrayList<>(Arrays.asList(type));
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public QueryGetComments build() {
            return new QueryGetComments(this);
        }
    }
}
