package gq.coderetort.wordpressrest.rest.queries;

import java.util.List;

import gq.coderetort.wordpressrest.rest.queries.base.QueryGetEntryObjects;

public class QueryGetPages extends QueryGetEntryObjects {

    private Integer menuOrder; // todo test if works
    private List<Integer> parent;
    private List<Integer> parentExclude;
    private List<String> filter; // todo how to do

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public List<Integer> getParent() {
        return parent;
    }

    public List<Integer> getParentExclude() {
        return parentExclude;
    }

    public List<String> getFilter() {
        return filter;
    }

    public QueryGetPages(Builder builder) {
        super(builder);
        menuOrder = builder.menuOrder;
        parent = builder.parent;
        parentExclude = builder.parentExclude;
        filter = builder.filter;
    }

    public static class Builder extends QueryGetEntryObjects.Builder<Builder, QueryGetPages> {

        private Integer menuOrder; // todo test if works
        private List<Integer> parent;
        private List<Integer> parentExclude;
        private List<String> filter; // todo how to do

        public Builder menuOrder(Integer menuOrder) {
            this.menuOrder = menuOrder;
            return this;
        }

        public Builder limitToParent(List<Integer> parent) {
            this.parent = parent;
            return this;
        }

        public Builder excludeParent(List<Integer> parentExclude) {
            this.parentExclude = parentExclude;
            return this;
        }

        public Builder filter(List<String> filter) {
            this.filter = filter;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public QueryGetPages build() {
            return new QueryGetPages(this);
        }
    }
}
