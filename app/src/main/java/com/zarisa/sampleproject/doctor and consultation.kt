package com.zarisa.sampleproject
object Hospital{
    val doctorList= arrayListOf(
        Doctor(1 , "معصومه بهرامی" ,  Connection.Online , "مشاور" ),
        Doctor(2 , "علی رضایی" , Connection.Offline , "روان درمانگر" ),
        Doctor(3, "لیلا امینی",Connection.Online,"گفتار درمانگر"),
        Doctor(4,"محمد ناصری",Connection.Offline,"روانپزشک")
    )
    val consultancyList= arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )
}
data class Doctor(val id:Int,val name:String, var connection:Connection,var field:String)
data class Consultancy(val id:Int,val time:Int,val price:Int,val type:ConsultancyType)
enum class ConsultancyType{
    Phone,Video
}
enum class Connection{
    Online,Offline
}