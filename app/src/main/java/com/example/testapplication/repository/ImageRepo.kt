package com.example.testapplication.repository

import android.content.Context
import com.example.testapplication.model.ListImageData
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

/**
 * This class is responsible for
 * - Fetch Image data list from json
 */

class ImageRepo {

    private var listdata: ListImageData? = null
    fun fetchJsonImageDataRepo(context: Context): ListImageData? {
        var json: String?
        try {
            val inputStream = context.assets.open("data.json")
            val size = inputStream.available()
            var buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        listdata = Gson().fromJson(json, ListImageData::class.java)

        return listdata
    }

}