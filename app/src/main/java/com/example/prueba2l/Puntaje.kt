package com.example.prueba2l

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.prueba2l.databinding.ActivityPuntajeBinding
import com.example.prueba2l.databinding.ActivityResulBinding

class Puntaje : AppCompatActivity() {
    private lateinit var binding: ActivityPuntajeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntaje)
        binding = ActivityPuntajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayAdapter:ArrayAdapter<*>

        val puntaje = mutableListOf<String>()
        val datos = findViewById<ListView>(R.id.lista)

        val bundle = intent.extras
        val dato = bundle?.getString("resul")

        puntaje.add(dato.toString())

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, puntaje)
        datos.adapter = arrayAdapter


        binding.btnInicio.setOnClickListener {
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }
    }
}