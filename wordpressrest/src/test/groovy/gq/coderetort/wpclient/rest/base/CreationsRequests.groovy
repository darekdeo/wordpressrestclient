package gq.coderetort.wpclient.rest.base

import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Shared

abstract class CreationsRequests extends BaseCreationsRequests {

    @Shared String status

    def "get entries by status"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .status(status)
                .build()

        when: "Entries are downloaded from rest"
        def entries = get(query)

        then: "List of entries should not be null or empty"
        entries != null
        !entries.isEmpty()

        and: "each entry should have specified status"
        entries.each { entry ->
            if (status != null)
                assert entry.status == status
        }
    }
}