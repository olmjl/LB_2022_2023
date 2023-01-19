package com.example.pmdmexamen1aeval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var equipoA: TextInputEditText
    private lateinit var equipoB: TextInputEditText
    private lateinit var boton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos referencias a los widgets
        equipoA = findViewById(R.id.etEquipoA)
        equipoB = findViewById(R.id.etEquipoB)
        boton = findViewById(R.id.btnEmpezar)

        boton.setOnClickListener {
            val textoA = equipoA.text.toString()
            val textoB = equipoB.text.toString()

            if (textoA.isNullOrEmpty() || textoB.isNullOrEmpty()) {
                Toast.makeText(this, "Debes rellenar los nombres de los equipos", Toast.LENGTH_LONG).show()
            } else {  // Lanzamos actividad 2 pasando como valores los nombres de los equipos
                val intent = Intent(this, Marcador::class.java)
                intent.putExtra("EQUIPOA", textoA)
                intent.putExtra("EQUIPOB", textoB)
                startActivity(intent)

            }
        }


    }
}