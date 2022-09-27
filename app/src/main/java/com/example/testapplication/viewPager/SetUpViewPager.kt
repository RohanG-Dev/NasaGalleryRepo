package com.example.testapplication.viewPager

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.testapplication.adapter.ViewSliderAdapter
import com.example.testapplication.databinding.ActivityDetailsBinding
import com.example.testapplication.model.ImageData

/**
 * This class is Responsible for
 * - Setting up viewPager with current Image Item
 */
class SetUpViewPager {

    var position: Int = 0
    lateinit var listadata: ArrayList<ImageData>

    private var viewPager2: ViewPager2? = null
    private var viewSliderAdapter: ViewSliderAdapter? = null

    fun setUpViewPagerSlide(
        applicationContext: Context,
        listadata: ArrayList<ImageData>,
        position: Int,
        bindingActivityDetails: ActivityDetailsBinding
    ) {

        viewPager2 = bindingActivityDetails.viewImagePager
        viewSliderAdapter = ViewSliderAdapter(applicationContext, listadata, position)
        viewSliderAdapter!!.positionImg = position
        viewPager2?.adapter = viewSliderAdapter
        viewPager2!!.currentItem = position
        setupViewPagerScroll(viewPager2!!)

    }

    /**
     * Setting Up Smooth Image Scrolling
     * @param viewPager2
     */
    private fun setupViewPagerScroll(viewPager2: ViewPager2) {
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager2.setPageTransformer(compositePageTransformer)
    }
}