package com.erikaosgue.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erikaosgue.kotlinrecyclerview.data.MyClassAdapter
import com.erikaosgue.kotlinrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // Get the recyclerView from the activity_main
        val recyclerView = activityMainBinding.recyclerViewId

        //Add an instance of LinearLayout
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add the data into the DataSource
        val listOfData = DataSource()


        //Create the adapter
        val adapter = MyClassAdapter(listOfData)

        //Pass the adapter into the recycleView
        recyclerView.adapter = adapter

        private fun initRecyclerView(){
            recyclerView.apply {

            }

        }        }


}