package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.ProtectedRequests

class PostRequests extends ProtectedRequests {

    int modelId = 33
    String password = "test_password"
    Closure get = { restClient.getPost(modelId, it) }
}