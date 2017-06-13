package gq.coderetort.wpclient.rest;

class TagRequests extends CommonRequests {

    int modelId = 4
    Closure get = { restClient.getTag(modelId, it) }
}