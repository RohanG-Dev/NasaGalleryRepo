package com.example.testapplication.repository

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.testapplication.viewmodel.ImageViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ImageRepoTest{

    private lateinit var imageRepo: ImageRepo


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp(){
        imageRepo = ImageRepo()
    }

    @Test
    fun testRepoListDataNotEmpty()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data.isEmpty() )
    }

    @Test
    fun testRepoListDataTitleNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data[0].title!!.isEmpty() )
    }

    @Test
    fun testRepoListDataDescNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data[0].explanation!!.isEmpty() )
    }

    @Test
    fun testRepoListDataUrlNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data[0].url!!.isEmpty() )
    }

    @Test
    fun testRepoListDataCopyrightNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data[0].copyright!!.isEmpty() )
    }

    @Test
    fun testRepoListDataMediaTypeNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data[0].mediaType!!.isEmpty() )
    }

    @Test
    fun testRepoListDataSVNotNull()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertFalse(res!!.data[0].serviceVersion!!.isEmpty() )
    }


    @Test
    fun testRepoListDataSize()
    {
        val context =  ApplicationProvider.getApplicationContext<Context>()
        val res = imageRepo.fetchJsonImageDataRepo(context)
        assertEquals(26,res!!.data.size)
    }

}