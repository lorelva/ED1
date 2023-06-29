package com.example.ed

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "mydb"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USER_TABLE = ("CREATE TABLE USUARIO ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOMBRE TEXT, " +
                "APELLIDO TEXT, " +
                "TELEFONO TEXT, " +
                "CALLE TEXT)")

        db.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS USUARIO")
        onCreate(db)
    }

}