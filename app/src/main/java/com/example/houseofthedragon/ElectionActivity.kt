package com.example.houseofthedragon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
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

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val textView = findViewById<TextView>(R.id.textView2)

        checkBox1.setOnCheckedChangeListener { _, isChecked1 ->
            if (isChecked1) {
                if (checkBox2.isChecked) {
                    textView.text = "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
                } else {
                    textView.text = "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
                }
            } else {
                if (checkBox2.isChecked) {
                    textView.text = "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
                } else {
                    textView.text = "Si no tomas una decisión no podrás salir de esta encrucijada."
                }
            }
        }

        checkBox2.setOnCheckedChangeListener { _, isChecked2 ->
            if (isChecked2) {
                if (checkBox1.isChecked) {
                    textView.text = "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
                } else {
                    textView.text = "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
                }
            } else {
                if (checkBox1.isChecked) {
                    textView.text = "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
                } else {
                    textView.text = "Si no tomas una decisión no podrás salir de esta encrucijada."
                }
            }
        }

        val hincar = findViewById<Button>(R.id.button2)
        hincar.setOnClickListener {
            goToFinal()
        }
    }

    fun goToFinal() {

        val intent = Intent(this@ElectionActivity, FinalActivity::class.java)

        val etNombre = this.findViewById<EditText>(R.id.etName)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)

        if (checkBox1.isChecked) {
            if (checkBox2.isChecked) {
                intent.putExtra("ELECCION", "ambos")
            } else {
                intent.putExtra("ELECCION", "Rhaenyra")
            }
        } else {
            if (checkBox2.isChecked) {
                intent.putExtra("ELECCION", "Aegon")
            } else {
                intent.putExtra("ELECCION", "ninguno")
            }
        }

        startActivity(intent)
        finish()
    }
}