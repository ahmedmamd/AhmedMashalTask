package com.example.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.R
import com.example.task.adapter.PopularStareAdapter
import com.example.task.databinding.ActivityMainBinding
import com.example.task.pojo.popularStare.Items
import com.example.task.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var itemList = ArrayList<Items>()
    lateinit var popularStarAdapter:PopularStareAdapter
    lateinit var homeViewModel:HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setUpUi()
        setUpObserver()
    }

    private fun setUpObserver() {
        //observe on Popular Star
        homeViewModel!!.popularLiveData()!!.observe(this, Observer<ArrayList<Items>?> { response ->
            itemList.clear()
            itemList.addAll(response)
            popularStarAdapter.notifyDataSetChanged()
        })
    }

    private fun setUpUi() {
        homeViewModel.getPopularStar(this)
        // attach adapter and Recyclerview
        popularStarAdapter = PopularStareAdapter(itemList, this ,10)
        binding.psRec.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.psRec.adapter = popularStarAdapter
        // add spinner
        val spinnerTopItems: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, listOf(
                "top 10",
                "top 50",
                "top 100",
            )
        )
        binding.topStar.setAdapter(spinnerTopItems)
        // choice from spinner
        binding.topStar.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                if (parent?.getItemAtPosition(position).toString().equals("top 10")){
                    homeViewModel.getPopularStar(this@MainActivity)
                    popularStarAdapter = PopularStareAdapter(itemList, this@MainActivity ,10)
                    binding.psRec.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.psRec.adapter = popularStarAdapter
                }else if (parent?.getItemAtPosition(position).toString().equals("top 50")){
                        homeViewModel.getPopularStar(this@MainActivity)
                        popularStarAdapter = PopularStareAdapter(itemList, this@MainActivity ,50)
                        binding.psRec.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        binding.psRec.adapter = popularStarAdapter
                }else  if (parent?.getItemAtPosition(position).toString().equals("top 100")){
                    homeViewModel.getPopularStar(this@MainActivity)
                    popularStarAdapter = PopularStareAdapter(itemList, this@MainActivity ,100)
                    binding.psRec.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.psRec.adapter = popularStarAdapter
                }
            }
        }
    }
}