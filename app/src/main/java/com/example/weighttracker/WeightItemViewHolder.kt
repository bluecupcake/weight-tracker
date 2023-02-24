package com.example.weighttracker

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.weighttracker.databinding.FragmentNewMeasurementBinding
import com.example.weighttracker.databinding.WeightItemBinding

class WeightItemViewHolder(
    private val context: Context,
    private val binding: WeightItemBinding,
    private val clickListener: WeightItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindWeightItem(weightItem: WeightItem) {
        binding.date.text = weightItem.dateString
        binding.weightInfo.setText("Waga: " + weightItem.weight + "kg")

        binding.weightCellContainer.setOnClickListener {
            clickListener.editWeightItem(weightItem)
        }
    }
}