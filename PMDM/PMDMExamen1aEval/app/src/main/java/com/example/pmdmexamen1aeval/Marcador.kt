package com.example.pmdmexamen1aeval

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.widget.Button
import android.widget.TextView

class Marcador : AppCompatActivity() {

    private lateinit var labelA: TextView
    private lateinit var labelB: TextView
    private lateinit var running: TextView
    private lateinit var puntosA: TextView
    private lateinit var puntosB: TextView
    private lateinit var sumarA: Button
    private lateinit var sumarB: Button
    private lateinit var restarA: Button
    private lateinit var restarB: Button
    private lateinit var btnStart: Button
    private lateinit var btnPause: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marcador)

        // Obtenemos referencia a la ActionBar, cambiamos título y ponemos flecha Atrás
        val actionBar = supportActionBar
        actionBar?.title = "Marcador"
        actionBar?.setDisplayShowHomeEnabled(true)

        // Obtenemos referencias a los elementos
        labelA = findViewById(R.id.tvEqA)
        labelB = findViewById(R.id.tvEqB)
        running = findViewById(R.id.tvStart)
        puntosA = findViewById(R.id.tvMarcadorA)
        puntosB = findViewById(R.id.tvMarcadorB)
        sumarA = findViewById(R.id.btnSumarA)
        sumarB = findViewById(R.id.btnSumarB)
        restarA = findViewById(R.id.btnRestarA)
        restarB = findViewById(R.id.btnRestarB)
        btnStart = findViewById(R.id.btnStart)
        btnPause = findViewById(R.id.btnPause)

        // Recibimos los valores del intent
        val nombreA = intent.getStringExtra("EQUIPOA")
        val nombreB = intent.getStringExtra("EQUIPOB")

        // Inicializamos marcadores
        puntosA.text = "0"
        puntosB.text = "0"

        // Modificamos las etiquetas del nombre de los equipos con los valores recibidos
        labelA.text = nombreA
        labelB.text = nombreB

        // Asociamos a cada botón su listener
        sumarA.setOnClickListener {
            puntosA.text = (puntosA.text.toString().toInt() + 1).toString()
        }
        sumarB.setOnClickListener {
            puntosB.text = (puntosB.text.toString().toInt() + 1).toString()
        }
        restarA.setOnClickListener {
            puntosA.text = (puntosA.text.toString().toInt() - 1).toString()
        }
        restarB.setOnClickListener {
            puntosB.text = (puntosB.text.toString().toInt() - 1).toString()
        }
        btnStart.setOnClickListener {
            running.text = "EN JUEGO"
        }
        btnPause.setOnClickListener {
            running.text = "TIEMPO PARADO"
        }

    }

    // Métodos para guardar y restaurar el estado de la aplicación
    // Mediante el objeto de tipo Bundle.
    override fun onSaveInstanceState(estadoAGuardar: Bundle) {
        super.onSaveInstanceState(estadoAGuardar)
        //Log.d("MARCADOR", "onSaveInstanceState. Guardo puntos equipo A "+puntosA.toString())
        estadoAGuardar.putString("PUNTOSA", puntosA.text.toString())
        estadoAGuardar.putString("PUNTOSB", puntosB.text.toString())
        estadoAGuardar.putString("EN JUEGO", running.text.toString())

        //estadoAGuardar.putString("NOMBREA", labelA.text.toString())
        //estadoAGuardar.putString("NOMBREB", labelB.text.toString())
    }

    override fun onRestoreInstanceState(estadoARestaurar: Bundle) {
        super.onRestoreInstanceState(estadoARestaurar)
        val marcadorA = estadoARestaurar.getString("PUNTOSA")
        val marcadorB = estadoARestaurar.getString("PUNTOSB")
        val enJuego = estadoARestaurar.getString("EN JUEGO")
        //val equipoB = estadoARestaurar.getString("NOMBREB")
        //Log.d("MARCADOR", "onRestoreInstanceState. Restauro al contador el valor "+contador.toString())

        puntosA.text = marcadorA
        puntosB.text = marcadorB
        running.text = enJuego

    }
}