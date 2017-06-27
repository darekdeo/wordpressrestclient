package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.CommonRequests

class UserRequests extends CommonRequests {

    int modelId = 1
    Closure get = { restClient.getUser(modelId, it) }
}