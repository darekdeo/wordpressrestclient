package gq.coderetort.wpclient.rest;

class CommentsRequests extends CommonListRequests {

    Closure get = { restClient.getComments(it) }
    String searchString = "moderating"
    def excluded = [2]
    def included = [1]
}