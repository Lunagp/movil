package com.example.prueba2l

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.prueba2l.databinding.ActivityAjustesBinding

class Ajustes : AppCompatActivity() {

    private lateinit var binding: ActivityAjustesBinding
    val spinjue = mutableListOf("30 segundos", " 1 min", "1 min y medio")
    val spinpal = mutableListOf("2 segundos", "3 segundos", "4 segundos")

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
                Toast.makeText(this@MainActivity,
                    getString(R.string.selected_item) + " " +
                            "" + languages[position], Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val arrayAdapter1: ArrayAdapter<String>
        arrayAdapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, spinpal)
        binding.SpinPalabra.adapter = arrayAdapter


    }
}