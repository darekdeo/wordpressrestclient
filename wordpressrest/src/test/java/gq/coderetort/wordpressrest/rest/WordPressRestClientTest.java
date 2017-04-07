package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordPressRestClientTest {

    WordPressRestClient restClient;

    @Before
    public void setUp() {
        restClient = new WordPressRestClient("http://example.com/wp/v2/");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getWordPressService() throws Exception {
        WordPressService restService = restClient.getWordPressService();
        assertNotNull(restService);
    }
}