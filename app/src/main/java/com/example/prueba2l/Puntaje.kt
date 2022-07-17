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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntaje)
        binding = ActivityPuntajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pun = prefs.mostrar()
        binding.txtpun.text = pun
        val arrayAdapter: ArrayAdapter<*>
        var pu = pun.toInt()

        val puntaje = ArrayList<Int>()
//        val datos = findViewById<ListView>(R.id.lista)

        var dato = pu
        puntaje.add(dato)

        var tinyDB : TinyDB = TinyDB(this)
        tinyDB.putListInt("listapuntaje", puntaje)

//        var dato = pu
//        puntaje.add(dato)

        if (puntaje.size == 0) {
            puntaje.add(dato)
//            puntaje[0] = dato
        }else if (puntaje.size == 1) {
            puntaje[1] = dato
        }else if (puntaje.size == 2){
            puntaje[2] = dato
        }else if (puntaje.size == 3){
            puntaje[3] = dato
        }else if (puntaje.size == 4){
            puntaje[4] = dato
        }

        var punta = puntaje.sortedDescending()

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, punta)
        binding.lista.adapter = arrayAdapter

            binding.btnInicio.setOnClickListener {
                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
            }
        }
}