package com.example.houseofthedragon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val tex = findViewById<TextView>(R.id.textView3)

        //recogemos el nombre del intent
        val nombre = intent.getStringExtra("ELECCION")
        //creamos la cadena del saludo
        tex.apply {
            //toma el valor de la cadena "greeting" y le incorpora el valor del nombre.
            text = getString(R.string.fin,nombre)
        }

        val salir =findViewById<Button>(R.id.button)
        salir.setOnClickListener() {
            finish()
        }
    }
}
