package com.example.weighttracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Entity(tableName = "weight_item_table")
class WeightItem (
    @ColumnInfo(name = "date") var dateString: String,
    @ColumnInfo(name = "weight") var weight: String,
    @ColumnInfo(name = "chest") var chest: String?,
    @ColumnInfo(name = "weist") var weist: String?,
    @ColumnInfo(name = "belly") var belly: String?,
    @ColumnInfo(name = "hips") var hips: String?,
    @ColumnInfo(name = "thigh") var thigh: String?,
    @ColumnInfo(name = "arm") var arm: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    ) {
    //fun getDate(): LocalDate = LocalDate.parse(LocalDate.now().toString(), dateFormatter)

    companion object {
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE
    }
}