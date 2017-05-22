package gq.coderetort.wpclient.rest.queries

import groovy.transform.builder.Builder;

@Builder
class Query {

    String context
    Integer page
    Integer perPage
    String search
    List<Integer> exclude
    List<Integer> include
    String order
    String orderBy
    Boolean hideEmpty
//    Integer post
//    String slug
    String password
    String after
    List<Integer> author
    List<Integer> authorExclude
    String before
    Integer offset
    List<String> status
//    Integer parent
    List<Integer> parent
    List<Integer> parentExclude
    String authorEmail
    Integer karma
    List<Integer> post
    List<String> type
    Integer menuOrder;
    List<String> slug;
    List<String> filter; // todo how to do
    List<Integer> categories
    List<Integer> categoriesExclude
    List<Integer> tags
    List<Integer> tagsExclude
    Boolean sticky

    Map asMap() {
        this.class.declaredFields.findAll { !it.synthetic && this."$it.name" != null }.collectEntries {
            [ (it.name):this."$it.name" ]
        }
    }

    List<Integer> getExcludeNegativeList(List<Integer> exclude) {
        if (!exclude?.isEmpty()) {
            def excludeNegativeList = []
            exclude.each { number ->
                number > 0 ?: number * -1
                excludeNegativeList.add(number)
            }
            return excludeNegativeList
        }
    }

    String getExcludeString(List<Integer> exclude) {
        if (!exclude?.isEmpty()) {
            String excluded
            exclude.each { excludeId ->
                if (excluded == null)
                    excluded = "-" + excludeId
                else
                    excluded = excluded.concat(", -" + excludeId)
            }
            return excluded
        }
    }
}