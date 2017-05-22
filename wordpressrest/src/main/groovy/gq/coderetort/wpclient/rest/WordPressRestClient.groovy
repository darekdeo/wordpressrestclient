package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.queries.Query
import io.reactivex.annotations.Nullable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class WordPressRestClient {

    WordPressService apiService;

    WordPressRestClient(OkHttpClient httpClient, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient ?: new OkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        apiService = retrofit.create(WordPressService.class)
    }

    List<Post> getPosts(@Nullable Query query = null) {
        executeSafeCall(query, { apiService.getPosts(it) })?.body()
    }

    Post getPost(@Nullable Query query = null) {
        executeSafeCall(query, { apiService.getPost(it) })?.body()
    }

    private static def executeSafeCall(@Nullable Query query, Closure closure) {
        try {
            def emptyMap = [:]
            closure(query?.asMap() ?: emptyMap).execute()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}