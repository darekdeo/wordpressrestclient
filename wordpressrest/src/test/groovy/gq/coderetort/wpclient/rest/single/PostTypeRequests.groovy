package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.CommonRequests;

class PostTypeRequests extends CommonRequests {

    Closure get = { restClient.getPostType("post", it) }
}