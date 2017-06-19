package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.rest.base.CreationsRequests;

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
}