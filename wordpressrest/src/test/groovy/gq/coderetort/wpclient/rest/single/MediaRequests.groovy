package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.ProtectedRequests;

class MediaRequests extends ProtectedRequests {

    int modelId = 36
    String password = "test_password"
    Closure get = { restClient.getMedia(modelId, it) }
}