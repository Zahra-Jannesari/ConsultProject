package com.zarisa.sampleproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.zarisa.sampleproject.databinding.ActivityDoctorBinding


class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        primaryInit()
    }

    private fun primaryInit() {
        val firstDoctor = Hospital.doctorList[1]
        binding.textViewName.text = firstDoctor.name
        binding.textViewField.text = firstDoctor.field
        binding.textViewConnection.text = firstDoctor.connection.toString()

        var cons1 = Hospital.consultancyList[0]
        binding.textViewConsultancy10.text = " مشاوره تلفنی " + cons1.time + " دقیقه ای "
        binding.textViewConsultancy10.text = " مشاوره تلفنی " + cons1.time + " دقیقه ای "
        binding.textViewConsultancyPrice10.text = cons1.price.toString() +  " تومان "

        binding.llConsultancy10.setOnClickListener {
            Toast.makeText(this , "cunsultancy is chosen" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ConsultActivity::class.java)
            intent.putExtra("id" , firstDoctor.id)
            startActivity(intent)

            // startForResult.launch(intent)
        }
        binding.buttonSendMassege.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:09121234567")
            startActivity(callIntent)
        }
    }
}