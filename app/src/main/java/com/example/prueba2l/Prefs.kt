package com.example.prueba2l

import android.content.Context

class Prefs(val context: Context) {
    val db = "Punajes"
    val resul = "puntaje"
    val minjuu = "minju"
    val minpaa = "minpa"
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
}