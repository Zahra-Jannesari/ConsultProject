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
    fun getConsultancyTime(numberOfConsultancy:Int):Int{
        return Hospital.consultancyList[numberOfConsultancy].time
    }
    fun getConsultancyPrise(numberOfConsultancy:Int):Int{
        return Hospital.consultancyList[numberOfConsultancy].price
    }
    fun getDoctorName(numberOfDoctor: Int):String{
        return Hospital.doctorList[numberOfDoctor].name
    }
    fun getDoctorExpertise(numberOfDoctor: Int):String{
        return Hospital.doctorList[numberOfDoctor].field
    }
    fun getConectionState(numberOfDoctor: Int):Connection{
        return Hospital.doctorList[numberOfDoctor].connection
    }
}