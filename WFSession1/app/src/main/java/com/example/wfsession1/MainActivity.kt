package com.example.wfsession1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wapplestudy1.adapter
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = OkHttpClient.Builder().build()
        val moshi = Moshi.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val service = retrofit.create(ApiService::class.java)
        service.getTodos().enqueue(
            object : Callback<List<Todo>> {
                override fun onFailure(call: Call<List<Todo>>?, t: Throwable?) {
                    Log.e("SSS", t.toString())
                }

                override fun onResponse(call: Call<List<Todo>>?, response: Response<List<Todo>>?) {
                    Log.d("SSS", response?.body().toString())
                    val mAdapter = adapter(this@MainActivity, response?.body()!!)
                    my_recycler.adapter = mAdapter
                    val lm = LinearLayoutManager(this@MainActivity)
                    my_recycler.layoutManager = lm
                    my_recycler.setHasFixedSize(true)
                    my_recycler.addItemDecoration(DividerItemDecoration(this@MainActivity,1))
                }
            })
    }
}
