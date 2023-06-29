package com.example.ed

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class DB_Ver : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_ver)

        findViewById<Button>(R.id.volver3).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        dbHelper = DatabaseHelper(this)
        db = dbHelper.readableDatabase

        listView = findViewById(R.id.listaDatos)

        mostrarDatos()

    }
    private fun mostrarDatos() {
        val cursor: Cursor = db.rawQuery("SELECT * FROM USUARIO", null)
        val dataList = ArrayList<String>()

        val columnIndexID = cursor.getColumnIndex("ID")
        val columnIndexNombre = cursor.getColumnIndex("NOMBRE")
        val columnIndexApellido = cursor.getColumnIndex("APELLIDO")
        val columnIndexTelefono = cursor.getColumnIndex("TELEFONO")
        val columnIndexCalle = cursor.getColumnIndex("CALLE")

        if (cursor.moveToFirst()) {
            do {
                val id = if (columnIndexID != -1) cursor.getInt(columnIndexID) else 0
                val nombre = if (columnIndexNombre != -1) cursor.getString(columnIndexNombre) else ""
                val apellido = if (columnIndexApellido != -1) cursor.getString(columnIndexApellido) else ""
                val telefono = if (columnIndexTelefono != -1) cursor.getString(columnIndexTelefono) else ""
                val calle = if (columnIndexCalle != -1) cursor.getString(columnIndexCalle) else ""

                val data = "ID: $id\nNombre: $nombre\nApellido: $apellido\nTeléfono: $telefono\nCalle: $calle"
                dataList.add(data)
            } while (cursor.moveToNext())
        }

        cursor.close()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        listView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }

}