package gq.coderetort.wpclient.rest;

class TagsRequests extends TermRequests {

    Closure get = { restClient.getTags(it) }
    String searchString = "accusantium"
    int postId = 35
    def excluded = [6, 4]
    def included = [6, 4]
    def slug = ["voluptatem-iure-accusantium-deserunt-rerum-assumenda-ut-quia-et"]
}