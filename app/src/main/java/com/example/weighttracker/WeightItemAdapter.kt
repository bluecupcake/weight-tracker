package com.example.weighttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weighttracker.databinding.WeightItemBinding

class WeightItemAdapter(
    private val weightItems: List<WeightItem>,
    private val clickListener: WeightItemClickListener
) : RecyclerView.Adapter<WeightItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeightItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = WeightItemBinding.inflate(from, parent, false)
        return WeightItemViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: WeightItemViewHolder, position: Int) {
        holder.bindWeightItem(weightItems[position])
    }

    override fun getItemCount(): Int = weightItems.size
}