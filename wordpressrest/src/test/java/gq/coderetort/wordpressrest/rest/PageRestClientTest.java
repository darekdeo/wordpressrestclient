package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gq.coderetort.wordpressrest.models.Page;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPage;
import gq.coderetort.wordpressrest.rest.queries.QueryGetPages;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void getPagesByContext() throws Exception {
        QueryGetPages query = new QueryGetPages.Builder()
                .context("view") // default one
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
    }

    @Test // should return certain amount of posts of specified page
    public void getPagesByPage() throws Exception {
        int itemsPerPage = 4;

        QueryGetPages query = new QueryGetPages.Builder()
                .page(2)
                .itemsPerPage(itemsPerPage)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        assertTrue(pages.size() == itemsPerPage);
    }

    @Test
    public void getPagesBySearch() throws Exception {
        String searchString = "sample";

        QueryGetPages query = new QueryGetPages.Builder()
                .searchFor(searchString)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertNotNull(page.content);
            assertNotNull(page.content.rendered);
            assertNotNull(page.slug);
            assertTrue(page.content.rendered.contains(searchString) || page.slug.contains(searchString));
        }
    }

    @Test
    public void getPagesByAfterDate() throws Exception {
        String dateAfter = "2016-03-01T12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date afterDate = sdf.parse(dateAfter);

        QueryGetPages query = new QueryGetPages.Builder()
                .after(dateAfter)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page: pages) {
            assertTrue(page.getDate().after(afterDate));
        }
    }

    @Test
    public void getPagesByAuthor() throws Exception {
        List<Integer> authors = new ArrayList<>();
        authors.add(226);
        authors.add(1);
        QueryGetPages query = new QueryGetPages.Builder()
                .authors(authors)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertNotNull(page);
            assertNotNull(page.author);
            assertTrue(authors.contains(page.author));
        }
    }

    @Test
    public void getPagesByAuthorExclude() throws Exception {
        List<Integer> excludedAuthors = new ArrayList<>();
        excludedAuthors.add(226);
        excludedAuthors.add(135);
        QueryGetPages query = new QueryGetPages.Builder()
                .excludeAuthors(excludedAuthors)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertFalse(excludedAuthors.contains(page.author));
        }
    }

    @Test
    public void getPagesByBeforeDate() throws Exception {
        String dateBefore = "2017-03-01T12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss", Locale.getDefault());
        Date beforeDate = sdf.parse(dateBefore);

        QueryGetPages query = new QueryGetPages.Builder()
                .before(dateBefore)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertTrue(page.getDate().before(beforeDate));
        }
    }

    @Test
    public void getPagesByExclude() throws Exception {
        List<Integer> excludedPages = new ArrayList<>();
        excludedPages.add(286);
        excludedPages.add(347);

        QueryGetPages query = new QueryGetPages.Builder()
                .exclude(286, 347)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertFalse(excludedPages.contains(page.id));
        }
    }

    @Test
    public void getPagesByInclude() throws Exception {
        List<Integer> includedPages = new ArrayList<>();
        includedPages.add(286);
        includedPages.add(347);

        QueryGetPages query = new QueryGetPages.Builder()
                .includeOnly(286, 347)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertTrue(includedPages.contains(page.id));
        }
    }

    @Test
    public void getPagesByMenuOrder() throws Exception {
        int menuOrderToSearch = 0;
        QueryGetPages query = new QueryGetPages.Builder()
                .menuOrder(menuOrderToSearch)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertTrue(page.menuOrder == menuOrderToSearch);
        }
    }

    @Test
    public void getPagesByOffset() throws Exception {
        QueryGetPages query = new QueryGetPages.Builder()
                .offset(3)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
    }

    @Test
    public void getPagesByOrder() throws Exception {
        QueryGetPages query = new QueryGetPages.Builder()
                .order("asc")
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());

        Page page = pages.get(0);
        assertNotNull(page);
        assertTrue(page.id == 2);
    }

    @Test
    public void getPagesByOrderBy() throws Exception {
        QueryGetPages query = new QueryGetPages.Builder()
                .orderBy("slug")
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
    }

    @Test
    public void getPagesByParentExclude() throws Exception {
        List<Integer> parentsToExclude = new ArrayList<>();
        parentsToExclude.add(1);
        QueryGetPages query = new QueryGetPages.Builder()
                .excludeParent(1)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertNotNull(page.parent);
            assertFalse(parentsToExclude.contains(page.parent));
        }
    }

    @Test
    public void getPagesByParentInclude() throws Exception {
        List<Integer> parentsToInclude = new ArrayList<>();
        parentsToInclude.add(0);
        QueryGetPages query = new QueryGetPages.Builder()
                .limitToParent(0)
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        for (Page page : pages) {
            assertNotNull(page.parent);
            assertTrue(parentsToInclude.contains(page.parent));
        }
    }

    @Test
    public void getPagesBySlug() throws Exception {
        List<String> slugs = new ArrayList<>();
        slugs.add("adipisci-praesentium-ut-qui-est-qui");
        slugs.add("et-totam-quia-quam-enim-id-voluptatem");

        QueryGetPages query = new QueryGetPages.Builder()
                .slug("adipisci-praesentium-ut-qui-est-qui", "et-totam-quia-quam-enim-id-voluptatem")
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
        assertTrue(pages.size() == 2);
    }

    @Test
    public void getPagesByStatus() throws Exception {
        List<String> statuses = new ArrayList<>();
        statuses.add("publish");

        QueryGetPages query = new QueryGetPages.Builder()
                .limitToStatus("publish")
                .build();
        List<Page> pages = restClient.getPages(query);

        assertNotNull(pages);
        assertFalse(pages.isEmpty());
    }

    @Test
    public void getPagesByFilter() throws Exception {
        // todo fill the test
    }

    @Test
    public void getPageWithContext() throws Exception {
        QueryGetPage query = new QueryGetPage.Builder()
                .context("view")
                .build();
        Page page = restClient.getPage(265, query);

        assertNotNull(page);
    }

    @Test
    public void getPageWithPassword() throws Exception {
        QueryGetPage query = new QueryGetPage.Builder()
                .password("test_password")
                .build();
        Page page = restClient.getPage(265, query);

        // todo need password protected post/article
    }
}
