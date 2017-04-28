package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import gq.coderetort.wordpressrest.models.Page;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPages;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PageRestClientTest {

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
    public void getPages() throws Exception {
        List<Page> pages = restClient.getPages();

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
    }

    @Test
    public void getPagesByQuery() throws Exception {
        QueryGetPages query = new QueryGetPages.Builder().build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
    }
}
