package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetCategory extends Query {

    private String context;

    public String getContext() {
        return context;
    }

    public QueryGetCategory(Builder builder) {
        context = builder.context;
    }

    public static class Builder {

        private String context;

        /**
         * Scope under which the request is made; determines fields present in response.
         * <p>Default: view</p>
         * @param context Default: view; One of: view, embed, edit
         * @return
         */
        public Builder context(String context) {
            this.context = context;
            return this;
        }

        public QueryGetCategory build() {
            return new QueryGetCategory(this);
        }
    }
}
