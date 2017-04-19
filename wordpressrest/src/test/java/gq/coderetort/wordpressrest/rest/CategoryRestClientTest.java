package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gq.coderetort.wordpressrest.models.Category;
import gq.coderetort.wordpressrest.rest.queries.QueryGetCategories;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CategoryRestClientTest {

    WordPressRestClient restClient;

    @Before
    public void setUp() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        restClient = new WordPressRestClient(httpClient, "http://demo.wp-api.org/wp-json/wp/v2/"); // put your address to test here
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getCategories() throws Exception {
        List<Category> categories = restClient.getCategories();

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void getCategoriesByQuery() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder().build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void getCategoriesByContext() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder()
                .context("view") // default is view
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void getCategoriesByPage() throws Exception {
        int itemsPerPage = 2;
        QueryGetCategories query = new QueryGetCategories.Builder()
                .page(1)
                .itemsPerPage(itemsPerPage)
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        assertTrue(categories.size() == itemsPerPage);
    }

    @Test
    public void getCategoriesBySearch() throws Exception {
        String searchString = "pple";

        QueryGetCategories query = new QueryGetCategories.Builder()
                .searchFor(searchString)
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        for (Category category : categories) {
            assertNotNull(category.name);
            assertTrue(category.name.contains(searchString));
            assertNotNull(category.slug);
            assertTrue(category.slug.contains(searchString));
        }
    }

    @Test
    public void getCategoriesByExclude() throws Exception {
        List<Integer> excludedCategories = new ArrayList<>();
        excludedCategories.add(5);
        excludedCategories.add(6);

        QueryGetCategories query = new QueryGetCategories.Builder()
                .exclude(excludedCategories)
                .build();
        List<Category> posts = restClient.getCategories(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Category post : posts) {
            assertFalse(excludedCategories.contains(post.id));
        }
    }

    @Test
    public void getCategoriesByInclude() throws Exception {
        List<Integer> includedCategories = new ArrayList<>();
        includedCategories.add(5);
        includedCategories.add(6);

        QueryGetCategories query = new QueryGetCategories.Builder()
                .includeOnly(includedCategories)
                .build();
        List<Category> posts = restClient.getCategories(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Category post : posts) {
            assertTrue(includedCategories.contains(post.id));
        }
    }

    @Test
    public void getCategoriesByOrder() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder()
                .orderBy("id")
                .order("asc")
                .build();
        List<Category> posts = restClient.getCategories(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());

        Category post = posts.get(0);
        assertNotNull(post);
        assertTrue(post.id == 1);
    }

    @Test
    public void getCategoriesByHideEmpty() throws Exception {
        // todo fill test
    }

    @Test
    public void getCategoriesByParent() throws Exception {
        // todo fill test
    }

    @Test
    public void getCategoriesByPost() throws Exception {
        // todo fill test
    }
}
