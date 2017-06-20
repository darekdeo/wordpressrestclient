package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.models.Taxonomy
import gq.coderetort.wpclient.rest.base.CommonRequests
import gq.coderetort.wpclient.rest.queries.Query

class TaxonomiesRequests extends CommonRequests {

    Closure get = { restClient.getTaxonomies(it) }

    def "get taxonomies by type"() {
        given: "Type to check and query with specified request params"
        String type = "post"
        Query query = new Query.QueryBuilder()
            .type(type)
            .build()

        when: "Taxonomies are downloaded from rest with given query"
        Map<String, Taxonomy> taxonomies = get(query)

        then: "List of taxonomies should not be empty"
        taxonomies != null
        !taxonomies.isEmpty()

        and: "each taxonomy should be of requested type"
        taxonomies.each { taxonomy ->
            assert taxonomy.value.types != null
            assert taxonomy.value.types.contains(type)
        }
    }
}