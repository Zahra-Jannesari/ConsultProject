package com.zarisa.sampleproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.zarisa.sampleproject.databinding.ActivityDoctorBinding


class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    val viewModel2: ViewModel2 by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        primaryInit()
    }

    @SuppressLint("SetTextI18n")
    private fun primaryInit() {
//        val firstDoctor = Hospital.doctorList[1]
//        binding.textViewName.text = firstDoctor.name
//        binding.textViewField.text = firstDoctor.field
//        binding.textViewConnection.text = firstDoctor.connection.toString()
//
//        binding.llConsultancy10.setOnClickListener {
//            Toast.makeText(this , "cunsultancy is chosen" , Toast.LENGTH_SHORT).show()
//            val intent = Intent(this , ConsultActivity::class.java)
//            intent.putExtra("id" , firstDoctor.id)
//            startActivity(intent)
//
//            // startForResult.launch(intent)
//        }
//
//    }

        var doctorNumber=intent.getIntExtra("chosenButton",1)
        binding.textViewName.text=viewModel2.getDoctorName(doctorNumber-1)
        binding.textViewField.text=viewModel2.getDoctorExpertise(doctorNumber-1)
        binding.textViewConnection.text=viewModel2.getConectionState(doctorNumber-1).toString()
        binding.textViewConsultancy10.text=" مشاوره تلفنی " + viewModel2.getConsultancyTime(0) + " دقیقه ای "
        binding.textViewConsultancy30.text=" مشاوره تلفنی " + viewModel2.getConsultancyTime(1) + " دقیقه ای "
        binding.textViewConsultancy60.text=" مشاوره تلفنی " + viewModel2.getConsultancyTime(2) + " دقیقه ای "
        binding.textViewConsultancyPrice10.text= viewModel2.getConsultancyPrise(0).toString() +  " تومان "
        binding.textViewConsultancyPrice30.text= viewModel2.getConsultancyPrise(1).toString() +  " تومان "
        binding.textViewConsultancyPrice60.text= viewModel2.getConsultancyPrise(2).toString() +  " تومان "
        binding.buttonSendMassege.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:09121234567")
            startActivity(callIntent)
        }
    }
}