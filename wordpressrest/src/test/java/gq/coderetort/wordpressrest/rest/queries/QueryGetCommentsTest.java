package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QueryGetCommentsTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetComments query = new QueryGetComments.Builder()
                .context("view") // bottom level
                .page(1) // level 1
                .offset(2) // level 2
                .karma(2) // top level
                .build();

        assertNotNull(query);
    }
}
