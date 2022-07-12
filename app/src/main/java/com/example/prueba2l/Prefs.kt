package com.example.prueba2l

import android.content.Context

class Prefs(val context: Context) {
    val db = "Punajes"
    val resul = "puntaje"
    val sharedPref = context.getSharedPreferences(db, 0)

    fun guardar(puntaje:String){
        sharedPref.edit().putString(resul, puntaje)
        sharedPref.edit().commit()
    }

    fun mostrar():String{

//        return sharedPref.getString(resul, "")!!
    }
}