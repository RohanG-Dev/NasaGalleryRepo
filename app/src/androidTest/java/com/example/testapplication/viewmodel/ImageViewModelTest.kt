package com.example.testapplication.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ImageViewModelTest{

    private lateinit var imageViewModel : ImageViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        imageViewModel = ImageViewModel()

    }

    @Test
    fun testListDataNotEmpty()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data.isEmpty() )
    }

    @Test
    fun testListDataTitleNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data[0].title!!.isEmpty() )
    }

    @Test
    fun testListDataDescNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data[0].explanation!!.isEmpty() )
    }

    @Test
    fun testListDataUrlNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data[0].url!!.isEmpty() )
    }

    @Test
    fun testListDataCopyrightNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data[0].copyright!!.isEmpty() )
    }

    @Test
    fun testListDataMediaTypeNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data[0].mediaType!!.isEmpty() )
    }

    @Test
    fun testListDataSVNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertFalse(res!!.data[0].serviceVersion!!.isEmpty() )
    }


    @Test
    fun testListDataSize()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageViewModel.fetchJsonImageDataVM(context)
        assertEquals(26,res!!.data.size)
    }
}