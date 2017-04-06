package gq.coderetort.wordpressrest.rest;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class WordPressRestClient {

    WordPressService apiService;

    public WordPressRestClient(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        apiService = retrofit.create(WordPressService.class);
    }

    public WordPressService getWordPressService() {
        return apiService;
    }
}
