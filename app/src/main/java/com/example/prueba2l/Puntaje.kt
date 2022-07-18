package com.example.prueba2l

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.prueba2l.IniciarAplicativo.Companion.prefs
import com.example.prueba2l.databinding.ActivityPuntajeBinding
import com.example.prueba2l.databinding.ActivityResulBinding

class Puntaje : AppCompatActivity() {
    private lateinit var binding: ActivityPuntajeBinding
    var n1 :Int = 0
    var n2 :Int = 0
    var n3 :Int = 0
    var n4 :Int = 0
    var n5 :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntaje)
        binding = ActivityPuntajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pun = prefs.mostrar()
        val arrayAdapter: ArrayAdapter<*>
        var dato = pun.toInt()
        binding.txtpun1.text  =  "Tu puntuación es: $dato"

        val puntaje = ArrayList<Int>()

        n1 = prefs.mostrar1()
        n2 = prefs.mostrar2()
        n3 = prefs.mostrar3()
        n4 = prefs.mostrar4()
        n5 = prefs.mostrar5()
        var n6 = prefs.mostrar6()

        if (dato > n1) {
            if (n1 !=  0){
                var n11 = prefs.mostrar1()
                prefs.guardar6(n11)
            }else if (n6 !=  0){
                var n11 = prefs.mostrar1()
                prefs.guardar2(n11)
                n2 = prefs.mostrar2()
            }

            prefs.guardar1(dato)
            n1 = prefs.mostrar1()
        }else if (dato > n2) {
//            if (n6 !=  0 && n6 > n2){
//                var n11 = prefs.mostrar1()
//                prefs.guardar2(n11)
//                n2 = prefs.mostrar2()
//                n6=0
//            }
            prefs.guardar2(dato)
            n2 = prefs.mostrar2()
        }else if (dato > n3){
            if (n6 !=  0){
                var n11 = prefs.mostrar1()
                prefs.guardar2(n11)
                n2 = prefs.mostrar2()
            }
            prefs.guardar3(dato)
            n3 = prefs.mostrar3()
        }else if (dato > n4){
            prefs.guardar4(dato)
            n4 = prefs.mostrar4()
        }else if (dato > n5){
            prefs.guardar5(dato)
            n5 = prefs.mostrar5()
        }

        puntaje.add(n1)
        puntaje.add(n2)
        puntaje.add(n3)
        puntaje.add(n4)
        puntaje.add(n5)

        var punta = puntaje.sortedDescending()

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, punta)
        binding.lista.adapter = arrayAdapter

            binding.btnInicio.setOnClickListener {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
        }
}