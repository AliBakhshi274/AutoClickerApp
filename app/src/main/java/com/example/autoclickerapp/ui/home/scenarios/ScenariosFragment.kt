package com.example.autoclickerapp.ui.home.scenarios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autoclickerapp.databinding.FragmentScenariosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScenariosFragment : Fragment() {

    private val viewModel: ScenarioViewModel by viewModels()

    /* DataBinding contains the view for this Fragment (fragment_scenarios_list) */
    private lateinit var binding: FragmentScenariosBinding

    private lateinit var scenarioAdapter: ScenarioAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScenariosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setupRecyclerView()
//        getSavedScenarios()
        listeners()

    }

/*
    private fun getSavedScenarios() {
        viewModel.getAllScenarios().observe(this, Observer { scenarios ->
            scenarioAdapter.differ.submitList(scenarios)
        })
    }

    private fun setupRecyclerView() {
        scenarioAdapter = ScenarioAdapter()
        binding.rvLoadableList.apply {
            adapter = scenarioAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
*/

    private fun listeners() {
        binding.floatingBtnAdd.setOnClickListener {
            DialogName(viewModel).show(parentFragmentManager, "DialogName")
        }
    }

}





























