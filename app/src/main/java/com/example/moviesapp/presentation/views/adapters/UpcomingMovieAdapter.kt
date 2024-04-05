package com.atiyakeithel.presentation.applayer.views.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.assets.IMAGE_BASE_URL
import com.example.moviesapp.dataLayer.models.upcoming.Result
import com.example.moviesapp.presentation.views.activities.MovieDetailsActivity
import com.makeramen.roundedimageview.RoundedImageView


class UpcomingMovieAdapter (private val context: Context, private val items: List<Result>?):RecyclerView.Adapter<UpcomingMovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.raw_upcoming, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.txtProductName.setText(item!!.title)
        holder.txtDate.setText(item!!.release_date)
        Glide.with(holder.itemView.context).load(IMAGE_BASE_URL.plus(item!!.poster_path)).error(R.drawable.ic_launcher_background).into(holder.img)
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, MovieDetailsActivity::class.java).putExtra("id",item.id))
        }
    }
    inner class ViewHolder(items: View): RecyclerView.ViewHolder(items){
        val txtProductName: TextView = items.findViewById(R.id.txtMovieName)
        val img: RoundedImageView =items.findViewById(R.id.img)
        val txtDate:TextView =items.findViewById(R.id.txtDate)
    }
}