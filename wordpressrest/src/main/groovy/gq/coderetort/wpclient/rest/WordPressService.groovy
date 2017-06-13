package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Category
import gq.coderetort.wpclient.models.Post
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface WordPressService {

    @GET("posts")
    Call<List<Post>> getPosts(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("posts")
    Observable<List<Post>> getPostsObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param postId Id of a post.
     * @return
     */
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") Integer postId,
                       @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param postId Id of a post.
     * @return
     */
    @GET("posts/{id}")
    Observable<Post> getPostObservable(@Path("id") Integer postId,
                                       @QueryMap(encoded = true) Map<String, Object> params)

    @GET("categories")
    Call<List<Category>> getCategories(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("categories")
    Observable<List<Category>> getCategoriesObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param categoryId Id of a category.
     * @return
     */
    @GET("categories/{id}")
    Call<Category> getCategory(@Path("id") Integer categoryId,
                       @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param categoryId Id of a category.
     * @return
     */
    @GET("categories/{id}")
    Observable<Category> getCategoryObservable(@Path("id") Integer categoryId,
                           @QueryMap(encoded = true) Map<String, Object> params)
}
