package com.example.testapplication.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.testapplication.model.ListImageData
import com.example.testapplication.repository.ImageRepo

/**
 *This class is responsible for
 * - Invoke method to fetch List Image data from json via Repo object
 */
class ImageViewModel() : ViewModel() {

    var imageRepo: ImageRepo? = null

    init {
        imageRepo = ImageRepo()

    }

    fun fetchJsonImageDataVM(context: Context): ListImageData? {
        return imageRepo?.fetchJsonImageDataRepo(context)
    }
}