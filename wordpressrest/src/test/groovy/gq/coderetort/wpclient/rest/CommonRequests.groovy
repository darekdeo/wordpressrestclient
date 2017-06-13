package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.rest.queries.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import spock.lang.Shared
import spock.lang.Specification

abstract class CommonRequests extends Specification {

    WordPressRestClient restClient
    @Shared
    Closure get

    def setup() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor({ println it })
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new WordPressNetworkInterceptor())
                .addInterceptor(interceptor)
                .build()
        restClient = new WordPressRestClient(httpClient, "http://demo.wp-api.org/wp-json/wp/v2/")
    }

    def "get non empty list of models"() {
        when: "Models are downloaded from rest"
        def models = get()

        then: "List of models should not be null or empty"
        models != null
        try {
            !models?.isEmpty()
        } catch (MissingMethodException e) {
            // is not a list
        }
    }

    def "get non empty list of models by context"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .context("view") // default
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "List of models should not be null or empty"
        models != null
        try {
            !models?.isEmpty()
        } catch (MissingMethodException e) {
            // is not a list
        }
    }
}