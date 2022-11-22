package com.nachocampos.pac_uf2_camposmartijuanignacio

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // Variables de botones y campos de edición de texto.
        val editIdPlanta: EditText = findViewById(R.id.etIdPlanta)
        val editNombrePlanta: EditText = findViewById(R.id.etNombrePlanta)
        val editPrecioPlanta: EditText = findViewById(R.id.etPrecioPlanta)
        val btnInsert: Button = findViewById(R.id.btnInsertarDatos)
        val btnConsult: Button = findViewById(R.id.btnConsultarDatos)
        val btnInicio : Button = findViewById(R.id.btnInicio)

        /**
         * Al hacer click en "Insertar datos", los datos almacenados se guardan en la BD.
         */
        btnInsert.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"plantas", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("id_planta", Integer.parseInt(editIdPlanta.text.toString()))
            registro.put("nombre", editNombrePlanta.text.toString())
            registro.put("precio", editPrecioPlanta.text.toString().toDouble())
            bd.insert("plantas", null, registro)
            bd.close()
            editIdPlanta.setText("")
            editNombrePlanta.setText("")
            editPrecioPlanta.setText("")
            Toast.makeText(this, "Se subió la planta a la BD.", Toast.LENGTH_LONG).show()
        }

        /**
         * Al hacer click en "Buscar por ID", la planta asociada a ese ID se muestra por pantalla y,
         * si no existe, se muestra un mensaje informativo.
         */
        btnConsult.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "plantas", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery(
                "select nombre, precio from plantas " +
                        "where id_planta=${Integer.parseInt(editIdPlanta.text.toString())}",
                null)
            if (fila.moveToFirst()) {
                editNombrePlanta.setText(fila.getString(0))
                editPrecioPlanta.setText(fila.getString(1))
            } else
                Toast.makeText(
                    this,
                    "No existen plantas con dicho ID.",
                    Toast.LENGTH_LONG
                ).show()
            bd.close()
        }

        /**
         * Al hacer click en el botón "Inicio", nos desplazamos a la MainActivity y se muestra
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