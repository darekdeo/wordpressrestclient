package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.base.BaseEntriesRequests
import gq.coderetort.wpclient.rest.queries.Query

class PostsRequests extends BaseEntriesRequests {

    Closure get = { restClient.getPosts(it) }
    String searchString = "Welcome"
    String dateAfter = "2017-03-01T12:00:00"
    String dateBefore = "2017-06-01T12:00:00"
    def excluded = [9, 11, 33]
    def included = [9, 11, 33]
    def authors = [1, 2]
    def excludedAuthors = [2, 3]
    def slug = ["ipsam-voluptate-nulla-consequatur-id-et", "omnis-cumque-autem-culpa-assumenda-consequatur"]

    def "get posts by status"() {
        given: "List of statuses and query with specified request params"
        def statuses = []
        statuses.add "publish"
        Query query = new Query.QueryBuilder()
                .statusList(statuses)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should have specified status"
        posts.each { post ->
            assert statuses.contains(post.status)
        }
    }

    def "get posts by categories"() {
        given: "List of categories and query with specified request params"
        def categories = []
        categories.add 11
        categories.add 2
        Query query = new Query.QueryBuilder()
                .categories(categories)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should have specified category or categories"
        posts.each { post ->
            assert !Collections.disjoint(categories, post.categories)
        }
    }

    def "get posts without excluded categories"() {
        given: "List of excluded categories and query with specified request params"
        def excludedCategories = []
        excludedCategories.add 11
        excludedCategories.add 2
        Query query = new Query.QueryBuilder()
                .categoriesExclude(excludedCategories)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should not have specified category or categories"
        posts.each { post ->
            assert Collections.disjoint(excludedCategories, post.categories)
        }
    }

    def "get posts by tags"() {
        given: "List of tags and query with specified request params"
        def tags = []
        tags.add 3
        tags.add 4
        Query query = new Query.QueryBuilder()
                .tags(tags)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should contain at least one of specified tag"
        posts.each { post ->
            assert !Collections.disjoint(tags, post.tags)
        }
    }

    def "get posts without excluded tags"() {
        given: "List of excluded tags and query with specified request params"
        def excludedTags = []
        excludedTags.add 3
        excludedTags.add 4
        Query query = new Query.QueryBuilder()
                .tagsExclude(excludedTags)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should not contain any of specified tag"
        posts.each { post ->
            assert Collections.disjoint(excludedTags, post.tags)
        }
    }

    def "get only non sticky posts"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
            .sticky(false)
            .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should not be sticky"
        posts.each { post ->
            assert !post.sticky
        }
    }

}