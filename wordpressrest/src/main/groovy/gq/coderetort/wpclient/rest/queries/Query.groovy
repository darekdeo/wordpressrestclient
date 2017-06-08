package gq.coderetort.wpclient.rest.queries

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.builder.Builder;

@Builder
class Query {

    String context
    Integer page
    @JsonProperty("per_page") perPage
    String search
    List<Integer> exclude
    List<Integer> include
    String order
    @JsonProperty("orderby") String orderBy
    @JsonProperty("hide_empty") Boolean hideEmpty
//    Integer post
//    String slug
    String password
    String after
    List<Integer> author
    @JsonProperty("author_exclude") List<Integer> authorExclude
    String before
    Integer offset
    List<String> status
//    Integer parent
    List<Integer> parent
    @JsonProperty("parent_exclude") List<Integer> parentExclude
    @JsonProperty("author_email") String authorEmail
    Integer karma
    List<Integer> post
    List<String> type
    @JsonProperty("menu_order") Integer menuOrder;
    List<String> slug;
    List<String> filter; // todo how to do
    List<Integer> categories
    @JsonProperty("categories_exclude") List<Integer> categoriesExclude
    List<Integer> tags
    @JsonProperty("tags_exclude") List<Integer> tagsExclude
    Boolean sticky

    Map asMap() {
        this.class.declaredFields.findAll { !it.synthetic && this."$it.name" != null }.collectEntries {
            def jsonName = this.getClass().getDeclaredField(it.name).getAnnotation(JsonProperty)?.value()
            [ (jsonName?:it.name):this."$it.name" ]
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