package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.CommonRequests;

class TagRequests extends CommonRequests {

    int modelId = 4
    Closure get = { restClient.getTag(modelId, it) }
}