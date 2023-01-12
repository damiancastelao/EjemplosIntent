package com.dam2.ejemplosintent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Recoge el Intent que ha iniciado la actividad
        val intent = getIntent()

        // Recoge el valor de tipo String pasado en el Intent
        val value = intent.getIntExtra("proveedores",0)

        val nroClientes = findViewById<TextView>(R.id.nroClientes)

        nroClientes.text = value.toString()


        intent.putExtra("saludo", "Hola");
        Log.d("MENSAJES", "actualizado intent")

        setResult(Activity.RESULT_OK, intent);
        Log.d("MENSAJES", "actualizado resultado")

        finish()


    }
}