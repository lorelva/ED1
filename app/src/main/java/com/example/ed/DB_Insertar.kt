package com.example.ed

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DB_Insertar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_insertar)

        findViewById<Button>(R.id.volver4).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.insertar).setOnClickListener {
            RegistrarUsuario()
        }

    }

    fun RegistrarUsuario() {
        val name = findViewById<EditText>(R.id.Nombre).text.toString()
        val lastname = findViewById<EditText>(R.id.Apellido).text.toString()
        val phone = findViewById<EditText>(R.id.editTextText).text.toString()
        val street = findViewById<EditText>(R.id.calle).text.toString()

        // Obtener una instancia de la base de datos
        val databaseHelper = DatabaseHelper(this)
        val db = databaseHelper.readableDatabase

        // Crear un nuevo mapa de valores, donde los nombres de las columnas son las keys
        val values = ContentValues().apply {
            put("NOMBRE", name)
            put("APELLIDO", lastname)
            put("TELEFONO", phone)
            put("CALLE", street)
        }

        // Insertar la nueva fila, devolviendo el valor de la clave primaria de la nueva fila
        val newRowId = db?.insert("USUARIO", null, values)

        if (newRowId != -1L) {
            Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
        }

        // Cerrar la base de datos
        db.close()

    }

}