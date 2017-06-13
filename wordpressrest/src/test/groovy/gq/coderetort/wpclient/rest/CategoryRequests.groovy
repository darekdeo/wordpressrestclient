package gq.coderetort.wpclient.rest;

class CategoryRequests extends CommonRequests {

    int categoryId = 2
    Closure get = { restClient.getCategory(categoryId, it) }

    // todo add missing tests
}