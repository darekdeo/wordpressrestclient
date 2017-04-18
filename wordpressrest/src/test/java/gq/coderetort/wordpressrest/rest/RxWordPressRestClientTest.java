package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import gq.coderetort.wordpressrest.models.Post;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author dejanarchos@gmail.com
 * @since 10:51 18.04.2017
 */
public class RxWordPressRestClientTest {

    WordPressRestClient restClient;

    @Before
    public void setUp() {
        restClient = new WordPressRestClient("http://demo.wp-api.org/wp-json/wp/v2/"); // put your address to test here
    }

    @After
    public void tearDown() {
    }


    @Test
    public void getRxPosts() throws Exception {
        restClient.getPostsObservable(null)
                .subscribe(new TestObserver<List<Post>>() {
                    @Override
                    public void onNext(List<Post> posts) {
                        assertNotNull(posts);
                        assertFalse(posts.isEmpty());
                    }

                    @Override
                    public void onError(Throwable e) {
                        assertNull("error occurred: ".concat(e.getMessage()), e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
