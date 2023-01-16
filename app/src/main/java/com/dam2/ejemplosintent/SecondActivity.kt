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
        val nro1 = intent.getIntExtra("nro1",0)
        val nro2 = intent.getIntExtra("nro2",0)

        // Meto un nuevo dato en el intent
        intent.putExtra("suma", nro1 + nro2);
        // Debug
        Log.d("MENSAJES", "actualizado intent")
        // Configuro el result para que la Main lo tenga disponible
        // Posibles resultados:
        //    Activity.RESULT_OK
        //    Activity.RESULT_CANCELED
        setResult(Activity.RESULT_OK, intent);
        // Debug
        Log.d("MENSAJES", "actualizado resultado")
        // cierro la activity
        finish()


    }
}