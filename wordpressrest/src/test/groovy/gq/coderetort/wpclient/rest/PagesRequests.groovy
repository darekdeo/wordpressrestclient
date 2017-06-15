package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Page
import gq.coderetort.wpclient.rest.base.EntriesRequests
import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Ignore

class PagesRequests extends EntriesRequests {

    Closure get = { restClient.getPages(it) }
    String searchString = "example"
    String dateAfter = "2017-03-01T12:00:00"
    String dateBefore = "2017-06-01T12:00:00"
    String status = "publish"
    def excluded = [7, 17]
    def included = [7, 17]
    def authors = [1, 2]
    def excludedAuthors = [2, 3]
    def slug = ["non-consequatur-corporis-unde", "labore-aut-et-inventore"]
    def parents = [0]
    def excludedParents = [1, 2]

    def "get pages by menu order"() {
        given: "Menu order to search and query with specified request params"
        int menuOrderToSearch = 0;
        Query query = new Query.QueryBuilder()
                .menuOrder(menuOrderToSearch)
                .build();

        when: "Pages are downloaded from rest by specified query"
        List<Page> pages = restClient.getPages(query);

        then: "Downloaded list of pages should not be null or empty"
        pages != null
        !pages.isEmpty()

        pages.each { page ->
            page.menuOrder == menuOrderToSearch
        }
    }

    @Ignore
    def "get pages by filter"() {
        // todo to fill the test or not to fill
        // Use WP Query arguments to modify the response;
        // private query vars require appropriate authorization.
    }
}