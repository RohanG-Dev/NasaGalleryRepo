package com.example.testapplication.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.testapplication.model.ImageData
import com.example.testapplication.R

/**
 * The Class is responsible for
 * - Implementation of RecyclerView for Image List
 * - Load the Image into the ImageView
 * - Pass position and Image selected for FullView Display
 *
 */
class ImageAdapter(var context: Context, var imgList: ArrayList<ImageData>) :
    RecyclerView.Adapter<ImageAdapter.ItemHolder>() {


    var onItemClick: ((ImageData, imgPosition: Int) -> Unit)? = null


    /**
     * Create and Initialize View Holder object whenever RecyclerView needs.
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list, parent, false)
        return ItemHolder(itemHolder)
    }


    /**
     *  It takes ViewHolder object and binds the data to specified position.
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var imageData: ImageData = imgList[position]
        Glide.with(context)
            .load(Uri.parse(imageData.url))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .fallback(R.drawable.ic_nasa_drawable)
            .error(Glide.with(context).load(imageData.url))
            .transition(DrawableTransitionOptions.withCrossFade(500))
            .into(holder.img_nasa)

        holder.img_txt.text = imageData.title


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(imageData, position)
        }

    }

    override fun getItemCount(): Int {
        return imgList.size
    }


    /**
     * This inner class is responsible for
     * - It describes an item view and metadata about its place within the RecyclerView.
     * - Initialize the View to display the data.
     */
    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_nasa: ImageView = itemView.findViewById<ImageView>(R.id.nasa_img)
        var img_txt: TextView = itemView.findViewById<TextView>(R.id.nasa_img_txt)

    }


}