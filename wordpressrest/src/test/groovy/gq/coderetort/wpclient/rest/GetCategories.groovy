package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.queries.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import spock.lang.Specification

class GetCategories extends Specification {

    WordPressRestClient restClient

    def setup() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor({ println it })
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        restClient = new WordPressRestClient(httpClient, "http://demo.wp-api.org/wp-json/wp/v2/")
    }

    def "getting posts"() {
        when: "Posts are downloaded from rest"
        List<Post> posts = restClient.getPosts()
        then: "List of posts should not be null or empty"
        posts != null
        !posts?.isEmpty()
    }

    def "getting posts by context"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
            .context("view") // default
            .build()
        when: "Posts are downloaded from rest with given query"
        List<Post> posts = restClient.getPosts(query)
        then: "List of posts should not be null or empty"
        posts != null
        !posts?.isEmpty()
    }
}