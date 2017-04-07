package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetPost {

    private String context = null;
    private String password = null;

    public QueryGetPost(Builder builder) {
        this.context = builder.context;
        this.password = builder.password;
    }

    public String getContext() {
        return context;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private String context = null;
        private String password = null;

        /**
         * Scope under which the request is made; determines fields present in response.
         * @param context Default: view; One of: view, embed, edit
         * @return
         */
        public Builder context(String context) {
            this.context = context;
            return this;
        }

        /**
         * The password for the post if it is password protected.
         * @param password
         * @return
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public QueryGetPost build() {
            return new QueryGetPost(this);
        }
    }
}
