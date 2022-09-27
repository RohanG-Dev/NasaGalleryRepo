package com.example.testapplication.recyclerview

import android.content.Context
import com.example.testapplication.model.ImageData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.adapter.ImageAdapter
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.view.DetailsActivity

/**
 * This class is responsible for
 * - Initialization of adapter and gridlayout
 * -
 */

class SetUpRecyclerView() {

    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var imageAdapter: ImageAdapter? = null

    fun setupRecyclerView(
        Imgdata: ArrayList<ImageData>,
        bindingActivityMain: ActivityMainBinding,
        applicationContext: Context
    ): ImageAdapter? {

        recyclerView = bindingActivityMain.imgRecyclerview


        gridLayoutManager = GridLayoutManager(
            applicationContext, 2,
            LinearLayoutManager.VERTICAL, false
        )

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        imageAdapter = ImageAdapter(applicationContext, Imgdata)
        recyclerView?.adapter = imageAdapter

        return imageAdapter


    }
}


