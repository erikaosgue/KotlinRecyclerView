package com.erikaosgue.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.erikaosgue.kotlinrecyclerview.data.MyClassAdapter
import com.erikaosgue.kotlinrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: MyClassAdapter

    lateinit var  activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // Get the recyclerView from the activity_main
        //var recyclerView = activityMainBinding.recyclerViewId

        //Add an instance of LinearLayout
        //recyclerView.layoutManager = LinearLayoutManager(this)

        // Add the data into the DataSource
//        val listOfData = DataSource()

        //Create the adapter
        //val blogAdapter = MyClassAdapter()


        //Pass the adapter into the recycleView
//      recyclerView.adapter = adapter
        
        initRecyclerView()
        addDateSet()

    }
    private fun addDateSet(){
         val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        val recyclerView = activityMainBinding.recyclerViewId
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //Create the adapter
            blogAdapter = MyClassAdapter()
            adapter = blogAdapter

        }

    }


}