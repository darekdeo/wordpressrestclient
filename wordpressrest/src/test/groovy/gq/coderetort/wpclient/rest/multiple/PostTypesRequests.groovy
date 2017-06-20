package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.rest.base.CommonRequests

class PostTypesRequests extends CommonRequests {

    Closure get = { restClient.getPostTypes(it) }
}