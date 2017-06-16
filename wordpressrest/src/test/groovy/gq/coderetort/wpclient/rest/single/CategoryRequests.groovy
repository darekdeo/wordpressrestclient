package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.CommonRequests;

class CategoryRequests extends CommonRequests {

    int modelId = 2
    Closure get = { restClient.getCategory(modelId, it) }
}