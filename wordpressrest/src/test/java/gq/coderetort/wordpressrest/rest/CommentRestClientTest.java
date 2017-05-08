package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gq.coderetort.wordpressrest.models.Comment;
import gq.coderetort.wordpressrest.rest.queries.QueryGetComments;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test // should return certain amount of posts of specified page
    public void getCommentsByPage() throws Exception {
        int itemsPerPage = 2;

        QueryGetComments query = new QueryGetComments.Builder()
                .page(1)
                .itemsPerPage(itemsPerPage)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        assertTrue(comments.size() == itemsPerPage);
    }

    @Test
    public void getCommentsBySearch() throws Exception {
        String searchString = "Cool";

        QueryGetComments query = new QueryGetComments.Builder()
                .searchFor(searchString)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment comment : comments) {
            assertNotNull(comment.content);
            assertNotNull(comment.content.rendered);
            assertNotNull(comment.type);
            assertTrue(comment.content.rendered.contains(searchString) || comment.type.contains(searchString));
        }
    }

    @Test
    public void getCommentsByAfterDate() throws Exception {
        String dateAfter = "2016-03-01T12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date afterDate = sdf.parse(dateAfter);

        QueryGetComments query = new QueryGetComments.Builder()
                .after(dateAfter)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment page: comments) {
            assertTrue(page.getDate().after(afterDate));
        }
    }

    @Test
    public void getCommentsByAuthor() throws Exception {
        List<Integer> authors = new ArrayList<>();
        authors.add(135);
        QueryGetComments query = new QueryGetComments.Builder()
                .authors(authors)
                .build();
        List<Comment> comments = restClient.getComments(query);

        // not permitted without auth
    }

    @Test
    public void getCommentsByAuthorExclude() throws Exception {
        List<Integer> excludedAuthors = new ArrayList<>();
        excludedAuthors.add(135);
        QueryGetComments query = new QueryGetComments.Builder()
                .excludeAuthors(excludedAuthors)
                .build();
        List<Comment> comments = restClient.getComments(query);

        // not permitted without auth
    }

    @Test
    public void getCommentsByAuthorEmail() throws Exception {
        List<Integer> excludedAuthors = new ArrayList<>();
        excludedAuthors.add(135);
        QueryGetComments query = new QueryGetComments.Builder()
                .authorEmail("random@email.com")
                .build();
        List<Comment> comments = restClient.getComments(query);

        // not permitted without auth
    }

    @Test
    public void getCommentsByBeforeDate() throws Exception {
        String dateBefore = "2017-03-01T12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date beforeDate = sdf.parse(dateBefore);

        QueryGetComments query = new QueryGetComments.Builder()
                .before(dateBefore)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment comment : comments) {
            assertTrue(comment.getDate().before(beforeDate));
        }
    }

    @Test
    public void getPagesByExclude() throws Exception {
        List<Integer> excludedComments = new ArrayList<>();
        excludedComments.add(1);

        QueryGetComments query = new QueryGetComments.Builder()
                .exclude(excludedComments)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment comment : comments) {
            assertFalse(excludedComments.contains(comment.id));
        }
    }

    @Test
    public void getCommentsByInclude() throws Exception {
        List<Integer> includedComments = new ArrayList<>();
        includedComments.add(1);

        QueryGetComments query = new QueryGetComments.Builder()
                .includeOnly(includedComments)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment comment : comments) {
            assertTrue(includedComments.contains(comment.id));
        }
    }

    @Test
    public void getCommentsByKarma() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .karma(0)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        for (Comment comment : comments) {
            assertTrue(comment.karma == null || comment.karma == 0);
        }
    }

    @Test
    public void getCommentsByOffset() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .offset(1)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Test
    public void getCommentsByOrder() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .order("asc")
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());

        Comment comment = comments.get(0);
        assertNotNull(comment);
        assertTrue(comment.id == 1);
    }

    @Test
    public void getCommentsByOrderBy() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .orderBy("type")
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Test
    public void getCommentsByParentExclude() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .excludeParent(1)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment comment : comments) {
            assertNotNull(comment.parent);
            assertFalse(comment.parent == 1);
        }
    }

    @Test
    public void getCommentsByParentInclude() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .limitToParent(0)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        for (Comment comment : comments) {
            assertNotNull(comment.parent);
            assertTrue(comment.parent == 0);
        }
    }

    @Test
    public void getCommentsByPost() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .post(470, 490)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        for (Comment comment : comments) {
            assertNotNull(comment);
            assertNotNull(comment.post);
            assertTrue(comment.post == 470 || comment.post == 490);
        }
    }

    @Test
    public void getCommentsByStatus() throws Exception {
        List<String> statuses = new ArrayList<>();
        statuses.add("approve");

        QueryGetComments query = new QueryGetComments.Builder()
                .limitToStatus(statuses)
                .build();
        List<Comment> comments = restClient.getComments(query);

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Test
    public void getCommentsByType() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .type("comment")
                .build();
        List<Comment> comments = restClient.getComments(query);

        // not permitted without auth
    }

    @Test
    public void getComment() throws Exception {
        Comment comment = restClient.getComment(2);

        // requires auth
    }
}
