package com.softdevelopers.techbridge

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.widget.ImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Redireccionar el boton Back hacia la pagina principal
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        
        //Redireccionar el boton de cerrar sesion hacia el login
        val btncerrarsesion: ImageButton = findViewById(R.id.btncerrarsesion)
        btncerrarsesion.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        //Redireccionar el boton hacia las consultas
        //Redireccionar el boton de cerrar sesion hacia el login
        val btnconsultas: ImageButton = findViewById(R.id.btnconsultas)
        btnconsultas.setOnClickListener {
            val intent = Intent(this, consulta::class.java)
            startActivity(intent)
        }


    }
    }
