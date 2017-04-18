package gq.coderetort.wordpressrest.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import gq.coderetort.wordpressrest.models.Post;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.TestObserver;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author dejanarchos@gmail.com
 * @since 10:51 18.04.2017
 */
public class RxWordPressRestClientTest {

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
    public void getRxPostsList() throws Exception {
        TestObserver<List<Post>> testObserver = new TestObserver<>();
        restClient.getPostsObservable(null).subscribe(testObserver);
        testObserver.assertNoErrors();
        testObserver.assertValueCount(1);
    }

    @Test
    public void getRxPosts() throws Exception {
        TestObserver<Post> testObserver = new TestObserver<>();
        restClient.getPostsObservable(null)
                .flatMap(new Function<List<Post>, ObservableSource<Post>>() {
                    @Override
                    public ObservableSource<Post> apply(@NonNull List<Post> posts) throws Exception {
                        return Observable.fromIterable(posts);
                    }
                })
                .subscribe(testObserver);
        testObserver.assertNoErrors();
        testObserver.assertValueCount(10);
    }
}
