package gq.coderetort.wordpressrest.rest.queries.base;

public abstract class QueryGetEntryObject extends QueryGetItem {

    private String password = null;

    public String getPassword() {
        return password;
    }

    public QueryGetEntryObject(Builder builder) {
        super(builder);
        this.password = builder.password;
    }

    public abstract static class Builder
            <T extends Builder<T, S>, S> extends QueryGetItem.Builder<T, S> {

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
    }
}
