package com.zarisa.sampleproject
object Hospital{
    val doctorList= arrayListOf<Doctor>()
    val consultancyList= arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )
    fun getDoctor(id : Int) : Doctor?{
        for (doctor in doctorList){
            if (doctor.id == id){
                return doctor
            }
        }
        return null
    }
    fun setTestData(){
        doctorList.clear()
        doctorList.add(Doctor(1 , "Dr. sara" ,  Connection.Online , "روانشناسی و مشاوره" ))
        doctorList.add(Doctor(2 , "Dr. John" , Connection.Offline , "روانشناسی و مشاوره" ))
    }
}
data class Doctor(val id:Int,val name:String, var connection:Connection,var field:String,var imageId:Int?=null){

}
data class Consultancy(val id:Int,val time:Int,val price:Int,val type:ConsultancyType){

}
enum class ConsultancyType{
    Phone,Video
}
enum class Connection{
    Online,Offline
}