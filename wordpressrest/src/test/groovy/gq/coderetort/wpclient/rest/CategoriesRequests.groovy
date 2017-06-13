package gq.coderetort.wpclient.rest;

class CategoriesRequests extends CommonRequests {

    Closure get = { restClient.getCategories(it) }

    // todo add missing tests
}