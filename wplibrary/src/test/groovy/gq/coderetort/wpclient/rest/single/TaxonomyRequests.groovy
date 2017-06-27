package gq.coderetort.wpclient.rest.single

import gq.coderetort.wpclient.rest.base.CommonRequests

class TaxonomyRequests extends CommonRequests {

    Closure get = { restClient.getTaxonomy("category", it) }
}