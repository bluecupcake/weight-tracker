package com.example.weighttracker

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

class WeightViewModel(
    private val repository: WeightItemRepository
) : ViewModel() {
    var weightsItems: LiveData<List<WeightItem>> = repository.allWeightItems.asLiveData()

    fun addWeightItem(newWeightItem: WeightItem) = viewModelScope.launch {
        repository.insertWeightItem(newWeightItem)
    }

    fun updateWeightItem(weightItem: WeightItem) = viewModelScope.launch {
        repository.updateWeightItem(weightItem)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repo = (this[APPLICATION_KEY] as WeightTrackerApp).repository
                WeightViewModel(repo)
            }
        }
    }
}