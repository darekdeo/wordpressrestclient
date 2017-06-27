package gq.coderetort.wpclient.rest.base

import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Shared

abstract class EntriesRequests extends CreationsRequests {

    @Shared def parents
    @Shared def excludedParents

    def "get entries by parent exclude"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .parentExcludeList(excludedParents)
                .build()

        when: "Entries are downloaded from rest"
        def entries = get(query)

        then: "List of entries should not be null or empty"
        entries != null
        !entries.isEmpty()

        and: "each entry parent should not be in excluded parents"
        entries.each { entry ->
            assert !excludedParents.contains(entry.parent)
        }
    }

    def "get entries by parent include"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .parentList(parents)
                .build()

        when: "Comments are downloaded from rest"
        def entries = get(query)

        then: "List of entries should not be null or empty"
        entries != null
        !entries.isEmpty()

        and: "each entry parent should be in included parents"
        entries.each { entry ->
            assert parents.contains(entry.parent)
        }
    }
}