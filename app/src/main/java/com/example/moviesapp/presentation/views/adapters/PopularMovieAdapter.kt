package com.atiyakeithel.presentation.applayer.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.dataLayer.models.Result
import com.makeramen.roundedimageview.RoundedImageView


class PopularMovieAdapter (private val context: Context, private val items: List<Result>?):RecyclerView.Adapter<PopularMovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.raw_popular, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.txtProductName.setText(item!!.title)
//        Glide.with(holder.itemView.context).load(item.category_img).error(R.drawable.ic_categories).into(holder.img)
    }

    inner class ViewHolder(items: View): RecyclerView.ViewHolder(items){
        val txtProductName: TextView = items.findViewById(R.id.txtProductName)
        val img: RoundedImageView =items.findViewById(R.id.img)

    }
}