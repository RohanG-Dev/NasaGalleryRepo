package com.example.testapplication.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.testapplication.R
import com.example.testapplication.adapter.ViewSliderAdapter
import com.example.testapplication.databinding.ActivityDetailsBinding
import com.example.testapplication.model.ImageData
import com.example.testapplication.viewPager.SetUpViewPager

/**
 * This class is Responsible for
 * - Invoking  ViewPager class with Image data
 */

class DetailsActivity : AppCompatActivity() {

    var position: Int = 0
    lateinit var listadata: ArrayList<ImageData>

    private var viewPager2: ViewPager2? = null
    private var viewSliderAdapter: ViewSliderAdapter? = null

    lateinit var imageView: ImageView

    lateinit var bindingActivityDetails: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingActivityDetails = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(bindingActivityDetails.root)


        position = intent.getIntExtra("position", 0)
        listadata = intent.getSerializableExtra("ListData") as ArrayList<ImageData>


        SetUpViewPager().setUpViewPagerSlide(
            applicationContext,
            listadata,
            position,
            bindingActivityDetails
        )


    }


}