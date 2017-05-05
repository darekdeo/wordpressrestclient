package gq.coderetort.wordpressrest.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gq.coderetort.wordpressrest.models.Category;
import gq.coderetort.wordpressrest.models.Page;
import gq.coderetort.wordpressrest.models.Post;
import gq.coderetort.wordpressrest.models.Tag;
import gq.coderetort.wordpressrest.rest.queries.QueryGetCategories;
import gq.coderetort.wordpressrest.rest.queries.QueryGetCategory;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPage;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPages;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPost;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPosts;
import gq.coderetort.wordpressrest.rest.queries.QueryGetTag;
import gq.coderetort.wordpressrest.rest.queries.QueryGetTags;
import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class WordPressRestClient {

    private WordPressService apiService;

    public WordPressRestClient(String baseUrl) {
        this(null, baseUrl);
    }

    public WordPressRestClient(OkHttpClient httpClient, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient != null ? httpClient : new OkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(WordPressService.class);
    }

    public WordPressService getWordPressService() {
        return apiService;
    }

    public List<Post> getPosts() {
        return getPosts(null);
    }

    public List<Post> getPosts(@Nullable QueryGetPosts query) {
        Call<List<Post>> call = getPostsCall(query);
        try {
            Response<List<Post>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Call<List<Post>> getPostsCall(@Nullable QueryGetPosts query) {
        Call<List<Post>> call;
        if (query == null) {
            call = apiService.getPosts();
        } else {
            call = apiService.getPosts(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getAfter(),
                    query.getAuthor(),
                    query.getExcludeNegativeList(query.getAuthorExclude()),
                    query.getBefore(),
                    query.getExcludeNegativeList(query.getExclude()),
                    query.getInclude(),
                    query.getOffset(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getSlug(),
                    query.getStatus(),
                    query.getCategories(),
                    query.getCategoriesExclude(),
                    query.getTags(),
                    query.getTagsExclude(),
                    query.getSticky());
        }
        return call;
    }

    public Observable<List<Post>> getPostsObservable(@Nullable QueryGetPosts query) {
        Observable<List<Post>> observable;
        if (query == null) {
            observable = apiService.getPostsObservable();
        } else {
            observable = apiService.getPostsObservable(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getAfter(),
                    query.getAuthor(),
                    query.getExcludeNegativeList(query.getAuthorExclude()),
                    query.getBefore(),
                    query.getExcludeNegativeList(query.getExclude()),
                    query.getInclude(),
                    query.getOffset(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getSlug(),
                    query.getStatus(),
                    query.getCategories(),
                    query.getCategoriesExclude(),
                    query.getTags(),
                    query.getTagsExclude(),
                    query.getSticky());
        }
        return observable;
    }

    public Post getPost(int postId) {
        return getPost(postId, null);
    }

    public Post getPost(int postId, @Nullable QueryGetPost query) {
        Call<Post> call = getPostCall(postId, query);
        try {
            Response<Post> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Call<Post> getPostCall(int postId, @Nullable QueryGetPost query) {
        Call<Post> call;
        if (query == null) {
            call = apiService.getPost(postId);
        } else {
            call = apiService.getPost(postId, query.getContext(), query.getPassword());
        }
        return call;
    }

    public Observable<Post> getPostObservable(int postId, @Nullable QueryGetPost query) {
        Observable<Post> observable;
        if (query == null) {
            observable = apiService.getPostObservable(postId);
        } else {
            observable = apiService.getPostObservable(postId, query.getContext(), query.getPassword());
        }
        return observable;
    }

    public List<Category> getCategories() {
        return getCategories(null);
    }

    public List<Category> getCategories(@Nullable QueryGetCategories query) {
        Call<List<Category>> call = getCategoriesCall(query);
        try {
            Response<List<Category>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Call<List<Category>> getCategoriesCall(@Nullable QueryGetCategories query) {
        Call<List<Category>> call;
        if (query == null) {
            call = apiService.getCategories();
        } else {
            call = apiService.getCategories(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getExclude(),
                    query.getInclude(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getHideEmpty(),
                    query.getParent(),
                    query.getPost(),
                    query.getSlug());
        }
        return call;
    }

    public Observable<List<Category>> getCategoriesObservable(@Nullable QueryGetCategories query) {
        Observable<List<Category>> observable;
        if (query == null) {
            observable = apiService.getCategoriesObservable();
        } else {
            observable = apiService.getCategoriesObservable(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getExclude(),
                    query.getInclude(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getHideEmpty(),
                    query.getParent(),
                    query.getPost(),
                    query.getSlug());
        }
        return observable;
    }

    public Category getCategory(int categoryId) {
        return getCategory(categoryId, null);
    }

    public Category getCategory(int categoryId, @Nullable QueryGetCategory query) {
        Call<Category> call = getCategoryCall(categoryId, query);
        try {
            Response<Category> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Call<Category> getCategoryCall(int categoryId, @Nullable QueryGetCategory query) {
        Call<Category> call;
        if (query == null) {
            call = apiService.getCategory(categoryId);
        } else {
            call = apiService.getCategory(categoryId, query.getContext());
        }
        return call;
    }

    public Observable<Category> getCategoryObservable(int categoryId, @Nullable QueryGetCategory query) {
        Observable<Category> observable;
        if (query == null) {
            observable = apiService.getCategoryObservable(categoryId);
        } else {
            observable = apiService.getCategoryObservable(categoryId, query.getContext());
        }
        return observable;
    }

    public List<Tag> getTags() {
        return getTags(null);
    }

    public List<Tag> getTags(QueryGetTags query) {
        Call<List<Tag>> call = getTagsCall(query);
        try {
            Response<List<Tag>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Call<List<Tag>> getTagsCall(QueryGetTags query) {
        Call<List<Tag>> call;
        if (query == null) {
            call = apiService.getTags();
        } else {
            call = apiService.getTags(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getExclude(),
                    query.getInclude(),
                    query.getOffset(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getHideEmpty(),
                    query.getPost(),
                    query.getSlug());
        }
        return call;
    }

    public Observable<List<Tag>> getTagsObservable(QueryGetTags query) {
        Observable<List<Tag>> observable;
        if (query == null) {
            observable = apiService.getTagsObservable();
        } else {
            observable = apiService.getTagsObservable(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getExclude(),
                    query.getInclude(),
                    query.getOffset(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getHideEmpty(),
                    query.getPost(),
                    query.getSlug());
        }
        return observable;
    }

    public Tag getTag(int tagId) {
        return getTag(tagId, null);
    }

    public Tag getTag(int tagId, QueryGetTag query) {
        Call<Tag> call = getTagCall(tagId, query);
        try {
            Response<Tag> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Call<Tag> getTagCall(int tagId, QueryGetTag query) {
        Call<Tag> call;
        if (query == null) {
            call = apiService.getTag(tagId);
        } else {
            call = apiService.getTag(tagId, query.getContext());
        }
        return call;
    }

    public Observable<Tag> getTagObservable(int tagId, QueryGetTag query) {
        Observable<Tag> observable;
        if (query == null) {
            observable = apiService.getTagObservable(tagId);
        } else {
            observable = apiService.getTagObservable(tagId, query.getContext());
        }
        return observable;
    }

    public List<Page> getPages() {
        return getPages(null);
    }

    public List<Page> getPages(QueryGetPages query) {
        Call<List<Page>> call = getPagesCall(query);
        try {
            Response<List<Page>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Call<List<Page>> getPagesCall(QueryGetPages query) {
        Call<List<Page>> call;
        if (query == null) {
            call = apiService.getPages();
        } else {
            call = apiService.getPages(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getAfter(),
                    query.getAuthor(),
                    query.getAuthorExclude(),
                    query.getBefore(),
                    query.getExclude(),
                    query.getInclude(),
                    query.getMenuOrder(),
                    query.getOffset(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getParent(),
                    query.getParentExclude(),
                    query.getSlug(),
                    query.getStatus(),
                    query.getFilter());
        }
        return call;
    }

    public Observable<List<Page>> getPagesObservable(QueryGetPages query) {
        Observable<List<Page>> observable;
        if (query == null) {
            observable = apiService.getPagesObservable();
        } else {
            observable = apiService.getPagesObservable(
                    query.getContext(),
                    query.getPage(),
                    query.getPerPage(),
                    query.getSearch(),
                    query.getAfter(),
                    query.getAuthor(),
                    query.getAuthorExclude(),
                    query.getBefore(),
                    query.getExclude(),
                    query.getInclude(),
                    query.getMenuOrder(),
                    query.getOffset(),
                    query.getOrder(),
                    query.getOrderBy(),
                    query.getParent(),
                    query.getParentExclude(),
                    query.getSlug(),
                    query.getStatus(),
                    query.getFilter());
        }
        return observable;
    }

    public Page getPage(int pageId) {
        return getPage(pageId, null);
    }

    public Page getPage(int pageId, QueryGetPage query) {
        Call<Page> call = getPageCall(pageId, query);
        try {
            Response<Page> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Call<Page> getPageCall(int pageId, QueryGetPage query) {
        Call<Page> call;
        if (query == null) {
            call = apiService.getPage(pageId);
        } else {
            call = apiService.getPage(pageId, query.getContext(), query.getPassword());
        }
        return call;
    }

    public Observable<Page> getPageObservable(int pageId, QueryGetPage query) {
        Observable<Page> observable;
        if (query == null) {
            observable = apiService.getPageObservable(pageId);
        } else {
            observable = apiService.getPageObservable(pageId, query.getContext(), query.getPassword());
        }
        return observable;
    }
}
