package com.softdevelopers.techbridge

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajuste de insets para que se vea correctamente
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Redirigir a LoginActivity después de 4 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish() // Cerrar MainActivity para que no pueda volver al hacer 'back'
        }, 2000) // 2000 milisegundos = 2 segundos
    }
}