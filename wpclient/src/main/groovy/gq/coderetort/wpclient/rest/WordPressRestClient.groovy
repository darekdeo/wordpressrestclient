package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.*
import gq.coderetort.wpclient.rest.queries.Query
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WordPressRestClient {

    WordPressService apiService;

    WordPressRestClient(OkHttpClient httpClient, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient ?: getDefaultOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiService = retrofit.create(WordPressService.class)
    }

    private OkHttpClient getDefaultOkHttpClient() {
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new WordPressNetworkInterceptor())
                .build()
    }

    List<Post> getPosts(Query query) {
        executeSafeCall(query, { apiService.getPosts(it) })?.body()
    }

    Post getPost(int id, Query query = null) {
        executeSafeCall(query, { apiService.getPost(id, it) })?.body()
    }

    List<Category> getCategories(Query query = null) {
        executeSafeCall(query, { apiService.getCategories(it) })?.body()
    }

    Category getCategory(int id, Query query = null) {
        executeSafeCall(query, { apiService.getCategory(id, it) })?.body()
    }

    List<Tag> getTags(Query query = null) {
        executeSafeCall(query, { apiService.getTags(it) })?.body()
    }

    Tag getTag(int id, Query query = null) {
        executeSafeCall(query, { apiService.getTag(id, it) })?.body()
    }

    List<Comment> getComments(Query query = null) {
        executeSafeCall(query, { apiService.getComments(it) })?.body()
    }

    Comment getComment(int id, Query query = null) {
        executeSafeCall(query, { apiService.getComment(id, it) })?.body()
    }

    List<Page> getPages(Query query = null) {
        executeSafeCall(query, { apiService.getPages(it) })?.body()
    }

    Page getPage(int id, Query query = null) {
        executeSafeCall(query, { apiService.getPage(id, it) })?.body()
    }

    Map<String, Taxonomy> getTaxonomies(Query query = null) {
        executeSafeCall(query, { apiService.getTaxonomies(it) })?.body()
    }

    Taxonomy getTaxonomy(String taxonomy, Query query = null) {
        executeSafeCall(query, { apiService.getTaxonomy(taxonomy, it) })?.body()
    }

    List<Media> getMediaList(Query query = null) {
        executeSafeCall(query, { apiService.getMediaList(it) })?.body()
    }

    Media getMedia(int id, Query query = null) {
        executeSafeCall(query, { apiService.getMedia(id, it) })?.body()
    }

    List<User> getUsers(Query query = null) {
        executeSafeCall(query, { apiService.getUsers(it) })?.body()
    }

    User getUser(int id, Query query = null) {
        executeSafeCall(query, { apiService.getUser(id, it) })?.body()
    }

    Map<String, PostType> getPostTypes(Query query = null) {
        executeSafeCall(query, { apiService.getPostTypes(it) })?.body()
    }

    PostType getPostType(String postType, Query query = null) {
        executeSafeCall(query, { apiService.getPostType(postType, it) })?.body()
    }

    Map<String, PostStatus> getPostStatuses(Query query = null) {
        executeSafeCall(query, { apiService.getPostStatuses(it) })?.body()
    }

    PostStatus getPostStatus(String postStatus, Query query = null) {
        executeSafeCall(query, { apiService.getPostStatus(postStatus, it) })?.body()
    }

    private static def executeSafeCall(Query query, Closure closure) {
        try {
            def emptyMap = [:]
            closure(query?.asMap() ?: emptyMap).execute()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}