package gq.coderetort.wpsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import gq.coderetort.wpclient.models.Post;
import gq.coderetort.wpclient.rest.WordPressRestClient;
import gq.coderetort.wpclient.rest.queries.Query;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                WordPressRestClient client = new WordPressRestClient(
                        null,
                        "http://demo.wp-api.org/wp-json/wp/v2/"
                );

                Query query = new Query.QueryBuilder()
                        .context("view")
                        .build();
                List<Post> posts = client.getPosts(query);

                Log.d(TAG, "list of posts is: " + String.valueOf(posts));
                for (Post post : posts) {
                    Log.d(TAG, "post: " + String.valueOf(post.getId()));
                }
            }
        }).start();
    }
}
