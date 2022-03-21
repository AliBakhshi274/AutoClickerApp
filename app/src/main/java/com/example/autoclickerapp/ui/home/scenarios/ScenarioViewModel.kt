package com.example.autoclickerapp.ui.home.scenarios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autoclickerapp.model.Scenario
import com.example.autoclickerapp.repositories.ScenarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ScenarioViewModel @Inject constructor(
    private val scenarioRepository: ScenarioRepository
) : ViewModel() {

    private val _scenarioPropertyData = MutableLiveData<List<Scenario>>()
    val scenarioPropertyData: LiveData<List<Scenario>>
        get() = _scenarioPropertyData

    private val _loadingProgressBar = MutableLiveData<Boolean>()
    val loadingProgressBar: LiveData<Boolean>
        get() = _loadingProgressBar

    /*
    * when you are clicked on ...
    *   ... add new scenario floatingBtn -> TRUE
    *   ... edit scenario name -> FALSE
    * */
    private val _isClickedAddNewScenarioFb = MutableLiveData<Boolean>()
    val isClickedAddNewScenarioFb: LiveData<Boolean>
        get() = _isClickedAddNewScenarioFb

    var selectedItemId: Long = -1L

    init {
        getAllScenarios()
        activeLoadingProgressBar()
        renameScenarioClicked()
    }

    fun saveScenario(scenario: Scenario) = viewModelScope.launch {
        Timber.i("Timber -> ${scenario.id} , ${scenario.name}")
        val insertedNumber = scenarioRepository.insert(scenario)
        _scenarioPropertyData.value = scenarioRepository.getAllScenarios()
        inactiveLoadingProgressBar()
        Timber.i("Timber -> Inserted item number: $insertedNumber")
    }

    fun renameScenario(renameTxt: String) = viewModelScope.launch {
        scenarioRepository.rename(renameTxt, selectedItemId)
        _scenarioPropertyData.value = scenarioRepository.getAllScenarios()
        inactiveLoadingProgressBar()
        Timber.i("Timber -> Rename item's name")
    }

    private fun getAllScenarios() = viewModelScope.launch {
        activeLoadingProgressBar()
        _scenarioPropertyData.value = scenarioRepository.getAllScenarios()
        inactiveLoadingProgressBar()
        Timber.i("Timber -> getItems in DB: ${scenarioPropertyData.value}")
    }


    fun activeLoadingProgressBar() {
        _loadingProgressBar.value = true
    }
    fun inactiveLoadingProgressBar() {
        _loadingProgressBar.value = false
    }

    fun addNewScenarioFbClicked() {
        _isClickedAddNewScenarioFb.value = true
    }
    fun renameScenarioClicked() {
        _isClickedAddNewScenarioFb.value = false
    }

}





































