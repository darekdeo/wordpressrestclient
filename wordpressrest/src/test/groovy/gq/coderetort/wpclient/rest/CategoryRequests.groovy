package gq.coderetort.wpclient.rest;

class CategoryRequests extends CommonRequests {

    int modelId = 2
    Closure get = { restClient.getCategory(modelId, it) }
}