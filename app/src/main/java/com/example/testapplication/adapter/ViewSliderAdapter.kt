package com.example.testapplication.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.testapplication.R
import com.example.testapplication.model.ImageData

/**
 * The Class is responsible for
 * - Implementation of RecyclerView for Image List
 * - Load the Image into the ImageView
 * - Display ImageTitle,Description and Date
 */
class ViewSliderAdapter(
    var context: Context,
    var listImgData: ArrayList<ImageData>,
    var positionImg: Int
) : RecyclerView.Adapter<ViewSliderAdapter.ItemHolder>() {


    /**
     * Create and Initialize View Holder object whenever RecyclerView needs.
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)

        return ItemHolder(itemHolder)
    }


    /**
     *  It takes ViewHolder object and binds the data to specified position.
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {


        var imageData: ImageData = listImgData[position]

        loadImage(holder, position, imageData)


    }


    /**
     * It enables Image Loading
     * @param holder
     * @param position
     */
    private fun loadImage(holder: ItemHolder, position: Int, imageData: ImageData) {
        Glide.with(context)
            .load(Uri.parse(imageData.url))
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(Glide.with(context).load(Uri.parse(imageData.url)))
            .transition(DrawableTransitionOptions.withCrossFade())
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onImageLoadFinished(holder, position)
                    return false
                }
            })
            .into(holder.imgNasa)
    }

    fun onImageLoadFinished(holder: ItemHolder, position: Int) {

        holder.imgTitle.text = listImgData[position].title
        holder.imgDesc.text = listImgData[position].explanation
        holder.imgDate.text = listImgData[position].date

    }

    override fun getItemCount(): Int {
        return listImgData.size
    }


    /**
     * This inner class is responsible for
     * - It describes an item view and metadata about its place within the RecyclerView.
     * - Initialize the View to display the data.
     */
    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgNasa: ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var imgTitle: TextView = itemView.findViewById<TextView>(R.id.imageTitle)
        var imgDesc: TextView = itemView.findViewById<TextView>(R.id.imageDesc)
        var imgDate: TextView = itemView.findViewById<TextView>(R.id.imageDate)

    }

}