package com.dam2.ejemplosintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // El botón para iniciar el teléfono
        val callButton = findViewById<Button>(R.id.call)
        // numero de telefono al que queremos llamar
        val url = findViewById<EditText>(R.id.url)


        callButton.setOnClickListener{
            // creamos un intent específico que iniciará el teléfono
            val intent = Intent(Intent.ACTION_VIEW)
            // rellenamos el intent con el número
            intent.data = Uri.parse(url.text.toString())
            // llamamos a la activity treléfono
            startActivity(intent)
        }
    }
}