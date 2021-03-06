package com.example.prueba2l

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.prueba2l.IniciarAplicativo.Companion.prefs
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
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (spinjue[position] == "30 segundos"){
                    jue = 30000
                }else if (spinjue[position] == "1 min"){
                    jue =  60000
                }else if (spinjue[position] == "1 min y medio"){
                    jue = 90000
                }
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
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.btnInicio.setOnClickListener {
            val palabras = ArrayList<String>()
            val colores = ArrayList<Int>()
            val amarillo: Int = ContextCompat.getColor( this, R.color.yellow)
            val negro: Int = resources.getColor(R.color.black)
            val azul: Int = resources.getColor(R.color.Blue)
            val naranja: Int = resources.getColor(R.color.Orange)
            val verde: Int = resources.getColor(R.color.Green)
            val rojo: Int = resources.getColor(R.color.Red)
            val purpura: Int = resources.getColor(R.color.purple_200)

            if(binding.chAmarillo.isChecked){
                palabras.add("Amarillo")
                colores.add(amarillo)
            }
            if(binding.chAzul.isChecked){
                palabras.add("Azul")
                colores.add(azul)
            }
            if(binding.chNaranja.isChecked){
                palabras.add("Naranja")
                colores.add(naranja)
            }
            if(binding.chNegro.isChecked){
                palabras.add("Negro")
                colores.add(negro)
            }
            if(binding.chVerde.isChecked){
                palabras.add("Verde")
                colores.add(verde)
            }
            if(binding.chRojo.isChecked){
                palabras.add("Rojo")
                colores.add(rojo)
            }
            if(binding.chPurpura.isChecked){
                palabras.add("Purpura")
                colores.add(purpura)
            }

            prefs.guardarminju(jue)
            prefs.guardarminpa(pala)
            var intent = Intent(this, Inicio::class.java)
            var tinyDB : TinyDB = TinyDB(this)
            tinyDB.putListString("listapalabra", palabras)
            tinyDB.putListInt("listacolores", colores)
            startActivity(intent)
            finish()
        }
    }
}





