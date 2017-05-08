package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QueryGetCommentTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetComment query = new QueryGetComment.Builder()
                .context("view") // bottom level
                .build(); // top level and build

        assertNotNull(query);
    }
}
