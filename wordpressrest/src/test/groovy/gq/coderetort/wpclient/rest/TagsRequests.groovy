package gq.coderetort.wpclient.rest;

class TagsRequests extends CommonListRequests {

    Closure get = { restClient.getTags(it) }
    String searchString = "accusantium"
    def excluded = [6, 4]
    def included = [6, 4]
    def slug = ["voluptatem-iure-accusantium-deserunt-rerum-assumenda-ut-quia-et"]
}