package com.example.ed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DB_Eliminar : AppCompatActivity() {

    private lateinit var idEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_eliminar)

        idEditText = findViewById(R.id.editTextText2)

        findViewById<Button>(R.id.volver).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.Eliminar).setOnClickListener {
            eliminar()
        }

    }

    private fun eliminar() {
        val id = idEditText.text.toString()

        val dbHelper = DatabaseHelper(this)
        val db = dbHelper.writableDatabase

        val selection = "ID = ?"
        val selectionArgs = arrayOf(id)

        val deletedRows = db.delete("USUARIO", selection, selectionArgs)

        if (deletedRows > 0) {
            Toast.makeText(this, "Registro eliminado correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error al eliminar el registro", Toast.LENGTH_SHORT).show()
        }

        db.close()
    }
}