package gq.coderetort.wpclient.rest.base

import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Shared

abstract class ProtectedRequests extends CommonRequests {

    @Shared String password

    def "get model with password"() {
        given: "A password and query with specified request params"
        String password = "test_password"
        Query query = new Query.QueryBuilder()
                .password(password)
                .build()

        when: "Model is downloaded with specified id"
        def model = get(query)

        then: "Model will be null because password for this model is not needed"
        model == null
    }
}