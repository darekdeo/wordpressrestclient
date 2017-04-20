package gq.coderetort.wordpressrest.rest.queries;

public abstract class QueryGetItem extends Query {

    private String context;

    public String getContext() {
        return context;
    }

    public QueryGetItem(Builder builder) {
        context = builder.context;
    }

    public abstract static class Builder<T extends Builder<T, S>, S> {

        private String context;

        /**
         * Scope under which the request is made; determines fields present in response.
         * <p>Default: view</p>
         * @param context Default: view; One of: view, embed, edit
         * @return
         */
        public T context(String context) {
            this.context = context;
            return (T) this;
        }

        protected abstract T getThis();

        public abstract S build();
    }
}
