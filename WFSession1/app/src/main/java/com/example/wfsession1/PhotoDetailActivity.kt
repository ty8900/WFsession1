package com.example.wfsession1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_photo_detail.*

class PhotoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)
        val getphoto = intent.getParcelableExtra<Todo>("photo")
        val photourl = getphoto.url
        Glide.with(this)
            .load(photourl)
            .into(photo)
    }
}
