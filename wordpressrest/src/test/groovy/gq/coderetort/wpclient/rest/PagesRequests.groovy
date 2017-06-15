package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.rest.base.EntriesRequests;

class PagesRequests extends EntriesRequests {

    Closure get = { restClient.getPages(it) }
    String searchString = "example"
    String dateAfter = "2017-03-01T12:00:00"
    String dateBefore = "2017-06-01T12:00:00"
    def excluded = [7, 17]
    def included = [7, 17]
    def authors = [1, 2]
    def excludedAuthors = [2, 3]
    def slug = ["non-consequatur-corporis-unde", "labore-aut-et-inventore"]
}