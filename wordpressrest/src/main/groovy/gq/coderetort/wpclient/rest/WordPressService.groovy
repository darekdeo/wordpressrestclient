package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

import java.lang.Object

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

    @GET("pages")
    Call<List<Page>> getPages(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("pages")
    Observable<List<Page>> getPagesObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param pageId Id of a page.
     * @return
     */
    @GET("pages/{id}")
    Call<Page> getPage(@Path("id") Integer pageId,
                       @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param pageId Id of a page.
     * @return
     */
    @GET("pages/{id}")
    Observable<Page> getPageObservable(@Path("id") Integer pageId,
                                       @QueryMap(encoded = true) Map<String, Object> params)

    @GET("taxonomies")
    Call<List<Taxonomy>> getTaxonomies(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("taxonomies")
    Observable<List<Taxonomy>> getTaxonomiesObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param taxonomy a taxonomy.
     * @return
     */
    @GET("taxonomies/{taxonomy}")
    Call<Taxonomy> getTaxonomy(@Path("taxonomy") String taxonomy,
                               @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param taxonomy a taxonomy.
     * @return
     */
    @GET("taxonomies/{taxonomy}")
    Observable<Taxonomy> getTaxonomyObservable(@Path("taxonomy") String taxonomy,
                                               @QueryMap(encoded = true) Map<String, Object> params)

    @GET("media")
    Call<List<Media>> getMediaList(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("media")
    Observable<List<Media>> getMediaListObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param mediaId Id of a media.
     * @return
     */
    @GET("media/{id}")
    Call<Media> getMedia(@Path("id") Integer mediaId,
                         @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param mediaId Id of a media.
     * @return
     */
    @GET("media/{id}")
    Observable<Media> getMediaObservable(@Path("id") Integer mediaId,
                                         @QueryMap(encoded = true) Map<String, Object> params)

    @GET("users")
    Call<List<User>> getUsers(
            @QueryMap(encoded = true) Map<String, Object> params)

    @GET("users")
    Observable<List<User>> getUsersObservable(
            @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param userId Id of a user.
     * @return
     */
    @GET("users/{id}")
    Call<User> getUser(@Path("id") Integer userId,
                       @QueryMap(encoded = true) Map<String, Object> params)

    /**
     * @param userId Id of a user.
     * @return
     */
    @GET("users/{id}")
    Observable<User> getUserObservable(@Path("id") Integer userId,
                                       @QueryMap(encoded = true) Map<String, Object> params)
}
