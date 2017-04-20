package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryGetCategoriesTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() throws Exception {

        QueryGetCategories query = new QueryGetCategories.Builder()
                .context("view") // bottom level
                .page(1) // level 1
                .hideEmpty(true) // level 2
                .limitToParent(1) // top level
                .build(); // yey!
        assertNotNull(query);
    }

}