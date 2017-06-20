package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.rest.base.CommonRequests;

class PostStatusesRequests extends CommonRequests {

    Closure get = { restClient.getPostStatuses(it) }
}