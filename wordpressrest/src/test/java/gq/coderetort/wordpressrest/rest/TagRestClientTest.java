package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gq.coderetort.wordpressrest.models.Tag;
import gq.coderetort.wordpressrest.rest.queries.QueryGetTag;
import gq.coderetort.wordpressrest.rest.queries.QueryGetTags;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TagRestClientTest {

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
    public void getTags() throws Exception {
        List<Tag> tags = restClient.getTags();

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
    }

    @Test
    public void getTagsByQuery() throws Exception {
        QueryGetTags query = new QueryGetTags.Builder()
                .context("view")
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
    }

    @Test
    public void getTagsByPage() throws Exception {
        int itemsPerPage = 1;
        QueryGetTags query = new QueryGetTags.Builder()
                .page(1)
                .itemsPerPage(itemsPerPage)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
        assertTrue(tags.size() == itemsPerPage);
    }

    @Test
    public void getTagsBySearch() throws Exception {
        String searchString = "evenio";

        QueryGetTags query = new QueryGetTags.Builder()
                .searchFor(searchString)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
        for (Tag tag : tags) {
            assertNotNull(tag.name);
            assertTrue(tag.name.contains(searchString));
            assertNotNull(tag.slug);
            assertTrue(tag.slug.contains(searchString));
        }
    }

    @Test
    public void getTagsByExclude() throws Exception {
        List<Integer> excludedTags = new ArrayList<>();
        excludedTags.add(2);

        QueryGetTags query = new QueryGetTags.Builder()
                .exclude(2)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
        for (Tag category : tags) {
            assertFalse(excludedTags.contains(category.id));
        }
    }

    @Test
    public void getTagsByInclude() throws Exception {
        List<Integer> includedTags = new ArrayList<>();
        includedTags.add(2);

        QueryGetTags query = new QueryGetTags.Builder()
                .includeOnly(2)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
        for (Tag category : tags) {
            assertTrue(includedTags.contains(category.id));
        }
    }

    @Test
    public void getTagsByOffset() throws Exception {
        QueryGetTags query = new QueryGetTags.Builder()
                .offset(1)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
    }

    @Test
    public void getTagsByOrder() throws Exception {
        QueryGetTags query = new QueryGetTags.Builder()
                .orderBy("id")
                .order("asc")
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());

        Tag tag = tags.get(0);
        assertNotNull(tag);
        assertTrue(tag.id == 2);
    }

    @Test
    public void getTagsByHideEmpty() throws Exception {
        QueryGetTags query = new QueryGetTags.Builder()
                .hideEmpty(true)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
    }

    @Test
    public void getTagsByPost() throws Exception {
        QueryGetTags query = new QueryGetTags.Builder()
                .limitToPost(470)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        // no tags for post
    }

    @Test
    public void getTagsBySlug() throws Exception {
        String slug = "evenio";
        QueryGetTags query = new QueryGetTags.Builder()
                .limitToSlug(slug)
                .build();
        List<Tag> tags = restClient.getTags(query);

        assertNotNull(tags);
        assertFalse(tags.isEmpty());
        assertEquals(slug, tags.get(0).slug);
    }

    @Test
    public void getTag() throws Exception {
        Tag tag = restClient.getTag(2);

        assertNotNull(tag);
    }

    @Test
    public void getTagByQuery() throws Exception {
        QueryGetTag query = new QueryGetTag.Builder()
                .context("view")
                .build();
        Tag tag = restClient.getTag(2, query);

        assertNotNull(tag);
    }
}
