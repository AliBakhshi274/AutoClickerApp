package com.example.autoclickerapp.ui.home.scenarios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.autoclickerapp.databinding.FragmentScenariosBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ScenariosFragment : Fragment() {

    private val viewModel: ScenarioViewModel by viewModels()

    /* DataBinding contains the view for this Fragment (fragment_scenarios_list) */
    private lateinit var binding: FragmentScenariosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScenariosBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewClickListener()
        floatingBtnClickListener()
    }

    private fun recyclerViewClickListener() {
        binding.rvLoadableList.adapter = ScenarioAdapter(ScenarioAdapter.OnClickListener {
            Timber.e("Timber -> Clicked on recyclerView's item!")
        } , viewModel)
    }

    private fun floatingBtnClickListener() {
        binding.floatingBtnAdd.setOnClickListener {
            viewModel.addNewScenarioFbClicked()
            DialogName(viewModel).show(parentFragmentManager, "DialogName")
        }
    }

}





























