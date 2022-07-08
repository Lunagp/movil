package com.example.prueba2l

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.prueba2l.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var n : Int = 0
//    var p : Int = 0
    var x : Int = 0
    var a : Boolean = false
    var b : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ram()
        conteo(null, null)
    }

    private fun conteo(mili:Int?, coun: Int?) {
        if (mili == null && coun == null){
            object : CountDownTimer(60000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    termine()
                }
            }.start()
        }else if (mili != null && coun != null) {
            object : CountDownTimer(mili.toLong(), coun.toLong()) {

                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    termine()
                }
            }.start()

        }

    }
    private fun termine(){
        if (n == null){
            n = 0
            var resul = n.toString()
            var intent = Intent(this,Resul::class.java)
            intent.putExtra("resul", resul)
            startActivity(intent)
            finish()
        }else {
            var resul = n.toString()
            var intent = Intent(this,Resul::class.java)
            intent.putExtra("resul", resul)
            startActivity(intent)
            finish()
        }
    }



    private fun ram() {
            x = 0
            a = false
            b = false
            val amarillo: Int = ContextCompat.getColor( this, R.color.yellow)
            val negro: Int = resources.getColor(R.color.black)
            val azul: Int = resources.getColor(R.color.Blue)
            val naranja: Int = resources.getColor(R.color.Orange)
            val verde: Int = resources.getColor(R.color.Green)
            val rojo: Int = resources.getColor(R.color.Red)
            val purpura: Int = resources.getColor(R.color.purple_200)

            val palabras = arrayOf("Amarillo", "Azul", "Naranja", "Negro", "Rojo",  "Verde", "Purpura")
            val colores = arrayOf( amarillo,negro,azul,naranja,verde,rojo,purpura )

            val pal = palabras.random()
            val col = colores.random()
            binding.txtPalabra.text = pal
            binding.txtPalabra.setTextColor(col)

            binding.btncorre.setOnClickListener {
                x = 1
                a = true
            }

            binding.btnincorre.setOnClickListener {
                x = 2
                b = true
            }

            if (a == false && b == false){
                object : CountDownTimer(3000, 1000) {

                    override fun onTick(millisUntilFinished: Long) {
                    }

                    override fun onFinish() {
                        presionar(pal,col)
                    }
                }.start()
            }
    }

    private fun presionar(pal:String, col:Int) {
        when(x){
            1 -> {
//                p++
//                if (p >= 15 ){
//                    if (n == null){
//                        n = 0
//                        var resul = n.toString()
//                        var intent = Intent(this,Resul::class.java)
//                        intent.putExtra("resul", resul)
//                        startActivity(intent)
//                    }else {
//                        var resul = n.toString()
//                        var intent = Intent(this,Resul::class.java)
//                        intent.putExtra("resul", resul)
//                        startActivity(intent)
//                    }
//                }else {
                    x = 0
                    correcto(pal,col)
                    ram()
//                }

            }
            2 -> {
//                p++
//                if (p >= 15 ){
//                    if (n == null){
//                        n = 0
//                        var resul = n.toString()
//                        var intent = Intent(this,Resul::class.java)
//                        intent.putExtra("resul", resul)
//                        startActivity(intent)
//                    }else {
//                        var resul = n.toString()
//                        var intent = Intent(this,Resul::class.java)
//                        intent.putExtra("resul", resul)
//                        startActivity(intent)
//                    }
//                }else {
                    x = 0
                    incorrecto(pal,col)
                    Toast.makeText(this, "Fallaste", Toast.LENGTH_SHORT).show()
                    ram()
//                }

            }
            else -> {
//                if (p < 15){
                    x = 0
                    binding.img.setImageResource(R.drawable.incorrecto)
                    Toast.makeText(this, "Fallaste", Toast.LENGTH_SHORT).show()
                    ram()
//                    p++
//                }else if (p >= 15 ){
//                    if (n == null){
//                        n = 0
//                        var resul = n.toString()
//                        var intent = Intent(this,Resul::class.java)
//                        intent.putExtra("resul", resul)
//                        startActivity(intent)
//                    }else {
//                        var resul = n.toString()
//                        var intent = Intent(this,Resul::class.java)
//                        intent.putExtra("resul", resul)
//                        startActivity(intent)
//                    }
//                }
            }
        }
    }


    private fun incorrecto(pal:String, col:Int) {
        if (pal == "Amarillo" && col != -400274){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Negro" && col != -16777216){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Azul" && col != -16776961){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Naranja" && col != -360145){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Verde" && col != -16729299){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Rojo" && col != -3210997){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Purpura" && col != -4487428){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else{
            Toast.makeText(this, "Fallaste", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.incorrecto)
        }

    }

    private fun correcto(pal:String, col:Int) {
        if (pal == "Amarillo" && col == -400274){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Negro" && col == -16777216){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Azul" && col == -16776961){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Naranja" && col == -360145){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Verde" && col == -16729299){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Rojo" && col == -3210997){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else if (pal == "Purpura" && col == -4487428){
            n = n+1
            Toast.makeText(this, "Has ganado ${n}", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.correcto)
        }else {
            Toast.makeText(this, "Fallaste", Toast.LENGTH_SHORT).show()
            binding.img.setImageResource(R.drawable.incorrecto)
        }


    }

}



