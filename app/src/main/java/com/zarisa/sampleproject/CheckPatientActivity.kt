package com.zarisa.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zarisa.sampleproject.databinding.ActivityCheckPatientBinding

class CheckPatientActivity : AppCompatActivity() {
    lateinit var binding : ActivityCheckPatientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.buttonOk.setOnClickListener {
            val isOk = binding.checkBox1.isChecked||binding.checkBox2.isChecked||binding.checkBox3.isChecked
            returnResult(isOk)
        }
    }
    private fun returnResult(isOk : Boolean){
        val resultIntent = Intent()
        resultIntent.putExtra("isOk" , isOk)
        setResult(RESULT_OK, resultIntent)
        finish()
    }

}