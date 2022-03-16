package com.example.autoclickerapp.ui.home.scenarios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autoclickerapp.db.model.Scenario
import com.example.autoclickerapp.repositories.ScenarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ScenarioViewModel @Inject constructor(
    private val scenarioRepository: ScenarioRepository
) : ViewModel() {

    fun saveScenario(scenario: Scenario) = viewModelScope.launch {
        val num = scenarioRepository.insert(scenario)
        Timber.e("Timber: saveScenario: $num")
    }

    fun getAllScenarios() = scenarioRepository.getAllScenarios()

}





































