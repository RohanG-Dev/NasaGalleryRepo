package com.example.testapplication.repository

//import org.powermock.core.classloader.annotations.PrepareForTest
//import org.powermock.modules.junit4.PowerMockRunner

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testapplication.view.MainActivity
import com.example.testapplication.model.ListImageData
import com.example.testapplication.viewmodel.ImageViewModel
import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.*


class ImageRepoTest
{

    private var  listdata : ListImageData? = null

    private lateinit var viewModel: ImageViewModel
    lateinit var imageRepo:ImageRepo
    lateinit var mainActivity: MainActivity

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Before
     fun setUp() {
        viewModel = ImageViewModel()
        imageRepo = ImageRepo()
        //mainActivity = MainActivity()
    }


    @Throws(IOException::class)
    fun readFileWithoutNewLineFromResources(fileName: String): String {
        var inputStream: InputStream? = null
        try {
            inputStream =
                javaClass.classLoader?.getResourceAsStream(fileName)
            val builder = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream))

            var str: String? = reader.readLine()
            while (str != null) {
                builder.append(str)
                str = reader.readLine()
            }
            return builder.toString()
        } finally {
            inputStream?.close()
        }
    }

    @Test
    fun verifyListData()
    {
        val gson = GsonBuilder().create()
        listdata = gson.fromJson(
            readFileWithoutNewLineFromResources("data.json"),
            ListImageData::class.java
        )
       assertFalse(listdata!!.data.isEmpty())
    }


}