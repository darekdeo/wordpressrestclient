package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import gq.coderetort.wordpressrest.models.Post;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPost;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPosts;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class WordPressRestClientTest {

    WordPressRestClient restClient;

    @Before
    public void setUp() {
        restClient = new WordPressRestClient("http://demo.wp-api.org/wp-json/wp/v2/"); // put address to test here
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getWordPressService() throws Exception {
        WordPressService restService = restClient.getWordPressService();
        assertNotNull(restService);
    }

    @Test
    public void getPosts() throws Exception {
        List<Post> posts = restClient.getPosts();
        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

    @Test
    public void getPostsByQuery() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder().build();
        List<Post> posts = restClient.getPosts(query);
        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

    @Test
    public void getPost() throws Exception {
        Post post = restClient.getPost(490);
        assertNotNull(post);
    }

    @Test
    public void getPostByQuery() throws Exception {
        QueryGetPost query = new QueryGetPost.Builder().build();
        Post post = restClient.getPost(490, query);
        assertNotNull(post);
    }
}