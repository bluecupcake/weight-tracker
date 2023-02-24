package com.example.weighttracker

import android.app.Application

class WeightTrackerApp : Application() {
    private val database by lazy { WeightItemDatabase.getDatabase(this) }
    val repository by lazy { WeightItemRepository(database.weightItemDao() )}
}