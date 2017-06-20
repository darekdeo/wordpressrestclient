package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.rest.base.CreationsRequests
import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Ignore;

class MediaListRequests extends CreationsRequests {

    Closure get = { restClient.getMediaList(it) }
    String searchString = "tempore"
    String dateAfter = "2017-03-01T12:00:00"
    String dateBefore = "2017-06-01T12:00:00"
    String status = "inherit"
    def excluded = [36, 34]
    def included = [36, 34]
    def authors = [1]
    def excludedAuthors = [2]
    def slug = ["reiciendis-quia-ut-ut-aut", "totam-aperiam-dignissimos-rerum-soluta-ut-pariatur"]

    @Ignore
    def "get media list by filter"() {
        // todo to fill the test or not to fill
        // Use WP Query arguments to modify the response;
        // private query vars require appropriate authorization.
    }

    def "get media list by media type"() {
        given: "Media type string and query with specified request params"
        String mediaType = "image"
        Query query = new Query.QueryBuilder()
                .mediaType(mediaType)
                .build()

        when: "Media list is downloaded from rest with given query"
        def mediaList = get(query)

        then: "List of media should not be empty"
        mediaList != null
        !mediaList.isEmpty()

        and: "each item is of specified type"
        mediaList.each { media ->
            media.mediaType == mediaType
        }
    }

    def "get media list by mime type"() {
        given: "Mime type string and query with specified request params"
        String mimeType = "image/jpeg"
        Query query = new Query.QueryBuilder()
                .mimeType(mimeType)
                .build()

        when: "Media list is downloaded from rest with given query"
        def mediaList = get(query)

        then: "List of media should not be empty"
        mediaList != null
        !mediaList.isEmpty()

        and: "each item is of specified mime type"
        mediaList.each { media ->
            media.mimeType == mimeType
        }
    }
}