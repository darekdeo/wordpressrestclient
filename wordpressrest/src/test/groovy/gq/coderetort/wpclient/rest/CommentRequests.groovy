package gq.coderetort.wpclient.rest;

class CommentRequests extends CommonRequests {

    int modelId = 1
    Closure get = { restClient.getComment(modelId, it) }
}