package com.dam2.ejemplosintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // definir el requestCode
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2
    val RESULTADO_TRES = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gosecond = findViewById<Button>(R.id.gosecond)

        gosecond.setOnClickListener{
            // Crea un Intent para iniciar la segunda actividad
            val intent = Intent(this, SecondActivity::class.java)

            // Añade nros al Intent
            intent.putExtra("nro1", 2)
            intent.putExtra("nro2", 3)
            // Inicia la segunda actividad
            startActivityForResult(intent, RESULTADO_UNO)
            // lo mismo para otras dos llamadas
            intent.putExtra("nro1", 4)
            intent.putExtra("nro2", 4)
            // Inicia la segunda actividad
            startActivityForResult(intent, RESULTADO_DOS)
            intent.putExtra("nro1", 6)
            intent.putExtra("nro2", 10)
            // Inicia la segunda actividad
            startActivityForResult(intent, RESULTADO_TRES)
        }

    }

    @Deprecated("Deprecated a partir de API 30")
    // recoje el intent cuando hacemos setResult() en la SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Definimos el text view para mostrar el dato que nos manda la Second
        val suma1 = findViewById<TextView>(R.id.suma1)
        val suma2 = findViewById<TextView>(R.id.suma2)
        val suma3 = findViewById<TextView>(R.id.suma3)
        // Comprueba que el resultado es OK
        if(resultCode != Activity.RESULT_OK || data == null) return
        // Puedo distinguir diferentes acciones según el requestCode
        when(requestCode) {
            RESULTADO_UNO -> {
                suma1.text = data.getIntExtra("suma",0).toString()
            }
            RESULTADO_DOS -> {
                suma2.text = data.getIntExtra("suma",0).toString()
            }
            RESULTADO_TRES -> {
                suma3.text = data.getIntExtra("suma",0).toString()
            }
            // Other result codes
            else -> {}
        }
    }
}