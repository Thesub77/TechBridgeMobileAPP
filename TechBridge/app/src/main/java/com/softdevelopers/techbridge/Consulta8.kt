package com.softdevelopers.techbridge

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitString
import com.google.gson.Gson
import com.softdevelopers.techbridge.databinding.ActivityConsulta6Binding
import com.softdevelopers.techbridge.databinding.ActivityConsulta8Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Consulta8 : AppCompatActivity() {
    private lateinit var binding: ActivityConsulta8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla el layout usando View Binding
        binding = ActivityConsulta8Binding.inflate(layoutInflater)
        setContentView(binding.root) // Establece el root view del binding como el contenido de la actividad

        // Configura el listener para los insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Cargar el metodo users
        loadUsers()

        Toast.makeText(this, "Llegada", Toast.LENGTH_SHORT).show()

    }
    private fun loadUsers() {
        // Utiliza GlobalScope.launch para lanzar una nueva corrutina en el hilo de IO
        GlobalScope.launch(Dispatchers.IO) {
            try {
                // Realiza una solicitud HTTP GET a la API y espera la respuesta como una cadena
                val response = Fuel.get("https://795b-2803-2d60-1105-2873-c14-3fa5-d4ba-aea.ngrok-free.app/proyectosCostos_mayor_1500000").awaitString()

                // Utiliza withContext para cambiar al hilo principal y actualizar la IU
                withContext(Dispatchers.Main) {
                    // Inicializa Gson para convertir la respuesta JSON en una lista de usuarios
                    val gson = Gson()
                    //Toast.makeText(this@Consulta6, response, Toast.LENGTH_SHORT).show()
                    var listabtconsulta8 = gson.fromJson(response, Array<btconsulta8>::class.java).toList()

                    // Elimina el primer elemento de la lista
                    listabtconsulta8 = listabtconsulta8.drop(1)

                    binding.recyclerView.layoutManager = LinearLayoutManager(this@Consulta8)
                    binding.recyclerView.adapter = Consultas8Adapter.Consultas8Adapter(listabtconsulta8)

                }
            } catch (ex: Exception) {
                // Maneja cualquier excepción que pueda ocurrir durante la carga de usuarios
                withContext(Dispatchers.Main) {
                    // Muestra un mensaje de error en un Toast
                    Toast.makeText(
                        this@Consulta8,
                        "Error:  ${ex.message}",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
    }
}