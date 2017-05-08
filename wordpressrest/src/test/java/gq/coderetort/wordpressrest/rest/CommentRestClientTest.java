package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import gq.coderetort.wordpressrest.models.Comment;
import gq.coderetort.wordpressrest.rest.queries.QueryGetComments;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CommentRestClientTest {

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
    public void getComments() throws Exception {
        List<Comment> comments = restClient.getComments();

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Test
    public void getCommentsByQuery() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder().build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Test
    public void getCommentsByContext() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .context("view") // default one
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }
}
