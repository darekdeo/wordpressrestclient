package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.rest.base.ProtectedRequests

class PageRequests extends ProtectedRequests {

    int modelId = 2
    String password = "test_password"
    Closure get = { restClient.getPage(modelId, it) }
}