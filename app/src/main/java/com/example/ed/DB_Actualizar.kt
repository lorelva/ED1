package com.example.ed

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DB_Actualizar : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase

    private lateinit var nombreEditText: EditText
    private lateinit var apellidoEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var calleEditText: EditText
    private lateinit var idEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bd_actualizar)

        dbHelper = DatabaseHelper(this)
        db = dbHelper.writableDatabase

        idEditText = findViewById(R.id.editTextText3)
        nombreEditText = findViewById(R.id.nombre)
        apellidoEditText = findViewById(R.id.apellido)
        telefonoEditText = findViewById(R.id.telefono)
        calleEditText = findViewById(R.id.calle2)

        findViewById<Button>(R.id.volver2).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.Actualizar).setOnClickListener {
            actualizarDatos()
        }
    }

    private fun actualizarDatos() {
        val id = idEditText.text.toString()
        val nombre = nombreEditText.text.toString()
        val apellido = apellidoEditText.text.toString()
        val telefono = telefonoEditText.text.toString()
        val calle = calleEditText.text.toString()

        val values = ContentValues()
        values.put("NOMBRE", nombre)
        values.put("APELLIDO", apellido)
        values.put("TELEFONO", telefono)
        values.put("CALLE", calle)

        val selection = "ID = ?"
        val selectionArgs = arrayOf(id) // Cambia el valor según el registro que desees actualizar

        val count = db.update("USUARIO", values, selection, selectionArgs)

        if (count > 0) {
            Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error al actualizar los datos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}