package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Comment
import gq.coderetort.wpclient.rest.base.EntriesRequests
import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Ignore;

class CommentsRequests extends EntriesRequests {

    Closure get = { restClient.getComments(it) }
    String searchString = "moderating"
    String dateAfter = "2017-03-01T12:00:00"
    String dateBefore = "2017-07-01T12:00:00"
    def excluded = [2]
    def included = [1]
    def authors = []
    def excludedAuthors = []

    @Ignore("unauthorized")
    def "get comments by author email"() {
        given: "Author email and query with specified request params"
        String authorEmail = "random@email.com"
        Query query = new Query.QueryBuilder()
                .authorEmail(authorEmail)
                .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "each comment should be written by specified author"
        comments.each { comment ->
            assert comment.authorEmail == authorEmail
        }
    }

    def "get comments by karma"() {
        given: "Karma value and query with specified request params"
        int karma = 0
        Query query = new Query.QueryBuilder()
                .karma(karma)
                .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "each comment should have specified karma or no karma"
        comments.each { comment ->
            assert comment.karma == null || comment.karma == karma
        }
    }

    def "get comments by parent exclude"() {
        given: "Excluded parents to check and query with specified request params"
        def excludedParents = [1, 2]
        Query query = new Query.QueryBuilder()
                .parentExcludeList(excludedParents)
                .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "each comment parent should not be in excluded parents"
        comments.each { comment ->
            assert !excludedParents.contains(comment.parent)
        }
    }

    def "get comments by parent include"() {
        given: "Parents to check and query with specified request params"
        def parents = [0]
        Query query = new Query.QueryBuilder()
            .parentList(parents)
            .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "each comment parent should be in included parents"
        comments.each { comment ->
            assert parents.contains(comment.parent)
        }
    }

    def "get comments by posts"() {
        given: "Posts to check and query with specified request params"
        def posts = [1]
        Query query = new Query.QueryBuilder()
                .postList(posts)
                .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "each comment should be for specified posts"
        comments.each { comment ->
            assert posts.contains(comment.post)
        }
    }

    @Ignore("unauthorized")
    def "get comments by status"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .status("approved")
                .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "each comment should have specified status"
        comments.each { comment ->
            assert comment.status == "approved"
        }
    }

    def "get comments by type"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .type("comment")
                .build()

        when: "Comments are downloaded from rest"
        List<Comment> comments = get(query)

        then: "List of comments should not be null or empty"
        comments != null
        !comments.isEmpty()

        and: "should by of specified type"
        comments.each { comment ->
            assert comment.type == "comment"
        }
    }
}