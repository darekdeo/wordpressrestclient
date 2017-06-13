package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.queries.Query

import java.text.SimpleDateFormat

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
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault())
        Date afterDate = sdf.parse(dateAfter)

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
        List<Integer> authors = new ArrayList<>();
        authors.add(1)
        authors.add(2)
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

}