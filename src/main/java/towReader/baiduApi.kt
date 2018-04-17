package towReader

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by i61611 on 2018/4/17.
 */
fun main(args: Array<String>) {
    baiduApi().getToken()
}
fun String.request(): Request.Builder = Request.Builder().url(this)
fun Request.Builder.call(): Response = OkHttpClient().newCall(this.build()).execute()
class baiduApi{
    val apiKey = "7B3mGjNhEG6uOVL317757RkV"
    val secretKye = "92CLDex0hP44OG9cws8GFr7Svdg7UoOZ"

    fun getToken(){
        val getTokenUrl = "https://aip.baidubce.com/oauth/2.0/token?" +
                "grant_type=client_credentials&client_id=${apiKey}" +
                "&client_secret=${secretKye}"
        var result = getTokenUrl.request().get().call().body()?.string()
        println(result)
    }
}