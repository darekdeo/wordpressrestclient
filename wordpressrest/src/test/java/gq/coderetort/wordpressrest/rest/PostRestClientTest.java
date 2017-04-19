package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gq.coderetort.wordpressrest.models.Post;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPost;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPosts;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PostRestClientTest {

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
            assertTrue(post.content.rendered.contains(searchString) || post.slug.contains(searchString));
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
        List<Integer> authors = new ArrayList<>();
        authors.add(226);
        authors.add(1);
        QueryGetPosts query = new QueryGetPosts.Builder()
                .authors(authors)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertNotNull(post);
            assertNotNull(post.author);
            assertTrue(authors.contains(post.author));
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

    @Test
    public void getPostsBySlug() throws Exception {
        List<String> slugs = new ArrayList<>();
        slugs.add("testasdfasdfasdfasdfasdf");
        slugs.add("4711your-post-title");

        QueryGetPosts query = new QueryGetPosts.Builder()
                .slug(slugs)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        assertTrue(posts.size() == 2);
    }

    @Test
    public void getPostsByStatus() throws Exception {
        List<String> statuses = new ArrayList<>();
        statuses.add("publish");

        QueryGetPosts query = new QueryGetPosts.Builder()
                .limitToStatuses(statuses)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

    @Test
    public void getPostsByCategories() throws Exception {
        List<Integer> categories = new ArrayList<>();
        categories.add(1);
        categories.add(7);

        QueryGetPosts query = new QueryGetPosts.Builder()
                .limitToCategories(categories)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertNotNull(post);
            assertNotNull(post.categories);
            assertFalse(Collections.disjoint(categories, post.categories));
        }
    }

    @Test
    public void getPostsByCategoriesExclude() throws Exception {
        List<Integer> excludedCategories = new ArrayList<>();
        excludedCategories.add(1);
        excludedCategories.add(7);

        QueryGetPosts query = new QueryGetPosts.Builder()
                .excludeCategories(excludedCategories)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertNotNull(post);
            assertNotNull(post.categories);
            assertTrue(Collections.disjoint(excludedCategories, post.categories));
        }
    }

    @Test
    public void getPostsByTags() throws Exception {
        List<Integer> tags = new ArrayList<>();
        tags.add(2);
        tags.add(3);

        QueryGetPosts query = new QueryGetPosts.Builder()
                .limitToTags(tags)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertNotNull(post);
            assertNotNull(post.tags);
            assertFalse(Collections.disjoint(tags, post.tags));
        }
    }

    @Test
    public void getPostsByTagsExclude() throws Exception {
        List<Integer> excludedTags = new ArrayList<>();
        excludedTags.add(2);
        excludedTags.add(3);

        QueryGetPosts query = new QueryGetPosts.Builder()
                .excludeTags(excludedTags)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertNotNull(post);
            assertNotNull(post.tags);
            assertTrue(Collections.disjoint(excludedTags, post.tags));
        }
    }

    @Test
    public void getPostsBySticky() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .onlySticky(false)
                .build();
        List<Post> posts = restClient.getPosts(query);

        assertNotNull(posts);
        assertFalse(posts.isEmpty());
        for (Post post : posts) {
            assertFalse(post.sticky);
        }
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

    @Test
    public void getPostWithContext() throws Exception {
        QueryGetPost query = new QueryGetPost.Builder()
                .context("view")
                .build();
        Post post = restClient.getPost(490, query);

        assertNotNull(post);
    }

    @Test
    public void getPostWithPassword() throws Exception {
        QueryGetPost query = new QueryGetPost.Builder()
                .password("test_password")
                .build();
        Post post = restClient.getPost(490, query);

        // todo need password protected post/article
    }
}
