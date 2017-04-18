package gq.coderetort.wordpressrest.rest.queries;

public class QueryGetCategory {

    private String context;

    public String getContext() {
        return context;
    }

    public QueryGetCategory(Builder builder) {
        context = builder.context;
    }

    public static class Builder {

        private String context;

        public Builder context(String context) {
            this.context = context;
            return this;
        }

        public QueryGetCategory build() {
            return new QueryGetCategory(this);
        }
    }
}
