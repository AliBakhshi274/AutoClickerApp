package com.example.autoclickerapp.ui.home.scenarios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.autoclickerapp.R
import com.example.autoclickerapp.db.model.Scenario

class ScenarioAdapter{

}
/*
class ScenarioAdapter : RecyclerView.Adapter<ScenarioAdapter.ScenarioViewHolder>() {

    private lateinit var scenarioList: MutableList<Scenario>

    // Adapter ClickListener
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    // Differ
    private val differCallback = object : DiffUtil.ItemCallback<Scenario>() {
        override fun areItemsTheSame(oldItem: Scenario, newItem: Scenario): Boolean {
            return oldItem.name === newItem.name
        }

        override fun areContentsTheSame(oldItem: Scenario, newItem: Scenario): Boolean {
            return oldItem == newItem
        }
    }
    var differ = AsyncListDiffer(this, differCallback)


    inner class ScenarioViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        var scenarioName: TextView = itemView.findViewById(R.id.event_name)
//        var pointX: TextView = itemView.findViewById(R.id.event_detail)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScenarioViewHolder {
        return ScenarioViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_scenario,
                parent,
                false
            ), mListener
        )
    }

    override fun onBindViewHolder(holder: ScenarioViewHolder, position: Int) {
        scenarioList = differ.currentList
        val scenario = scenarioList[position]
        holder.itemView.apply {
            holder.scenarioName.text = scenario.name
//            holder.pointX.text = scenario.pointX.toString()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}
*/




























