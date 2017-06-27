package gq.coderetort.wpclient.rest.multiple

import gq.coderetort.wpclient.models.User
import gq.coderetort.wpclient.rest.base.CommonListRequests
import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Ignore

class UsersRequests extends CommonListRequests {

    Closure get = { restClient.getUsers(it) }
    String searchString = "Human"
    def excluded = [2]
    def included = [1]
    def slug = ["humanmade"]

    @Ignore
    def "get users by roles"() {
        given: "Roles list and query with specified request params"
        def roles = ["admin"]
        Query query = new Query.QueryBuilder()
                .roles(roles)
                .build()

        when: "Users are downloaded from rest with given request query"
        List<User> users = get(query)

        then: "List of users should not be null or empty"
        users != null
        !users.isEmpty()

        and: "each user should have specified role"
        users.each { user ->
            assert user.roles?.any(roles.contains(it))
        }
    }
}