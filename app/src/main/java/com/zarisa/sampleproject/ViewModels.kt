package com.zarisa.sampleproject
import androidx.lifecycle.ViewModel
class ViewModel1 : ViewModel(){
    fun getDoctorName(numberOfDoctor: Int):String{
        return Hospital.doctorList[numberOfDoctor].name
    }
    fun getDoctorExpertise(numberOfDoctor: Int):String{
        return Hospital.doctorList[numberOfDoctor].field
    }
}
class ViewModel2:ViewModel(){

}