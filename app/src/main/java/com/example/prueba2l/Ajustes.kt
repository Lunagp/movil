package com.example.prueba2l

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.prueba2l.databinding.ActivityAjustesBinding

class Ajustes : AppCompatActivity() {

    private lateinit var binding: ActivityAjustesBinding
    val spinjue = mutableListOf("30 segundos", "1 min", "1 min y medio")
    val spinpal = mutableListOf("2 segundos", "3 segundos", "4 segundos")
    var jue : Int = 0
    var pala : Int  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)
        binding = ActivityAjustesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        referenciar()

    }

    private fun referenciar() {
        val arrayAdapter: ArrayAdapter<String>
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, spinjue)
        binding.SpinJuego.adapter = arrayAdapter
        binding.SpinJuego.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (spinjue[position] == "30 segundos"){
                    jue = 30000
                }else if (spinjue[position] == "1 min"){
                    jue =  60000
                }else if (spinjue[position] == "1 min y medio"){
                    jue = 90000
                }
                Toast.makeText(this@Ajustes, " " + spinjue[position]+ "..." + jue, Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val arrayAdapter1: ArrayAdapter<String>
        arrayAdapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, spinpal)
        binding.SpinPalabra.adapter = arrayAdapter1
        binding.SpinPalabra.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (spinpal[p2] == "2 segundos"){
                    pala = 2000
                }else if (spinpal[p2] == "3 segundos"){
                    pala =  3000
                }else if (spinpal[p2] == "4 segundos"){
                    pala = 4000
                }
                Toast.makeText(this@Ajustes, " " + spinpal[p2] + "..." + pala, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.btnInicio.setOnClickListener {
            var ju = jue.toString()
            var pa =  pala.toString()
            var intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, " "+ pa  + " " +ju , Toast.LENGTH_SHORT).show()
            intent.putExtra("juego", ju)
            intent.putExtra("palabra", pa)
            startActivity(intent)
        }
    }
}