package com.example.prueba2l

import android.content.Context

class Prefs(val context: Context) {
    val db = "Punajes"
    val resul = "puntaje"
    val minjuu = "minju"
    val minpaa = "minpa"
    val pun11 = "pun1"
    val pun22 = "pun2"
    val pun33 = "pun3"
    val pun44 = "pun4"
    val pun55 = "pun5"
    val pun66 = "pun5"
    val sharedPref = context.getSharedPreferences(db, 0)

    fun guardar(puntaje:String){
        sharedPref.edit().putString(resul, puntaje).apply()
    }
    fun mostrar():String{
        return sharedPref.getString(resul, "")!!
    }

    fun guardarminju(minju:Int){
        sharedPref.edit().putInt(minjuu, minju).apply()
    }
    fun mostrarminju():Int{
        return sharedPref.getInt(minjuu, 0)!!
    }

    fun guardarminpa(minpa:Int){
        sharedPref.edit().putInt(minpaa, minpa).apply()
    }
    fun mostrarminpa():Int{
        return sharedPref.getInt(minpaa, 0)!!
    }

    fun guardar1(pun1:Int){
        sharedPref.edit().putInt(pun11, pun1).apply()
    }
    fun mostrar1():Int{
        return sharedPref.getInt(pun11, 0)!!
    }

    fun guardar2(pun2:Int){
        sharedPref.edit().putInt(pun22, pun2).apply()
    }
    fun mostrar2():Int{
        return sharedPref.getInt(pun22, 0)!!
    }

    fun guardar3(pun3:Int){
        sharedPref.edit().putInt(pun33, pun3).apply()
    }
    fun mostrar3():Int{
        return sharedPref.getInt(pun33, 0)!!
    }

    fun guardar4(pun4:Int){
        sharedPref.edit().putInt(pun44, pun4).apply()
    }
    fun mostrar4():Int{
        return sharedPref.getInt(pun44, 0)!!
    }

    fun guardar5(pun5:Int){
        sharedPref.edit().putInt(pun55, pun5).apply()
    }
    fun mostrar5():Int{
        return sharedPref.getInt(pun55, 0)!!
    }

    fun guardar6(pun6:Int){
        sharedPref.edit().putInt(pun66, pun6).apply()
    }
    fun mostrar6():Int{
        return sharedPref.getInt(pun66, 0)!!
    }


}