package com.example.prueba2l


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.prueba2l.IniciarAplicativo.Companion.prefs
import com.example.prueba2l.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var n : Int = 0
//    var p : Int = 0
    var x : Int = 0
    var a : Boolean = false
    var b : Boolean = false
//    val sharedPref = getSharedPreferences("puntajes", Context.MODE_PRIVATE)
//    var edit = sharedPref.edit()
//    val bundle = intent.extras
//    val jue = bundle?.getString("jue")
//    val pala = bundle?.getString("pala")
  var pa:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val jue = bundle?.getString("juego")
        val pala = bundle?.getString("palabra")

        var ju = jue?.toInt()
        pa = pala?.toInt()
        val text = "$ju y $pa"
        Toast.makeText(this, "text " + text, Toast.LENGTH_SHORT).show()

        if (ju == null){
            conteo(null)
        }else {
            conteo(ju)
        }

        ram()

    }

    private fun conteo(jue:Int?) {
        if (jue == null){
            object : CountDownTimer(30000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    termine()
                }
            }.start()
        }else if (jue != null) {
            object : CountDownTimer(jue.toLong(),1000) {

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
            prefs.guardar(resul)
            var intent = Intent(this,Resul::class.java)
            intent.putExtra("resul", resul)
            startActivity(intent)
            finish()

        }
    }



    private fun ram() {
        x = 0
        binding.btncorre.isEnabled = true
        binding.btnincorre.isEnabled = true
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
            binding.btncorre.isEnabled = false
            binding.btnincorre.isEnabled = false
        }

        binding.btnincorre.setOnClickListener {
            x = 2
            binding.btncorre.isEnabled = false
            binding.btnincorre.isEnabled = false
        }
        if (pa == null){
            object : CountDownTimer(3000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    presionar(pal,col)
                }
            }.start()
        }else {
            object : CountDownTimer(pa!!.toLong(), 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    binding.txtPalabra.text = "" + millisUntilFinished/1000
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
                ram()
                correcto(pal,col)
            }
            2 -> {
                ram()
                incorrecto(pal,col)
            }
            else -> {
                ram()
                binding.img.setImageResource(R.drawable.incorrecto)
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



