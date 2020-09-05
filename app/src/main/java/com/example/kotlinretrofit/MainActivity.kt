package com.example.kotlinretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            var apiClient = ApiClient.getApiClient()
            events(apiClient)
        } catch (e: Exception) {
            e.message
        }
    }

    private fun events(apiClient: ApiService) {
        btnGetPosts.setOnClickListener {
            apiClient.getPostList().enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    for (i in 0 until response.body()!!.size) {
                        Log.d("onResponse", "TEST")
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.e("getPostList()", "onFailure")
                }
            })
        }
    }
}