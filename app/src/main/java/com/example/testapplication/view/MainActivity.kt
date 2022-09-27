package com.example.testapplication.view


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.model.ListImageData
import com.example.testapplication.adapter.ImageAdapter
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.model.ImageData
import com.example.testapplication.recyclerview.SetUpRecyclerView
import com.example.testapplication.viewmodel.ImageViewModel

/**
 * This Class is responsible for
 * -Initializing ViewModel
 * -Setting Up RecyclerView
 * - invoke details activity with selected image data
 */
class MainActivity : AppCompatActivity() {

    lateinit var bindingActivityMain: ActivityMainBinding

    lateinit var txtView: TextView

    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var imageAdapter: ImageAdapter? = null
    lateinit var Listdata: ListImageData

    var viewModel: ImageViewModel? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bindingActivityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivityMain.root)

        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        Listdata = viewModel!!.fetchJsonImageDataVM(this)!!



        imageAdapter = SetUpRecyclerView().setupRecyclerView(
            Listdata.data.reversed() as ArrayList<ImageData>,
            bindingActivityMain,
            applicationContext
        )

        selectedImageItemFullView(imageAdapter)


    }

    private fun selectedImageItemFullView(imageAdapter: ImageAdapter?) {

        imageAdapter!!.onItemClick = { imageData: ImageData, position: Int ->

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("ListData", Listdata.data.reversed() as ArrayList<ImageData>)
            startActivity(intent)

        }
    }


}