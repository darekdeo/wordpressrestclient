package gq.coderetort.wpclient.rest.base

import gq.coderetort.wpclient.rest.queries.Query
import gq.coderetort.wpclient.utils.DateUtils
import spock.lang.Shared

abstract class EntriesRequests extends CommonListRequests {

    @Shared
    String dateAfter
    @Shared
    String dateBefore
    @Shared
    def authors
    @Shared
    def excludedAuthors

    def "get entries by before date"() {
        given: "A before date and query with specified request params"
        Date beforeDate = DateUtils.parseISO8601(dateBefore)
        Query query = new Query.QueryBuilder()
                .before(dateBefore)
                .build()

        when: "Entries are downloaded from rest with given query"
        def entries = get(query)

        then: "List of entries should not be empty"
        entries != null
        !entries.isEmpty()

        and: "each entry should be before specified date"
        entries.each { entry ->
            assert entry.getDate() != null
            assert entry.getDate().before(beforeDate)
        }
    }

    def "get entries by after date"() {
        given: "An after date to check and query with specified request params"
        Date afterDate = DateUtils.parseISO8601(dateAfter)
        Query query = new Query.QueryBuilder()
                .after(dateAfter)
                .build()

        when: "Entries are downloaded from rest with given query"
        def entries = get(query)

        then: "List of entries should not be empty"
        entries != null
        !entries.isEmpty()

        and: "each entry should be after the specified date"
        entries.each { entry -> assert entry.getDate().after(afterDate) }
    }

    def "get entries by authors"() {
        given: "A list of authors to check and query with specified request params"
        Query query = null
        if (!authors?.isEmpty())
            query = new Query.QueryBuilder()
                    .author(authors)
                    .build()

        when: "Entries are downloaded from rest with given query"
        def entries = get(query)

        then: "List of entries should not be empty"
        entries != null
        !entries.isEmpty()

        and: "each entry should be written by one of specified authors"
        if (!authors?.isEmpty())
            entries.each { entry ->
                assert authors.contains(entry.author)
            }
    }

    def "get entries not from excluded authors"() {
        given: "A list of excluded authors and query with specified request params"
        Query query = null
        if (!authors?.isEmpty())
            query = new Query.QueryBuilder()
                    .authorExclude(excludedAuthors)
                    .build()

        when: "Entries are downloaded from rest with given query"
        def entries = get(query) // todo make sure adding minus to argument is not necessary

        then: "List of entries should not be empty"
        entries != null
        !entries.isEmpty()

        and: "each entry should not be written by one of specified authors"
        if (!authors?.isEmpty())
            entries.each { entry ->
                assert !excludedAuthors.contains(entry.author)
            }
    }
}