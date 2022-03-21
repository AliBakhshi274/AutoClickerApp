package com.example.autoclickerapp.ui.home.scenarios

import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.autoclickerapp.databinding.ItemScenarioBinding
import com.example.autoclickerapp.model.Scenario
import kotlinx.android.synthetic.main.item_scenario.view.*

class ScenarioAdapter(private val onClickListener: OnClickListener, private val viewModel: ScenarioViewModel) :
    ListAdapter<Scenario,
            ScenarioAdapter.ScenarioViewHolder>(DiffCallback) {

    class ScenarioViewHolder(private var binding: ItemScenarioBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(scenario: Scenario) {
            binding.scenario = scenario
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Scenario>() {
        override fun areItemsTheSame(oldItem: Scenario, newItem: Scenario): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Scenario, newItem: Scenario): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ScenarioViewHolder {
        return ScenarioViewHolder(ItemScenarioBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ScenarioViewHolder, position: Int) {
        val scenarioModel = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(scenarioModel)
        }
        holder.itemView.imageButton_rename_scenario.setOnClickListener {
            showRenameScenarioDialog(it)
            val scenarioList: List<Scenario>? = viewModel.scenarioPropertyData.value
            viewModel.selectedItemId = scenarioList!![position].id
        }
        holder.bind(scenarioModel)
    }

    private fun showRenameScenarioDialog(it: View?) {
        viewModel.activeLoadingProgressBar()
        viewModel.renameScenarioClicked()
        val c = (it?.context as ContextWrapper).baseContext
        val fragmentManager = (c as FragmentActivity).supportFragmentManager
        DialogName(viewModel).show(fragmentManager, "Dialog Rename Scenario")
        viewModel.inactiveLoadingProgressBar()
    }

    class OnClickListener(val clickListener: (scenario: Scenario) -> Unit) {
        fun onClick(scenario: Scenario) = clickListener(scenario)
    }
}




























