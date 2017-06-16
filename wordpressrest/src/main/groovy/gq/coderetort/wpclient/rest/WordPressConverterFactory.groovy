package gq.coderetort.wpclient.rest

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

import java.lang.annotation.Annotation
import java.lang.reflect.Type

class WordPressConverterFactory extends Converter.Factory {

    @Override
    Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        String modelType = type.toString()
        if (modelType == "java.util.List<gq.coderetort.wpclient.models.Taxonomy>")
            return new TaxonomiesResponseBodyConverter<>()
    }
}