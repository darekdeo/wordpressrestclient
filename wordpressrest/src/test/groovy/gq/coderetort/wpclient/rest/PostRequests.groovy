package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.queries.Query

class PostRequests extends CommonRequests {

    int postId = 33
    Closure get = { restClient.getPost(postId, it) }

    def "get post by id"() {
        when: "Post is downloaded with specified id"
        Post post = get()

        then: "Post should not be null and should have specified id"
        post != null
        post.id == postId
    }

    def "get post with context"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
            .context("view")
            .build()

        when: "Post is downloaded with specified id"
        Post post = get(query)

        then: "Post should not be null and should have specified id"
        post != null
        post.id == postId
    }

    def "get post with password"() {
        given: "A password and query with specified request params"
        String password = "test_password"
        Query query = new Query.QueryBuilder()
                .password(password)
                .build()

        when: "Post is downloaded with specified id"
        Post post = get(query)

        then: "Post will be null because password for this post is not needed"
        post == null
    }
}