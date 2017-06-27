package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.CommonRequests

class PostStatusRequests extends CommonRequests {

    Closure get = { restClient.getPostStatus("publish", it) }
}