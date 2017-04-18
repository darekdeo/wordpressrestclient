package gq.coderetort.wordpressrest.rest.queries;

import java.util.ArrayList;
import java.util.List;

public abstract class Query {

    public List<Integer> getExcludeNegativeList(List<Integer> exclude) {
        List<Integer> excludeNegativeList = null;
        if (exclude != null && !exclude.isEmpty()) {
            excludeNegativeList = new ArrayList<>();
            for (Integer number : exclude) {
                if (number > 0)
                    number = number * -1;
                excludeNegativeList.add(number);
            }
        }
        return excludeNegativeList;
    }

    public String getExcludeString(List<Integer> exclude) {
        String excluded = null;
        if (exclude != null && !exclude.isEmpty()) {
            for (Integer excludeId : exclude) {
                if (excluded == null) {
                    excluded = "-" + excludeId;
                } else {
                    excluded = excluded.concat(", -" + excludeId);
                }
            }
        }
        return excluded;
    }
}
