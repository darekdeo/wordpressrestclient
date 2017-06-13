package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.rest.base.CommonRequests;

class CommentRequests extends CommonRequests {

    int modelId = 1
    Closure get = { restClient.getComment(modelId, it) }
}