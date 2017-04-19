package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertNotNull;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PostRestClientTest.class,
        CategoryRestClientTest.class,
        RxWordPressRestClientTest.class
})
public class WordPressRestClientTestSuit {

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
    public void getWordPressService() throws Exception {
        WordPressService restService = restClient.getWordPressService();

        assertNotNull(restService);
    }

//    @Test
//    public void postRestClientTestSuite() throws Exception {
//        runTests(PostRestClientTest.class);
//    }

    private static void runTests(Class test){
        Result result = JUnitCore.runClasses(test);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
    }
}