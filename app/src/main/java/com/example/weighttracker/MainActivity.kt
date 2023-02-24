package com.example.weighttracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weighttracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), WeightItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val weightViewModel: WeightViewModel by viewModels { WeightViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newMeasurement.setOnClickListener {
            NewMeasurementFragment(null).show(supportFragmentManager, "new measurement lol xd")
        }

        setRecyclerView()
    }

    private fun setRecyclerView() {
        val mainActivity = this
        weightViewModel.weightsItems.observe(this) {
            binding.measurementList.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = WeightItemAdapter(it, mainActivity)
            }
        }
    }

    override fun editWeightItem(weightItem: WeightItem) {
        NewMeasurementFragment(weightItem).show(supportFragmentManager, "new measurement")
    }
}