package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Post
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface WordPressService {

    @GET("posts")
    Call<List<Post>> getPosts(
            @QueryMap Map<String, Object> params
    )

    @GET("posts")
    Observable<List<Post>> getPostsObservable(
            @QueryMap Map<String, Object> params
    )

    /**
     * @param postId Id of a post.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") Integer postId,
                       @Query("context") String context,
                       @Query("password") String password)

    /**
     * @param postId Id of a post.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("posts/{id}")
    Observable<Post> getPostObservable(@Path("id") Integer postId,
                                       @Query("context") String context,
                                       @Query("password") String password)
}
