package com.example.autoclickerapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.autoclickerapp.model.Scenario
import com.example.autoclickerapp.ui.home.scenarios.ScenarioAdapter


// listData is using in fragment_scenarios.
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Scenario>?){
    val adapter = recyclerView.adapter as ScenarioAdapter
    adapter.submitList(data)
}



































