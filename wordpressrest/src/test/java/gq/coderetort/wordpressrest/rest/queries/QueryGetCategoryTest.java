package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryGetCategoryTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetCategory query = new QueryGetCategory.Builder()
                .context("view") // bottom level
                .build(); // top level and build

        assertNotNull(query);
    }

}