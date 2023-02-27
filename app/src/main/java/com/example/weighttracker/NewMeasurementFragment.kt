package com.example.weighttracker

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.weighttracker.databinding.FragmentNewMeasurementBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.LocalDate

class NewMeasurementFragment(var weightItem: WeightItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewMeasurementBinding
    private lateinit var weightViewModel: WeightViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (weightItem != null) {
            binding.title.text = "Pomiar z dnia " + weightItem!!.dateString

            val editable = Editable.Factory.getInstance()
            with(binding) {
                weight.text = editable.newEditable(weightItem!!.weight.toString())
                chest.text = editable.newEditable(weightItem!!.chest.toString())
                weist.text = editable.newEditable(weightItem!!.weist.toString())
                belly.text = editable.newEditable(weightItem!!.belly.toString())
                hips.text = editable.newEditable(weightItem!!.hips.toString())
                thigh.text = editable.newEditable(weightItem!!.thigh.toString())
                arm.text = editable.newEditable(weightItem!!.arm.toString())
            }

            with (binding.delete) {
                visibility  = View.VISIBLE
                setOnClickListener {
                    deleteAction()
                }
            }
        } else {
            binding.title.text = "Nowy pomiar"
            binding.delete.visibility  = View.GONE
        }

        weightViewModel = ViewModelProvider(activity).get(WeightViewModel::class.java)
        binding.save.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMeasurementBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun saveAction() {
        val date = LocalDate.now().toString()
        val weight = binding.weight.text.toString()
        val chest = binding.chest.text.toString()
        val weist = binding.weist.text.toString()
        val belly = binding.belly.text.toString()
        val hips = binding.hips.text.toString()
        val thigh = binding.thigh.text.toString()
        val arm = binding.arm.text.toString()

        if (weightItem == null) {
            val newWeight = WeightItem(
                date,
                weight,
                chest,
                weist,
                belly,
                hips,
                thigh,
                arm
            )

            weightViewModel.addWeightItem(newWeight)
        } else {
            weightItem!!.dateString = date
            weightItem!!.weight = weight
            weightItem!!.weist = weist
            weightItem!!.chest = chest
            weightItem!!.belly = belly
            weightItem!!.hips = hips
            weightItem!!.thigh = thigh
            weightItem!!.arm = arm

            weightViewModel.updateWeightItem(weightItem!!)
        }

        clear()
        dismiss()
    }

    private fun deleteAction() {
        weightViewModel.deleteWeightItem(weightItem!!)
        clear()
        dismiss()
    }

    private fun clear() {
        binding.weight.setText("")
        binding.weist.setText("")
        binding.chest.setText("")
        binding.belly.setText("")
        binding.hips.setText("")
        binding.thigh.setText("")
        binding.arm.setText("")
    }
}