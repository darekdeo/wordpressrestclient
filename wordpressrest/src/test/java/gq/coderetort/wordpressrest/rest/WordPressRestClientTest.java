package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gq.coderetort.wordpressrest.models.Post;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPost;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPosts;

import static org.junit.Assert.*;

public class WordPressRestClientTest {

    WordPressRestClient restClient;

    @Before
    public void setUp() {
        restClient = new WordPressRestClient("http://demo.wp-api.org/wp-json/wp/v2/"); // put your address to test here
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
    public void getPostsByContext() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .context("view") // default one
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

    @Test // should return certain amount of posts of specified page
    public void getPostsByPage() throws Exception {
        int itemsPerPage = 12;

        QueryGetPosts query = new QueryGetPosts.Builder()
                .page(2)
                .itemsPerPage(itemsPerPage)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        assertTrue(posts.size() == itemsPerPage);
    }

    @Test
    public void getPostsBySearch() throws Exception {
        String searchString = "test";

        QueryGetPosts query = new QueryGetPosts.Builder()
                .searchFor(searchString)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertNotNull(post.content);
            assertNotNull(post.content.rendered);
            assertNotNull(post.slug);
            assertTrue(
                    post.content.rendered.contains(searchString) ||
                    post.slug.contains(searchString)
            );
        }
    }

    @Test
    public void getPostsByAfterDate() throws Exception {
        String dateAfter = "2017-03-01T12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date afterDate = sdf.parse("2017-03-01T12:00:00");

        QueryGetPosts query = new QueryGetPosts.Builder()
                .after(dateAfter)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post: posts) {
            assertTrue(post.getDate().after(afterDate));
        }
    }

    @Test
    public void getPostsByAuthor() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .author(226)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertTrue(post.author == 226);
        }
    }

    @Test
    public void getPostsByAuthorExclude() throws Exception {
        List<Integer> excludedAuthors = new ArrayList<>();
        excludedAuthors.add(226);
        excludedAuthors.add(135);
        QueryGetPosts query = new QueryGetPosts.Builder()
                .excludeAuthors(excludedAuthors)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertFalse(excludedAuthors.contains(post.author));
        }
    }

    @Test
    public void getPostsByBeforeDate() throws Exception {
        String dateBefore = "2017-03-01T12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date beforeDate = sdf.parse("2017-03-01T12:00:00");

        QueryGetPosts query = new QueryGetPosts.Builder()
                .before(dateBefore)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertTrue(post.getDate().before(beforeDate));
        }
    }

    @Test
    public void getPostsByExclude() throws Exception {
        List<Integer> excludedPosts = new ArrayList<>();
        excludedPosts.add(470);
        excludedPosts.add(490);
        excludedPosts.add(503);

        QueryGetPosts query = new QueryGetPosts.Builder()
                .exclude(excludedPosts)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertFalse(excludedPosts.contains(post.id));
        }
    }

    @Test
    public void getPostsByInclude() throws Exception {
        List<Integer> includedPosts = new ArrayList<>();
        includedPosts.add(470);
        includedPosts.add(490);
        includedPosts.add(503);

        QueryGetPosts query = new QueryGetPosts.Builder()
                .includeOnly(includedPosts)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertTrue(includedPosts.contains(post.id));
        }
    }

    @Test
    public void getPostsByOffset() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .offset(7)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

    @Test
    public void getPostsByOrder() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .order("asc")
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());

        Post post = posts.get(0);
        assertNotNull(post);
        assertTrue(post.id == 1);
    }

    @Test
    public void getPostsByOrderBy() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .orderBy("slug")
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

//    @Test
//    public void getPostsBySlug() throws Exception {
//        List<String> slugs = new ArrayList<>();
//        slugs.add("test");
////        slugs.add("asd");
//
//        QueryGetPosts query = new QueryGetPosts.Builder()
//                .slug(slugs)
//                .build();
//        List<Post> posts = restClient.getPosts(query);
//
//        assertNotNull(posts);
//        assertFalse(posts.isEmpty());
//    }

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