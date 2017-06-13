package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.rest.queries.Query

class CategoriesRequests extends CommonListRequests {

    Closure get = { restClient.getCategories(it) }
    String searchString = "architecto"
    def excluded = [11, 1]
    def included = [11, 2]
    def slug = ["uncategorized"]

    def "get categories by hide empty"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
            .hideEmpty(true)
            .build()

        when: "Categories are downloaded from rest with given query"
        def categories = get(query)

        then: "List of categories should not be empty"
        categories != null
        !categories.isEmpty()
    }

    def "get categories by parent"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
            .parent(0)
            .build()

        when: "Categories are downloaded from rest with given query"
        def categories = get(query)

        then: "List of categories should not be empty"
        categories != null
        !categories.isEmpty()

        and: "each item has specified parent"
        categories.each { category ->
            category.parent == 0
        }
    }

    def "get categories by post"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .post(1)
                .build()

        when: "Categories are downloaded from rest with given query"
        def categories = get(query)

        then: "List of categories should not be empty"
        categories != null
        !categories.isEmpty()
    }
}