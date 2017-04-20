package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryGetTagsTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {
        QueryGetTags query = new QueryGetTags.Builder()
                .context("view")
                .page(1)
                .hideEmpty(true)
                .offset(2)
                .build();

        assertNotNull(query);
    }
}