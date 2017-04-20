package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryGetPostsTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetPosts query = new QueryGetPosts.Builder()
                .context("view") // bottom level
                .page(1) // level 1
                .offset(2) // level 2
                .onlySticky(true) // top level
                .build();

        assertNotNull(query);
    }
}