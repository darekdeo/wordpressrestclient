package gq.coderetort.wpclient.rest

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class WordPressNetworkInterceptor implements Interceptor {

    @Override
    Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request()
        def string = request.url().toString()
        string = string.replace("%26", "&")
        string = string.replace("%3D", "=")

        Request newRequest = request
                .newBuilder()
                .url(string)
                .build()

        return chain.proceed(newRequest)
    }
}