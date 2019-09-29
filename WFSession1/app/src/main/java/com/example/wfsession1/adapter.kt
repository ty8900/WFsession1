package com.example.wapplestudy1

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wfsession1.PhotoDetailActivity
import com.example.wfsession1.R
import com.example.wfsession1.Todo
import kotlinx.android.parcel.Parcelize
import retrofit2.Call
import retrofit2.Response

class adapter(val context: Context, val list: List<Todo>) : RecyclerView.Adapter<adapter.Holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler,parent,false)
        val holder: Holder = Holder(view)
        holder.itemView.setOnClickListener{
            val intent = Intent(context,PhotoDetailActivity::class.java)
            val position = holder.adapterPosition
            intent.putExtra("photo",list[position])
            context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = "title : "+ list[position].title
        Glide.with(context)
            .load(list[position].thumbnailUrl)
            .into(holder.thumbnailUrl)
    }


    inner class Holder(v: View) : RecyclerView.ViewHolder(v){
        val title = v.findViewById<TextView>(R.id.title)
        val thumbnailUrl = v.findViewById<ImageView>(R.id.thumbnailUrl)
    }
}