package com.example.ed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        findViewById<Button>(R.id.insert).setOnClickListener {
            val intent = Intent(this, DB_Insertar::class.java)
            startActivity(intent)

        }

        findViewById<Button>(R.id.Delete).setOnClickListener {
            val intent = Intent(this, DB_Eliminar::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.view).setOnClickListener {
            val intent = Intent(this, DB_Ver::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.update).setOnClickListener {
            val intent = Intent(this, DB_Actualizar::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.calcu).setOnClickListener {
            val intent = Intent(this, CalculadoraCientifica::class.java)
            startActivity(intent)
        }

    }
}