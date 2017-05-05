package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QueryGetPageTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetPage query = new QueryGetPage.Builder()
                .context("view") // bottom level
                .build(); // top level and build

        assertNotNull(query);
    }
}
