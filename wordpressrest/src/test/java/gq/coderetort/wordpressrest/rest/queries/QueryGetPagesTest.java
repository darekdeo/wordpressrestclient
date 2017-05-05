package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QueryGetPagesTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetPages query = new QueryGetPages.Builder()
                .context("view") // bottom level
                .page(1) // level 1
                .offset(2) // level 2
                .menuOrder(1) // top level
                .build();

        assertNotNull(query);
    }
}
