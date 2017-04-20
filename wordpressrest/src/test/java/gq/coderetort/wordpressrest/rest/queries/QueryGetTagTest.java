package gq.coderetort.wordpressrest.rest.queries;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueryGetTagTest {

    @Test
    public void buildQueryFromBottomLevelHierarchy() {
        QueryGetTag query = new QueryGetTag.Builder()
                .context("view") // bottom level
                .build(); // top level and build

        assertNotNull(query);
    }

}