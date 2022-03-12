package com.zarisa.sampleproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.zarisa.sampleproject.databinding.ActivityChoseDoctorBinding

class ChoseDoctorActivity : AppCompatActivity() {
    val viewModel1: ViewModel1 by viewModels()
    private lateinit var binding: ActivityChoseDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChoseDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        setInformation()
        binding.buttonSee1.setOnClickListener {  }
        binding.buttonSee2.setOnClickListener {  }
        binding.buttonSee3.setOnClickListener {  }
        binding.buttonSee4.setOnClickListener {  }
    }
    private fun setInformation(){
        binding.textViewName1.text=viewModel1.getDoctorName(0)
        binding.textViewName2.text=viewModel1.getDoctorName(1)
        binding.textViewName3.text=viewModel1.getDoctorName(2)
        binding.textViewName4.text=viewModel1.getDoctorName(3)

        binding.textViewField1.text=viewModel1.getDoctorExpertise(0)
        binding.textViewField2.text=viewModel1.getDoctorExpertise(1)
        binding.textViewField3.text=viewModel1.getDoctorExpertise(2)
        binding.textViewField4.text=viewModel1.getDoctorExpertise(3)
    }
}