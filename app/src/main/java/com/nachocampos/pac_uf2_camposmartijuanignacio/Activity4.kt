package com.nachocampos.pac_uf2_camposmartijuanignacio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        val btnInicio : Button = findViewById(R.id.btnInicio)

        /**
         * Al hacer click en el botón "Inicio", nos desplazamos a MainActivity y se muestra
         * un mensaje informativo por pantalla.
         */
        btnInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            Toast.makeText(
                this,
                "Estamos en la Main Activity de inicio.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}