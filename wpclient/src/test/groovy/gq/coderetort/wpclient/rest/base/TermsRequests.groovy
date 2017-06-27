package gq.coderetort.wpclient.rest.base

import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Shared

abstract class TermsRequests extends CommonListRequests {

    @Shared
    int postId

    def "get terms by hide empty"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .hideEmpty(true)
                .build()

        when: "Terms are downloaded from rest with given query"
        def terms = get(query)

        then: "List of terms should not be empty"
        terms != null
        !terms.isEmpty()
    }

    def "get terms by post"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .post(postId)
                .build()

        when: "Categories are downloaded from rest with given query"
        def categories = get(query)

        then: "List of terms should not be empty"
        categories != null
        !categories.isEmpty()
    }
}