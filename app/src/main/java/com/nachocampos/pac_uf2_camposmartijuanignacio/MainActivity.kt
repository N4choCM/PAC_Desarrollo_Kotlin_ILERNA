package com.nachocampos.pac_uf2_camposmartijuanignacio

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables que recogen la referencia de cada botón.
        val btnPlay : Button = findViewById(R.id.btnPlay)
        val btnStop : Button = findViewById(R.id.btnStop)
        val btnActivity2 : Button = findViewById(R.id.btnActivity2)
        val btnActivity3 : Button = findViewById(R.id.btnActivity3)
        val btnActivity4 : Button = findViewById(R.id.btnActivity4)

        // Variable que funciona como resproductor de música.
        var mediaPlayer = MediaPlayer.create(this, R.raw.high_fidelity)


        /**
         * Al hacer click en el botón "Play", se reproduce la canción desde el principio
         * y se muestra un mensaje por pantalla.
         */
        btnPlay.setOnClickListener{
            mediaPlayer.start()
            Toast.makeText(this, "Reproduciendo...", Toast.LENGTH_LONG).show()
        }

        /**
         * Al hacer click en el botón "Stop", se detiene la reproducción, se muestra un mensaje por
         * pantalla y se reinicia la canción a 0 para que cuando se pulse el botón play se reproduzca
         * desde el inicio.
         */
        btnStop.setOnClickListener{
            mediaPlayer.stop()
            Toast.makeText(this, "Reproducción detenida.", Toast.LENGTH_LONG).show()
            mediaPlayer = MediaPlayer.create(this, R.raw.high_fidelity)
        }

        /**
         * Al hacer click en el botón "Activity 2", nos desplazamos a dicha Activity y se muestra
         * un mensaje informativo por pantalla.
         */
        btnActivity2.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
            Toast.makeText(this, "Estamos en la Activity 2.", Toast.LENGTH_LONG).show()
        }

        /**
         * Al hacer click en el botón "Activity 3", nos desplazamos a dicha Activity y se muestra
         * un mensaje informativo por pantalla.
         */
        btnActivity3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
            Toast.makeText(this, "Estamos en la Activity 3.", Toast.LENGTH_LONG).show()
        }

        /**
         * Al hacer click en el botón "Activity 4", nos desplazamos a dicha Activity y se muestra
         * un mensaje informativo por pantalla.
         */
        btnActivity4.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
            Toast.makeText(this, "Estamos en la Activity 4.", Toast.LENGTH_LONG).show()
        }
    }
}