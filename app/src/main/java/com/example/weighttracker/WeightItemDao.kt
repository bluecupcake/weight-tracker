package com.example.weighttracker

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WeightItemDao {
    @Query("SELECT * FROM weight_item_table ORDER BY id ASC")
    fun allWeightItems(): Flow<List<WeightItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeightItem(weightItem: WeightItem)

    @Update
    suspend fun updateWeightItem(weightItem: WeightItem)

    @Delete
    suspend fun deleteWeightItem(weightItem: WeightItem)
}