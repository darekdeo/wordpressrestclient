package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Category
import gq.coderetort.wpclient.models.Post
import gq.coderetort.wpclient.rest.queries.Query
import spock.lang.Shared

abstract class CommonListRequests extends CommonRequests {

    @Shared
    String searchString
    @Shared
    def excluded
    @Shared
    def included
    @Shared
    def slug

    def "get certain amount of models in specified page"() {
        given: "A query with specified request params"
        def itemsPerPage = 2
        Query query = new Query.QueryBuilder()
                .page(1)
                .perPage(itemsPerPage)
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "Size of the list of models should match specified items per page"
        models != null
        models.size() == itemsPerPage
    }

    def "get models by search"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .search(searchString)
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "List of models should not be empty"
        models != null
        !models.isEmpty()

        and: "each model should contain search string in either rendered or slug"
        models.each { model ->
            if (model instanceof Post)
                assert (model.content?.rendered?.contains(searchString) || model.slug?.contains(searchString))
            if (model instanceof Category)
                assert (model.name?.contains(searchString) || model.slug?.contains(searchString))
        }
    }

    def "get models without excluded ones"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .exclude(excluded)
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "List of models should not be empty"
        models != null
        !models.isEmpty()

        and: "excluded models should not be in the list"
        models.each { model ->
            assert !excluded.contains(model.id)
        }
    }

    def "get only included models"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .include(included)
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "List of models should not be empty"
        models != null
        !models.isEmpty()

        and: "models should be in the included list"
        models.each { model ->
            assert included.contains(model.id)
        }
    }

    def "get models by order"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .orderBy("id")
                .order("asc")
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "List of models should not be empty"
        models != null
        !models.isEmpty()

        and: "order is asc"
        def prev = null
        models.each { model ->
            if (prev != null)
                assert model.id > prev.id
            prev = model
        }
    }

    def "get models by offset"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .offset(1)
                .build()

        when: "Models are downloaded from rest with given query"
        def posts = get(query)

        then: "List of models should not be empty"
        posts != null
        !posts.isEmpty()
    }

    def "get models by slug"() {
        given: "A query with specified request params"
        Query query = new Query.QueryBuilder()
                .slug(slug)
                .build()

        when: "Models are downloaded from rest with given query"
        def models = get(query)

        then: "List of categories should not be empty"
        models != null
        !models.isEmpty()

        and: "should contain only items with specified slug"
        models.each { model ->
            assert slug.contains(model.slug)
        }
    }
}