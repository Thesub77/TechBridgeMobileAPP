package com.softdevelopers.techbridge

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class consulta : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consulta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Redireccionar el boton de la consulta1 hacia su pantalla
        val btnmarganancia: ImageButton = findViewById(R.id.btnmarganancia)
        btnmarganancia.setOnClickListener {
            val intent = Intent(this, Consulta1::class.java)
            startActivity(intent)
        }
        //Redireccionar el boton de la consulta1 hacia su pantalla
        val btnmargencliente: ImageButton = findViewById(R.id.btnmargencliente)
        btnmargencliente.setOnClickListener {
            val intent = Intent(this, Consulta2::class.java)
            startActivity(intent)
        }

        //Redireccionar el boton de la consulta1 hacia su pantalla
        val btnganciames: ImageButton = findViewById(R.id.btnganciames)
        btnganciames.setOnClickListener {
            val intent = Intent(this, Consulta4::class.java)
            startActivity(intent)
        }

        //Redireccionar el boton de la consulta1 hacia su pantalla
        val btnmenorgancia: ImageButton = findViewById(R.id.btnmenorgancia)
        btnmenorgancia.setOnClickListener {
            val intent = Intent(this, Consulta6::class.java)
            startActivity(intent)
        }


        //Redireccionar el boton de la consulta1 hacia su pantalla
        val btnmendasd: ImageButton = findViewById(R.id.btnmendasd)
        btnmendasd.setOnClickListener {
            val intent = Intent(this, Consulta8::class.java)
            startActivity(intent)
        }

        val btngancia10: ImageButton = findViewById(R.id.btngancia10)
        btngancia10.setOnClickListener {
            val intent = Intent(this, Consulta7::class.java)
            startActivity(intent)
        }

        val btnmayor100: ImageButton = findViewById(R.id.btnmayor100)
        btnmayor100.setOnClickListener {
            val intent = Intent(this, Consulta5::class.java)
            startActivity(intent)
        }
        val btnBackconsulta: ImageButton = findViewById(R.id.btnBackconsulta)
        btnBackconsulta.setOnClickListener {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }

        val btngananciamet: ImageButton = findViewById(R.id.btngananciamet)
        btngananciamet.setOnClickListener {
            val intent = Intent(this, Consulta3::class.java)
            startActivity(intent)
        }

    }
}