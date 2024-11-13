package com.example.houseofthedragon

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        //obtener una referencia a la etiqueta de la actividad
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)

        //recogemos el nombre del intent
        val nombre = intent.getStringExtra("NAME")
        //creamos la cadena del saludo
        tvGreeting.apply {
            //toma el valor de la cadena "greeting" y le incorpora el valor del nombre.
            text = getString(R.string.greeting,nombre)
        }
    }
}