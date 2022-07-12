package com.example.prueba2l

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba2l.IniciarAplicativo.Companion.prefs
import com.example.prueba2l.databinding.ActivityResulBinding

class Resul : AppCompatActivity() {
    private lateinit var binding: ActivityResulBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resul)
        binding = ActivityResulBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val pun = prefs.mostrar()
//        binding.txtresul.text = "Has ganado $pun puntos ¡Felicitaciones! "


        val bundle = intent.extras
        val dato = bundle?.getString("resul")
        val text = "Has ganado ${dato} punto ¡Felicitaciones! "
        binding.txtresul.text = text

        binding.Sigui.setOnClickListener {
            val intent = Intent(this, Puntaje::class.java)
            startActivity(intent)
        }



        /*val resul = mutableListOf<String>()
        resul.add(dato.toString())
        println(resul[0])*/

    }

}



