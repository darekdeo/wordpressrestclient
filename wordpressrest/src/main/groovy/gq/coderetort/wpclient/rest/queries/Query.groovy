package gq.coderetort.wpclient.rest.queries

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.builder.Builder

import java.lang.reflect.Field;

@Builder
class Query {

    String context
    Integer page
    @JsonProperty("per_page")
    Integer perPage
    String search
    List<Integer> exclude
    List<Integer> include
    String order
    @JsonProperty("orderby")
    String orderBy
    @JsonProperty("hide_empty")
    Boolean hideEmpty
//    Integer post
//    String slug
    String password
    String after
    List<Integer> author
    @JsonProperty("author_exclude")
    List<Integer> authorExclude
    String before
    Integer offset
    String status
    @JsonProperty("status")
    List<String> statusList
    Integer parent
    @JsonProperty("parent_exclude")
    Integer parentExclude
    @JsonProperty("parent")
    List<Integer> parentList
    @JsonProperty("parent_exclude")
    List<Integer> parentExcludeList
    @JsonProperty("author_email")
    String authorEmail
    Integer karma
    Integer post
    @JsonProperty("post")
    List<Integer> postList
    String type
    @JsonProperty("menu_order")
    Integer menuOrder;
    List<String> slug;
    List<String> filter; // todo how to do
    List<Integer> categories
    @JsonProperty("categories_exclude")
    List<Integer> categoriesExclude
    List<Integer> tags
    @JsonProperty("tags_exclude")
    List<Integer> tagsExclude
    Boolean sticky

    Map asMap() {
        this.class.declaredFields.findAll {
            !it.synthetic && this."$it.name" != null
        }.collectEntries {
            def field = this.getClass().getDeclaredField(it.name)
            def jsonName = field.getAnnotation(JsonProperty)?.value()

            if (field.getType() == List.class) {
                def key = jsonName ?: it.name
                key = key + "[]"

                def value = generateQueryStringArray(field, key)
                [(key): value]
            } else {
                [(jsonName ?: it.name): this."$it.name"]
            }
        }
    }

    private def generateQueryStringArray(Field field, key) {
        def string = ""

        field.accessible = true
        List list = field.get(this)
        field.accessible = false

        list.eachWithIndex { def entry, int index ->
            string = string + "$entry"
            if (index + 1 != list.size())
                string = string + "&$key="
        }
        return string
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