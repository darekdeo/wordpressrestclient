package gq.coderetort.wordpressrest.rest;

import java.util.List;

import gq.coderetort.wordpressrest.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WordPressService {

    @GET("posts")
    Call<List<Post>> getPosts();

    /**
     * @param context Scope under which the request is made; determines fields present in response.
     *                Default: view; One of: view, embed, edit
     * @param page Current page of the collection. Default: 1
     * @param perPage Maximum number of items to be returned in result set. Default: 10
     * @param search Limit results to those matching a string.
     * @param after Limit response to posts published after a given ISO8601 compliant date.
     * @param author Limit result set to posts assigned to specific authors.
     * @param authorExclude Ensure result set excludes posts assigned to specific authors.
     * @param before Limit response to posts published before a given ISO8601 compliant date.
     * @param exclude Ensure result set excludes specific IDs.
     * @param include Limit result set to specific IDs.
     * @param offset Offset the result set by a specific number of items.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by object attribute. Default: date; One of: date, relevance, id, include, title, slug
     * @param slug Limit result set to posts with one or more specific slugs.
     * @param status Limit result set to posts assigned one or more statuses. Default: publish
     * @param categories Limit result set to all items that have the specified term assigned in the categories taxonomy.
     * @param categoriesExclude Limit result set to all items except those that have the specified term assigned in the categories taxonomy.
     * @param tags Limit result set to all items that have the specified term assigned in the tags taxonomy.
     * @param tagsExclude Limit result set to all items except those that have the specified term assigned in the tags taxonomy.
     * @param sticky Limit result set to items that are sticky.
     * @return
     */
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("after") String after,
            @Query("author") Integer author, // todo test author query param
            @Query("author_exclude") List<Integer> authorExclude, // todo test author_exclude query param
            @Query("before") String before,
            @Query("exclude") List<Integer> exclude, // todo test exclude query param
            @Query("include") List<Integer> include, // todo test include query param
            @Query("offset") Integer offset, // todo test offset query param
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("slug") List<String> slug, // todo test slug query param
            @Query("status") List<String> status, // todo test status query param
            @Query("categories") List<Integer> categories, // todo test categories query param
            @Query("categories_exclude") List<Integer> categoriesExclude, // todo test categories_exclude query param
            @Query("tags") List<Integer> tags, // todo test tags query param
            @Query("tags_exclude") List<Integer> tagsExclude, // todo test tags_exclude query param
            @Query("sticky") Boolean sticky); // todo test sticky query param

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") String postId);

    /**
     * @param postId Id of a post.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") String postId,
                       @Query("context") String context,
                       @Query("password") String password);

    // todo add create post
    // todo add update post
    // todo add delete post

}
