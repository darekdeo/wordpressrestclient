package gq.coderetort.wordpressrest.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gq.coderetort.wordpressrest.models.Post;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPost;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPosts;
import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class WordPressRestClient {

    WordPressService apiService;

    public WordPressRestClient(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(new OkHttpClient())
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
                    query.getExcludeString(query.getAuthorExclude()),
                    query.getBefore(),
                    query.getExcludeString(query.getExclude()),
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
        Observable<List<Post>> call;
        if (query == null) {
            call = apiService.getPostsObservable();
        } else {
            call = apiService.getPostsObservable(
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
        Observable<Post> call;
        if (query == null) {
            call = apiService.getPostObservable(postId);
        } else {
            call = apiService.getPostObservable(postId, query.getContext(), query.getPassword());
        }
        return call;
    }
}
