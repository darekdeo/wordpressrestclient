package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Category
import gq.coderetort.wpclient.models.Comment
import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.models.Tag
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

    @GET("tags")
    Call<List<Tag>> getTags(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("tags")
    Observable<List<Tag>> getTagsObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param tagId Id of a tag.
     * @return
     */
    @GET("tags/{id}")
    Call<Tag> getTag(@Path("id") Integer tagId,
                     @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param tagId Id of a tag.
     * @return
     */
    @GET("tags/{id}")
    Observable<Tag> getTagObservable(@Path("id") Integer tagId,
                                     @QueryMap(encoded = true) Map<String, Object> params)

    @GET("comments")
    Call<List<Comment>> getComments(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("comments")
    Observable<List<Comment>> getCommentsObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param commentId Id of a comment.
     * @return
     */
    @GET("comments/{id}")
    Call<Comment> getComment(@Path("id") Integer commentId,
                     @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param commentId Id of a comment.
     * @return
     */
    @GET("comments/{id}")
    Observable<Comment> getCommentObservable(@Path("id") Integer commentId,
                         @QueryMap(encoded = true) Map<String, Object> params)
}
