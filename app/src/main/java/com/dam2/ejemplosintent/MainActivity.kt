package com.dam2.ejemplosintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // definir el requestCode
    val RESULTADO_UNO=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gosecond = findViewById<Button>(R.id.gosecond)

        gosecond.setOnClickListener{
            // Crea un Intent para iniciar la segunda actividad
            val intent = Intent(this, SecondActivity::class.java)

// Añade datos adicionales al Intent
            intent.putExtra("proveedores", 2)
            intent.putExtra("clientes", 3)

// Inicia la segunda actividad
            startActivityForResult(intent, RESULTADO_UNO)
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val saludo = findViewById<TextView>(R.id.textView2)
        if(resultCode != Activity.RESULT_OK) return
        when(requestCode) {
            RESULTADO_UNO -> {
                if (data != null) {
                    saludo.text = data.getStringExtra("saludo")
                }; }
            // Other result codes
            else -> {}
        }
    }
}