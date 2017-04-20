package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetPost extends QueryGetItem {

    private String password = null;

    public String getPassword() {
        return password;
    }

    public QueryGetPost(Builder builder) {
        super(builder);
        this.password = builder.password;
    }

    public static class Builder extends QueryGetItem.Builder<Builder, QueryGetPost> {

        private String password = null;

        /**
         * The password for the post if it is password protected.
         * @param password
         * @return
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        protected Builder getThis() {
            return null;
        }

        @Override
        public QueryGetPost build() {
            return new QueryGetPost(this);
        }
    }
}
