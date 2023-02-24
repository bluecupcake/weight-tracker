package com.example.weighttracker

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WeightItemRepository(
    private val weightItemDao: WeightItemDao
) {
    val allWeightItems: Flow<List<WeightItem>> = weightItemDao.allWeightItems()

    @WorkerThread
    suspend fun insertWeightItem(weightItem: WeightItem) {
        weightItemDao.insertWeightItem(weightItem)
    }

    @WorkerThread
    suspend fun updateWeightItem(weightItem: WeightItem) {
        weightItemDao.updateWeightItem(weightItem)
    }
}