package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryGetPostTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetPost query = new QueryGetPost.Builder()
                .context("view") // bottom level
                .build(); // top level and build

        assertNotNull(query);
    }
}