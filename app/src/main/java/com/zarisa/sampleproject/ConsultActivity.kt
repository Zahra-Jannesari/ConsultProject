package com.zarisa.sampleproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.zarisa.sampleproject.databinding.ActivityConsultBinding

class ConsultActivity : AppCompatActivity() {
    lateinit var binding : ActivityConsultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        if(savedInstanceState!= null){
//            var myText = savedInstanceState.getString("textView1Text")
//            binding.textView.text = myText
//        }
        initViews()
    }
//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putString("textView1Text" , binding.textView.text.toString())
//        super.onSaveInstanceState(outState)
//    }

    private fun initViews() {
        var id = intent.getIntExtra("id" , -1)
        if (id == -1){
            binding.textViewDoctorCalls.text = "ٔدکتر شما پیدا نشد"
        }else {
            var myDoctor = Hospital.getDoctor(id)
            if(myDoctor?.connection == Connection.Online) {
                binding.textViewDoctorCalls.text =
                    "دکتر ${myDoctor?.name}انلاین است و میتواند به شما تلفن کند."
                binding.buttonDrCall.isEnabled = true
            }else{
                binding.textViewDoctorCalls.text =
                    "دکتر ${myDoctor?.name}افلاین است و میتوانید از طریق صفحه خود دکتر به ایشان پیامک دهید."
                binding.buttonDrCall.isEnabled = true
            }
        }
        binding.buttonDrCall.setOnClickListener {
            if(getFromShared_name()!=""&&getFromShared_tel()!="")
                openCheckActivity()
            else if(getUserNameAndTel())
                openCheckActivity()
        }
        if (!getFromShared_name().isNullOrEmpty() ){
            binding.editTextName.visibility = View.GONE
        }
        if (!getFromShared_tel().isNullOrEmpty() ){
            binding.editTextTel.visibility = View.GONE
        }
    }

    private fun openCheckActivity() {
        val intent = Intent(this , CheckPatientActivity::class.java)
        startForResult.launch(intent)
    }

    private fun getUserNameAndTel():Boolean {
        return if (binding.editTextName.text.isNotEmpty()&& binding.editTextTel.text.length==11){
            var username = binding.editTextName.text.toString()
            var userTel = binding.editTextTel.text.toString()
            saveInShared(username , userTel)
            true
        } else if(binding.editTextTel.text.length!=11){
            binding.editTextTel.error="تلفن نامعتبر"
            false
        }else{

            false
        }
    }

    private fun saveInShared(username: String, userTel: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name" , username)
        editor.putString("tel" , userTel)
        editor.apply()
    }
    private fun getFromShared_name() : String?{
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        var name = sharedPreferences.getString("name" , "")
        return name
    }
    private fun getFromShared_tel() : String?{
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        var tel = sharedPreferences.getString("tel" , "")
        return tel
    }
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val isOk =  intent?.getBooleanExtra("isOk", false)
            isOk?.let{
                if(it)
                    Toast.makeText(this , "دکتر با شما تماس خواهد گرفت." , Toast.LENGTH_SHORT).show()
                else{
                    Toast.makeText(this , "نوع مشاوره را انتخاب کنید." , Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}