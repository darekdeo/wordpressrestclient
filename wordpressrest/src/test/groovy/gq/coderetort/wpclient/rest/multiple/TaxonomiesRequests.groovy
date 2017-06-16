package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.rest.base.CommonRequests;

class TaxonomiesRequests extends CommonRequests {

    Closure get = { restClient.getTaxonomies(it) }
}