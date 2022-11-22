package com.nachocampos.pac_uf2_camposmartijuanignacio

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        // Variables de botones.
        val btnInicio : Button = findViewById(R.id.btnInicio)
        val btnFoto : Button = findViewById(R.id.btnFoto)


        /**
         * Al hacer click en "Hacer foto", se nos abre la cámara y la foto que hagamos se muestra
         * por pantalla.
         */
        btnFoto.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }



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

    /**
     * Procedimiento que permite que la fotografía tomada con la cámara se imprima en la pantalla.
     */
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK){
                val intent = result.data
                val imageBitmap = intent?.extras?.get("data") as Bitmap
                val imageView = findViewById<ImageView>(R.id.ivCamera)
                imageView.setImageBitmap(imageBitmap)
            }
        }
}