# WordPress REST client
WordPress REST client library for Android simplifies using common WordPress API requests and parses results to POJO using Gson and Retrofit.

WordPress REST API reference: https://developer.wordpress.org/rest-api/reference/

Usage
----
Below is sample usage showing how to get data with and without specifing query params, as well as example of getting single item. 
~~~
// first param is OkHttpClient, pass null if You want to use default
WordPressRestClient client = new WordPressRestClient(null, "http://demo.wp-api.org/wp-json/wp/v2/");

// getting (default 10) categories, pass null if query params do not need to be specified
List<Category> categories = client.getCategories(null);

// getting posts as specified in the query params
Query query = new Query.QueryBuilder()
  .perPage(8)
  .before("2017-03-01T12:00:00")
  .orderBy("id")
  .order("asc")
  .build();
List<Post> posts = client.getPosts(query);

// getting page with id 1
Page page = client.getPage(1);
~~~

Download
----
The library is not yet published on jcenter, it is available in custom maven repository, which currently needs to be added:
~~~
repositories {
    maven {
        url  "http://dl.bintray.com/darekdeo/wordpressrestclient" 
    }
}
dependencies {
    ...
    compile ('gq.coderetort.wpclient:wpclient:0.1.11') {
        exclude group: 'org.codehaus.groovy', module: 'groovy-ant'
    }
}
~~~

ProGuard
----
Because library relay on Groovy dependencies it is recommended to enable ProGuard, otherwise library may take up to 40,000 methods.
With below ProGuard rules it should take around 14,000 methods, make sure to change #application "your.package.name.**" to your appliaction package.
~~~
# common
-keepattributes Signature
-keepattributes Exceptions
-keepattributes Annotation

# retrofit
-keep class retrofit2.** {*;}
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontwarn retrofit2.**

# okhttp
-keep class okhttp3.** {*;}
-keep interface okhttp3.* {*;}
-keepclassmembers class okhttp3.* {*;}
-dontwarn okhttp3.**

# okio
-keep class sun.misc.Unsafe {*;}
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

# groovy
-dontobfuscate
-keep class org.codehaus.groovy.vmplugin.**
-keep class org.codehaus.groovy.runtime.dgm*
-keepclassmembers class org.codehaus.groovy.runtime.dgm* {*;}
-keepclassmembers class ** implements org.codehaus.groovy.runtime.GeneratedClosure {*;}
-keepclassmembers class org.codehaus.groovy.reflection.GroovyClassValue* {*;}
-dontwarn org.codehaus.groovy.**
-dontwarn groovy**

# wordpressrest
-keep class gq.coderetort.wpclient.**
-keepclassmembers class gq.coderetort.wpclient.** {*;}

# application
-keepclassmembers class your.package.name.** {*;}
~~~
Sample ProGuard rules can also be found in sample project: https://github.com/darekdeo/wordpressrestclient/blob/master/wpsample/proguard-rules.pro

That is all if You want to use library in Android Java/Kotlin project, for using it in Groovy project please read: https://github.com/groovy/groovy-android-gradle-plugin

Copyright and Licensing
----

Copyright 2017, Dariusz Deoniziak.

This library is distributed under an Apache 2.0 License.
