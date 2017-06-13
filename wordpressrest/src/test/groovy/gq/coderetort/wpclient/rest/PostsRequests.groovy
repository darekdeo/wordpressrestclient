package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.queries.Query
import gq.coderetort.wpclient.utils.DateUtils

class PostsRequests extends CommonRequests {

    Closure get = { restClient.getPosts(it) }

    def "get certain amount of posts of page"() {
        given: "A query with specified request params"
        def itemsPerPage = 5
        Query query = new Query.QueryBuilder()
                .page(1)
                .perPage(itemsPerPage)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "Size of the list of posts should match specified items per page"
        posts != null
        posts.size() == itemsPerPage
    }

    def "get posts by search"() {
        given: "A search string and query with specified request params"
        def searchString = "Welcome"
        Query query = new Query.QueryBuilder()
                .search(searchString)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of post should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should contain search string in either rendered or slug"
        posts.each { post ->
            assert (post.content?.rendered?.contains(searchString) || post.slug?.contains(searchString))
        }
    }

    def "get posts by after date"() {
        given: "An after date to check and query with specified request params"
        String dateAfter = "2017-03-01T12:00:00"
        Date afterDate = DateUtils.parseISO8601(dateAfter)

        Query query = new Query.QueryBuilder()
                .after(dateAfter)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should be after the specified date"
        posts.each { post -> assert post.getDate().after(afterDate) }
    }

    def "get posts by authors"() {
        given: "A list of authors to check and query with specified request params"
        def authors = []
        authors.add 1
        authors.add 2
        Query query = new Query.QueryBuilder()
                .author(authors)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should be written by one of specified authors"
        posts.each { post ->
            assert authors.contains(post.author)
        }
    }

    def "get posts not by excluded authors"() {
        given: "A list of excluded authors and query with specified request params"
        def excludedAuthors = []
        excludedAuthors.add 2
        excludedAuthors.add 3
        Query query = new Query.QueryBuilder()
                .authorExclude(excludedAuthors)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query) // todo make sure adding minus to argument is not necessary

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should not be written by one of specified authors"
        posts.each { post ->
            assert !excludedAuthors.contains(post.author)
        }
    }

    def "get posts by before date"() {
        given: "A before date and query with specified request params"
        String dateBefore = "2017-06-01T12:00:00"
        Date beforeDate = DateUtils.parseISO8601(dateBefore)
        Query query = new Query.QueryBuilder()
                .before(dateBefore)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "each post should be before specified date"
        posts.each { post ->
            assert post.getDate() != null
            assert post.getDate().before(beforeDate)
        }
    }

    def "get posts without excluded ones"() {
        given: "A list of excluded posts and query with specified request params"
        def excludedPosts = []
        excludedPosts.add 9
        excludedPosts.add 11
        excludedPosts.add 33
        Query query = new Query.QueryBuilder()
                .exclude(excludedPosts)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "excluded posts should not be in the list"
        posts.each { post ->
            assert !excludedPosts.contains(post.id)
        }
    }

    def "get only included posts"() {
        given: "A list of included post ids and query with specified request params"
        def includedPosts = []
        includedPosts.add 9
        includedPosts.add 11
        includedPosts.add 33
        Query query = new Query.QueryBuilder()
                .include(includedPosts)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "posts should be in the included list"
        posts.each { post ->
            assert includedPosts.contains(post.id)
        }
    }

    def "get posts by offset"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .offset(3)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()
    }

    def "get posts by order"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .order("asc")
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "first post has specified id"
        posts.get(0).id == 29
    }

    def "get posts by orderby"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .orderBy("slug")
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()
    }

    def "get posts by slug"() {
        given: "List of slug and query with specified request params"
        def slugs = []
        slugs.add "ipsam-voluptate-nulla-consequatur-id-et"
        slugs.add "omnis-cumque-autem-culpa-assumenda-consequatur"
        Query query = new Query.QueryBuilder()
                .slug(slugs)
                .build()

        when: "Posts are downloaded from rest with given query"
        List<Post> posts = get(query)

        then: "List of posts should not be empty"
        posts != null
        !posts.isEmpty()

        and: "should contain only two items with specified slug"
        posts.size() == 2
        posts.each { post ->
            assert slugs.contains(post.slug)
        }
    }

    def "get posts by status"() {
        given: "List of statuses and query with specified request params"
        def statuses = []
        statuses.add "publish"
        Query query = new Query.QueryBuilder()
                .status(statuses)
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