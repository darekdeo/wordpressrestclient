package gq.coderetort.wordpressrest.rest;

import java.util.List;

import gq.coderetort.wordpressrest.models.Category;
import gq.coderetort.wordpressrest.models.Page;
import gq.coderetort.wordpressrest.models.Post;
import gq.coderetort.wordpressrest.models.Tag;
import io.reactivex.Observable;
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
     * @param status Limit result set to posts assigned one or more status. Default: publish
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
            @Query("author[]") List<Integer> author,
            @Query("author_exclude[]") List<Integer> authorExclude,
            @Query("before") String before,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("offset") Integer offset,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("slug[]") List<String> slug,
            @Query("status[]") List<String> status,
            @Query("categories[]") List<Integer> categories,
            @Query("categories_exclude[]") List<Integer> categoriesExclude,
            @Query("tags[]") List<Integer> tags,
            @Query("tags_exclude[]") List<Integer> tagsExclude,
            @Query("sticky") Boolean sticky);

    @GET("posts")
    Observable<List<Post>> getPostsObservable();

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
     * @param status Limit result set to posts assigned one or more status. Default: publish
     * @param categories Limit result set to all items that have the specified term assigned in the categories taxonomy.
     * @param categoriesExclude Limit result set to all items except those that have the specified term assigned in the categories taxonomy.
     * @param tags Limit result set to all items that have the specified term assigned in the tags taxonomy.
     * @param tagsExclude Limit result set to all items except those that have the specified term assigned in the tags taxonomy.
     * @param sticky Limit result set to items that are sticky.
     * @return
     */
    @GET("posts")
    Observable<List<Post>> getPostsObservable(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("after") String after,
            @Query("author[]") List<Integer> author,
            @Query("author_exclude[]") List<Integer> authorExclude,
            @Query("before") String before,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("offset") Integer offset,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("slug[]") List<String> slug,
            @Query("status[]") List<String> status,
            @Query("categories[]") List<Integer> categories,
            @Query("categories_exclude[]") List<Integer> categoriesExclude,
            @Query("tags[]") List<Integer> tags,
            @Query("tags_exclude[]") List<Integer> tagsExclude,
            @Query("sticky") Boolean sticky);

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") Integer postId);

    /**
     * @param postId Id of a post.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") Integer postId,
                       @Query("context") String context,
                       @Query("password") String password);

    @GET("posts/{id}")
    Observable<Post> getPostObservable(@Path("id") Integer postId);

    /**
     * @param postId Id of a post.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("posts/{id}")
    Observable<Post> getPostObservable(@Path("id") Integer postId,
                                       @Query("context") String context,
                                       @Query("password") String password);

    // todo add create post
    // todo add update post
    // todo add delete post

    // todo add post revisions crud

    @GET("categories")
    Call<List<Category>> getCategories();

    /**
     * @param context Scope under which the request is made; determines fields present in response.
     *                Default: view; One of: view, embed, edit
     * @param page Current page of the collection. Default: 1
     * @param perPage Maximum number of items to be returned in result set. Default: 10
     * @param search Limit results to those matching a string.
     * @param exclude Ensure result set excludes specific IDs.
     * @param include Limit result set to specific IDs.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by term attribute. Default: date; One of: id, include, name, slug, term_group, description, count
     * @param hideEmpty Whether to hide terms not assigned to any posts.
     * @param parent Limit result set to terms assigned to a specific parent.
     * @param post Limit result set to terms assigned to a specific post.
     * @param slug Limit result set to terms with a specific slug.
     * @return
     */
    @GET("categories")
    Call<List<Category>> getCategories(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("hide_empty") Boolean hideEmpty,
            @Query("parent") Integer parent,
            @Query("post") Integer post,
            @Query("slug") String slug);

    @GET("categories")
    Observable<List<Category>> getCategoriesObservable();

    /**
     * @param context Scope under which the request is made; determines fields present in response.
     *                Default: view; One of: view, embed, edit
     * @param page Current page of the collection. Default: 1
     * @param perPage Maximum number of items to be returned in result set. Default: 10
     * @param search Limit results to those matching a string.
     * @param exclude Ensure result set excludes specific IDs.
     * @param include Limit result set to specific IDs.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by term attribute. Default: date; One of: id, include, name, slug, term_group, description, count
     * @param hideEmpty Whether to hide terms not assigned to any posts.
     * @param parent Limit result set to terms assigned to a specific parent.
     * @param post Limit result set to terms assigned to a specific post.
     * @param slug Limit result set to terms with a specific slug.
     * @return
     */
    @GET("categories")
    Observable<List<Category>> getCategoriesObservable(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("hide_empty") Boolean hideEmpty,
            @Query("parent") Integer parent,
            @Query("post") Integer post,
            @Query("slug") String slug);

    /**
     * @param categoryId ID of a category.
     * @return
     */
    @GET("categories/{id}")
    Call<Category> getCategory(@Path("id") Integer categoryId);

    /**
     * @param categoryId ID of a category.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @return
     */
    @GET("categories/{id}")
    Call<Category> getCategory(@Path("id") Integer categoryId, @Query("context") String context);

    /**
     * @param categoryId ID of a category.
     * @return
     */
    @GET("categories/{id}")
    Observable<Category> getCategoryObservable(@Path("id") Integer categoryId);

    /**
     * @param categoryId ID of a category.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @return
     */
    @GET("categories/{id}")
    Observable<Category> getCategoryObservable(@Path("id") Integer categoryId, @Query("context") String context);

    // todo add create category
    // todo add update category
    // todo add delete category

    @GET("tags")
    Call<List<Tag>> getTags();

    /**
     * @param context Scope under which the request is made; determines fields present in response.
     *                Default: view; One of: view, embed, edit
     * @param page Current page of the collection. Default: 1
     * @param perPage Maximum number of items to be returned in result set. Default: 10
     * @param search Limit results to those matching a string.
     * @param exclude Ensure result set excludes specific IDs.
     * @param include Limit result set to specific IDs.
     * @param offset Offset the result set by a specific number of items.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by term attribute. Default: date; One of: id, include, name, slug, term_group, description, count
     * @param hideEmpty Whether to hide terms not assigned to any posts.
     * @param post Limit result set to terms assigned to a specific post.
     * @param slug Limit result set to terms with a specific slug.
     * @return
     */
    @GET("tags")
    Call<List<Tag>> getTags(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("offset") Integer offset,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("hide_empty") Boolean hideEmpty,
            @Query("post") Integer post,
            @Query("slug") String slug);

    @GET("tags")
    Observable<List<Tag>> getTagsObservable();

    /**
     * @param context Scope under which the request is made; determines fields present in response.
     *                Default: view; One of: view, embed, edit
     * @param page Current page of the collection. Default: 1
     * @param perPage Maximum number of items to be returned in result set. Default: 10
     * @param search Limit results to those matching a string.
     * @param exclude Ensure result set excludes specific IDs.
     * @param include Limit result set to specific IDs.
     * @param offset Offset the result set by a specific number of items.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by term attribute. Default: date; One of: id, include, name, slug, term_group, description, count
     * @param hideEmpty Whether to hide terms not assigned to any posts.
     * @param post Limit result set to terms assigned to a specific post.
     * @param slug Limit result set to terms with a specific slug.
     * @return
     */
    @GET("tags")
    Observable<List<Tag>> getTagsObservable(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("offset") Integer offset,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("hide_empty") Boolean hideEmpty,
            @Query("post") Integer post,
            @Query("slug") String slug);

    /**
     * @param tagId ID of a tag.
     * @return
     */
    @GET("tags/{id}")
    Call<Tag> getTag(@Path("id") Integer tagId);

    /**
     * @param tagId ID of a tag.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @return
     */
    @GET("tags/{id}")
    Call<Tag> getTag(@Path("id") Integer tagId, @Query("context") String context);

    /**
     * @param tagId ID of a tag.
     * @return
     */
    @GET("tags/{id}")
    Observable<Tag> getTagObservable(@Path("id") Integer tagId);

    /**
     * @param tagId ID of a tag.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @return
     */
    @GET("tags/{id}")
    Observable<Tag> getTagObservable(@Path("id") Integer tagId, @Query("context") String context);

    // todo add create tag
    // todo add update tag
    // todo add delete tag

    @GET("pages")
    Call<List<Page>> getPages();

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
     * @param menu_order Limit result set to resources with a specific menu_order value.
     * @param offset Offset the result set by a specific number of items.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by object attribute. Default: date; One of: date, relevance, id, include, title, slug, menu_order
     * @param parent Limit result set to those of particular parent ids.
     * @param parentExclude Limit result set to all items except those of a particular parent id.
     * @param slug Limit result set to posts with one or more specific slug.
     * @param status Limit result set to posts assigned a specific status; can be comma-delimited list of status types. Default: publish; One of: publish, future, draft, pending, private, trash, auto-draft, inherit, any
     * @param query Use WP Query arguments to modify the response; private query vars require appropriate authorization.
     * @return
     */
    @GET("pages")
    Call<List<Page>> getPages(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("after") String after,
            @Query("author[]") List<Integer> author,
            @Query("author_exclude[]") List<Integer> authorExclude,
            @Query("before") String before,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("menu_order") Integer menu_order,
            @Query("offset") Integer offset,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("parent[]") List<Integer> parent,
            @Query("parent_exclude[]") List<Integer> parentExclude,
            @Query("slug[]") List<String> slug,
            @Query("status[]") List<String> status,
            @Query("filter[]") List<String> query
    );

    @GET("pages")
    Observable<List<Page>> getPagesObservable();

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
     * @param menu_order Limit result set to resources with a specific menu_order value.
     * @param offset Offset the result set by a specific number of items.
     * @param order Order sort attribute ascending or descending. Default: desc; One of: asc, desc
     * @param orderBy Sort collection by object attribute. Default: date; One of: date, relevance, id, include, title, slug, menu_order
     * @param parent Limit result set to those of particular parent ids.
     * @param parentExclude Limit result set to all items except those of a particular parent id.
     * @param slug Limit result set to posts with one or more specific slug.
     * @param status Limit result set to posts assigned a specific status; can be comma-delimited list of status types. Default: publish; One of: publish, future, draft, pending, private, trash, auto-draft, inherit, any
     * @param query Use WP Query arguments to modify the response; private query vars require appropriate authorization.
     * @return
     */
    @GET("pages")
    Observable<List<Page>> getPagesObservable(
            @Query("context") String context,
            @Query("page") Integer page,
            @Query("per_page") Integer perPage,
            @Query("search") String search,
            @Query("after") String after,
            @Query("author[]") List<Integer> author,
            @Query("author_exclude[]") List<Integer> authorExclude,
            @Query("before") String before,
            @Query("exclude[]") List<Integer> exclude,
            @Query("include[]") List<Integer> include,
            @Query("menu_order") Integer menu_order,
            @Query("offset") Integer offset,
            @Query("order") String order,
            @Query("orderby") String orderBy,
            @Query("parent[]") List<Integer> parent,
            @Query("parent_exclude[]") List<Integer> parentExclude,
            @Query("slug[]") List<String> slug,
            @Query("status[]") List<String> status,
            @Query("filter[]") List<String> query
    );

    @GET("pages/{id}")
    Call<Page> getPage(@Path("id") Integer pageId);

    /**
     * @param pageId Id of a page.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("pages/{id}")
    Call<Page> getPage(@Path("id") Integer pageId,
                       @Query("context") String context,
                       @Query("password") String password);

    @GET("pages/{id}")
    Observable<Page> getPageObservable(@Path("id") Integer pageId);

    /**
     * @param pageId Id of a page.
     * @param context Scope under which the request is made; determines fields present in response. Default: view; One of: view, embed, edit.
     * @param password The password for the post if it is password protected.
     * @return
     */
    @GET("pages/{id}")
    Observable<Page> getPageObservable(@Path("id") Integer pageId,
                                       @Query("context") String context,
                                       @Query("password") String password);

    // todo add create page
    // todo add update page
    // todo add delete page
}
