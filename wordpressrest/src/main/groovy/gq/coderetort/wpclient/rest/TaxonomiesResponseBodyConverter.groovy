package gq.coderetort.wpclient.rest

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
            println delegate
            while (delegate.contains("_")) {
                int underscoreIndex = delegate.indexOf("_")

                if (delegate.size() - 1 > underscoreIndex) {
                    char toUpperChar = delegate.charAt(underscoreIndex + 1)

                    StringBuilder myKey = new StringBuilder(delegate);
                    myKey.deleteCharAt(underscoreIndex)
                    myKey.setCharAt(underscoreIndex, toUpperChar.toUpperCase())
                    delegate = myKey.toString()
                } else {
                    delegate = delegate.replace("_", "")
                }
            }
            return delegate
        }
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
                    // todo finish object arrays
                    switch (key) {
                        case ("_links"):
//                            println taxonomyField.value.getClass()
                            break
                        case ("capabilities"):
                            break
                        case ("labels"):
                            break
                        case ("types"):
                            break
                        case ("meta"):
                            break
                        default :
                            key = key.toCamelCase()
                            taxonomy."$key" = taxonomyField.value
                            break
                    }
                }
                taxonomies.add taxonomy
            }
            println taxonomies
            return taxonomies
        } finally {
            value.close()
        }
    }
}