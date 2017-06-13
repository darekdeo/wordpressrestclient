package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Category
import gq.coderetort.wpclient.models.Comment
import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.models.Tag
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
                .client(httpClient ?: getDefaultOkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        apiService = retrofit.create(WordPressService.class)
    }

    private OkHttpClient getDefaultOkHttpClient() {
        new OkHttpClient.Builder().addNetworkInterceptor(new WordPressNetworkInterceptor()).build()
    }

    List<Post> getPosts(@Nullable Query query = null) {
        executeSafeCall(query, { apiService.getPosts(it) })?.body()
    }

    Post getPost(int id, @Nullable Query query = null) {
        executeSafeCall(query, { apiService.getPost(id, it) })?.body()
    }

    List<Category> getCategories(@Nullable Query query = null) {
        executeSafeCall(query, { apiService.getCategories(it) })?.body()
    }

    Category getCategory(int id, @Nullable Query query = null) {
        executeSafeCall(query, { apiService.getCategory(id, it) })?.body()
    }

    List<Tag> getTags(@Nullable Query query = null) {
        executeSafeCall(query, { apiService.getTags(it) })?.body()
    }

    Tag getTag(int id, Query query = null) {
        executeSafeCall(query, { apiService.getTag(id, it) })?.body()
    }

    List<Comment> getComments(@Nullable Query query = null) {
        executeSafeCall(query, { apiService.getComments(it) })?.body()
    }

    Comment getComment(int id, @Nullable Query query = null) {
        executeSafeCall(query, { apiService.getComment(id, it) })?.body()
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