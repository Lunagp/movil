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
        val arrayAdapter:ArrayAdapter<*>
        var pu = pun.toInt()

        val puntaje = arrayOfNulls<Int>(4)
        val datos = findViewById<ListView>(R.id.lista)

        var dato = pu

        puntaje[0] = 0
        puntaje[1] = 0
        puntaje[2] = 0
        puntaje[3] = 0
        puntaje[4] = 0

        if (puntaje == null){
            puntaje[0] = dato
//        }else if (puntaje[0]  dato){
//
//        }
//        val bundle = intent.extras



        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, puntaje)
        datos.adapter = arrayAdapter


        binding.btnInicio.setOnClickListener {
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }
    }


}