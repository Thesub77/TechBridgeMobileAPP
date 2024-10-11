package com.softdevelopers.techbridge

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {

    // Mapa para almacenar los usuarios y contraseñas
    private val users = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Llamamos la validacion de usuarios
        loadUsers()

    }
    //Validacion de usuarios
    private fun validateUser(username: String, password: String): Boolean {
        // Comprobamos si el usuario existe y si la contraseña es correcta
        return users[username] == password
    }
    //Creacion de usuarios
    private fun loadUsers() {
        // Inicializar los usuarios
        users["carlos"] = "123456"


        // Configuramos los componentes de la UI
        val txtUser = findViewById<EditText>(R.id.txtuser)
        val pswLogin = findViewById<EditText>(R.id.pswLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Configurar el listener del botón de inicio de sesión
        btnLogin.setOnClickListener {
            val username = txtUser.text.toString()
            val password = pswLogin.text.toString()

            // Validación de las credenciales
            if (validateUser(username, password)) {
                // Si las credenciales son correctas, pasamos a la siguiente actividad
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, menu::class.java) // MenuActivity es la siguiente pantalla
                startActivity(intent)
            } else {
                // Si son incorrectas, mostramos un mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}