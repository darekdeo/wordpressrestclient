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

import static org.junit.Assert.*;

public class CategoryRestClientTest {

    private WordPressRestClient restClient;

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
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        for (Category category : categories) {
            assertFalse(excludedCategories.contains(category.id));
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
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        for (Category category : categories) {
            assertTrue(includedCategories.contains(category.id));
        }
    }

    @Test
    public void getCategoriesByOrder() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder()
                .orderBy("id")
                .order("asc")
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());

        Category category = categories.get(0);
        assertNotNull(category);
        assertTrue(category.id == 1);
    }

    @Test
    public void getCategoriesByHideEmpty() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder()
                .hideEmpty(true)
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void getCategoriesByParent() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder()
                .limitToParent(6)
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        assertTrue(categories.size() == 1);
    }

    @Test
    public void getCategoriesByPost() throws Exception {
        QueryGetCategories query = new QueryGetCategories.Builder()
                .limitToPost(470)
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void getCategoriesBySlug() throws Exception {
        String slug = "apple-event";
        QueryGetCategories query = new QueryGetCategories.Builder()
                .limitToSlug(slug)
                .build();
        List<Category> categories = restClient.getCategories(query);

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        assertEquals(slug, categories.get(0).slug);
    }
}
