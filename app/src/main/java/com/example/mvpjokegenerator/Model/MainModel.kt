package com.example.mvpjokegenerator.Model

import com.example.mvpjokegenerator.Interface.Model
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainModel : Model {

    val URL = "https://api.icndb.com/jokes/random"
    var okHttpClient: OkHttpClient = OkHttpClient()
    var txt : String = ""

    override fun getJoke() {
        val request: Request = Request.Builder().url(URL).build()
        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {
            }

            override fun onResponse(call: Call?, response: Response?) {
                val json = response?.body()?.string()
                // we get the joke from the Web Service
                txt = (JSONObject(json).getJSONObject("value").get("joke")).toString()
            }
        })
    }

    override fun setJoke() = txt


}
