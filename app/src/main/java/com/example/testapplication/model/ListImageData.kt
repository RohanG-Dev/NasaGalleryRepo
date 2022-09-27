package com.example.testapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListImageData(
    @SerializedName("data") var data:ArrayList<ImageData> = ArrayList()
) : Serializable
