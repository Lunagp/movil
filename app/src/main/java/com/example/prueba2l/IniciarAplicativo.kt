package com.example.prueba2l

import android.app.Application

class IniciarAplicativo : Application() {
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}