package gq.coderetort.wpclient.rest

import gq.coderetort.wpclient.models.Link
import gq.coderetort.wpclient.models.Links
import gq.coderetort.wpclient.models.Taxonomy
import groovy.json.JsonSlurper
import okhttp3.ResponseBody
import retrofit2.Converter

class TaxonomiesResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    TaxonomiesResponseBodyConverter() {
        setupStringToCamelCase()
    }

    private static void setupStringToCamelCase() {
        String.metaClass.toCamelCase() {
            def unwantedChars = ["_", "-"]
            def string = delegate
            unwantedChars.each { unwantedChar ->
                string = removeUnwatedChars(string, unwantedChar)
            }
            return string
        }
    }

    private static String removeUnwatedChars(String string, String charToRemove) {
        while (string.contains(charToRemove)) {
            int underscoreIndex = string.indexOf(charToRemove)

            if (underscoreIndex != 0 && string.size() - 1 > underscoreIndex) {
                char toUpperChar = string.charAt(underscoreIndex + 1)

                StringBuilder myKey = new StringBuilder(string)
                myKey.deleteCharAt(underscoreIndex)
                myKey.setCharAt(underscoreIndex, toUpperChar.toUpperCase())
                string = myKey.toString()
            } else {
                string = string.replace(charToRemove, "")
            }
        }
        return string
    }

    @Override
    T convert(ResponseBody value) throws IOException {
        try {
            List<Taxonomy> taxonomies = new ArrayList<>()
            String jsonString = value.string()

            def list = new JsonSlurper().parseText(jsonString)
            list.each { taxonomyJson ->
                Taxonomy taxonomy = new Taxonomy()
                taxonomyJson.value.each { taxonomyField ->
                    String key = taxonomyField.key
                    key = key.toCamelCase()
                    switch (key) {
                        case ("links"):
                            taxonomy.links = parseLinks(taxonomyField)
                            break
                        case ("capabilities"):
                            // todo add capabilities parsing
                            break
                        case ("labels"):
                            // todo add labels parsing
                            break
                        case ("meta"):
                            // todo add meta parsing
                            break
                        default:
                            taxonomy."$key" = taxonomyField.value
                            break
                    }
                }
                taxonomies.add taxonomy
            }
            return taxonomies
        } finally {
            value.close()
        }
    }

    public Links parseLinks(taxonomyField) { // todo add test
        Links linksObject = new Links()
        taxonomyField.value.each { links ->
            def linkList = []

            String key = links.key
            key = key.replace("wp:", "")
            key = key.toCamelCase()

            links.value.each { linkField ->
                Link linkObject = new Link()
                linkField.each {
                    String linkKey = it.key
                    linkKey = linkKey.replace("wp:", "")
                    linkKey = linkKey.toCamelCase()

                    linkObject."$linkKey" = it.value
                }
                linkList.add linkObject
            }

            linksObject."$key" = linkList
        }
        return linksObject
    }
}