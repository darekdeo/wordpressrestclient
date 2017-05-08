package gq.coderetort.wordpressrest.rest.queries.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class QueryGetItems extends QueryGetItem {

    private Integer page = null;
    private Integer perPage = null;
    private String search = null;
    private List<Integer> exclude = null;
    private List<Integer> include = null;
    private String order = null;
    private String orderBy = null;

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String getSearch() {
        return search;
    }

    public List<Integer> getExclude() {
        return exclude;
    }

    public List<Integer> getInclude() {
        return include;
    }

    public String getOrder() {
        return order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public QueryGetItems(Builder builder) {
        super(builder);
        page = builder.page;
        perPage = builder.perPage;
        search = builder.search;
        exclude = builder.exclude;
        include = builder.include;
        order = builder.order;
        orderBy = builder.orderBy;
    }

    public abstract static class Builder
            <T extends Builder<T, S>, S> extends QueryGetItem.Builder<T, S> {

        private Integer page = null;
        private Integer perPage = null;
        private String search = null;
        private List<Integer> exclude = null;
        private List<Integer> include = null;
        private String order = null;
        private String orderBy = null;

        /**
         * Current page of the collection.
         * @param page Default: 1
         * @return
         */
        public T page(int page) {
            this.page = page;
            return getThis();
        }

        /**
         * Maximum number of items to be returned in result set.
         * @param perPage Default: 10
         * @return
         */
        public T itemsPerPage(int perPage) {
            this.perPage = perPage;
            return getThis();
        }

        /**
         * Limit results to those matching a string.
         * @param search string to search
         * @return
         */
        public T searchFor(String search) {
            this.search = search;
            return getThis();
        }

        /**
         * Ensure result set excludes specific IDs.
         * @param itemsIds
         * @return
         */
        public T exclude(Integer... itemsIds) {
            this.exclude = new ArrayList<>(Arrays.asList(itemsIds));
            return getThis();
        }

        /**
         * Limit result set to specific IDs.
         * @param itemsIds
         * @return
         */
        public T includeOnly(Integer... itemsIds) {
            this.include = new ArrayList<>(Arrays.asList(itemsIds));
            return getThis();
        }

        /**
         * Order sort attribute ascending or descending.
         * @param order Default: desc; One of: asc, desc
         * @return
         */
        public T order(String order) {
            this.order = order;
            return getThis();
        }

        /**
         * Sort collection by object attribute.
         * @param orderBy
         * @return
         */
        public T orderBy(String orderBy) {
            this.orderBy = orderBy;
            return getThis();
        }
    }
}
