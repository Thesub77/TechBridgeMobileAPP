package com.softdevelopers.techbridge

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.coroutines.awaitString
import com.github.kittinunf.fuel.gson.responseObject
import com.google.gson.Gson
import com.softdevelopers.techbridge.databinding.ActivityConsulta1Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Consulta1 : AppCompatActivity() {

    // Declara el binding
    private lateinit var binding: ActivityConsulta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla el layout usando View Binding
        binding = ActivityConsulta1Binding.inflate(layoutInflater)
        setContentView(binding.root) // Establece el root view del binding como el contenido de la actividad

        // Configura el listener para los insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, consulta::class.java)
            startActivity(intent)
        }

        loadUsers()

        Toast.makeText(this, "Llegada", Toast.LENGTH_SHORT).show()

        try {
        Fuel.get("https://cubeapitechbridge.westus.cloudapp.azure.com/apiolap/ganancia_15_proyectos_o_alfabet")
            .response { request, response, result ->

                    // Procesando la respuesta
                    val jsonBody = response.body().asString("application/json")
                    Toast.makeText(this, jsonBody, Toast.LENGTH_SHORT).show()

                    // Usar Gson para convertir el JSON a una lista
                    val gson = Gson()
                    val listabtconsulta1 = gson.fromJson(jsonBody, Array<btconsulta1>::class.java).toList()



                    // Configurando el RecyclerView con la lista
                    binding.recyclerView.layoutManager = LinearLayoutManager(this)
                    binding.recyclerView.adapter = Consultas1Adapter.Consultas1Adapter(listabtconsulta1)


            } } catch (e: Exception) {
            // Capturar cualquier excepción y mostrar el error
            Log.e("API Error", "Error al procesar la respuesta: ${e.message}")
            e.printStackTrace()
        }


    }

    private fun loadUsers() {
        // Utiliza GlobalScope.launch para lanzar una nueva corrutina en el hilo de IO
        GlobalScope.launch(Dispatchers.IO) {
            try {
                // Realiza una solicitud HTTP GET a la API y espera la respuesta como una cadena
                val response = Fuel.get("https://cubeapitechbridge.westus.cloudapp.azure.com/apiolap/ganancia_15_proyectos_o_alfabet").awaitString()

                // Utiliza withContext para cambiar al hilo principal y actualizar la IU
                withContext(Dispatchers.Main) {
                    // Inicializa Gson para convertir la respuesta JSON en una lista de usuarios
                    val gson = Gson()
                    Toast.makeText(this@Consulta1, response, Toast.LENGTH_SHORT).show()
                    var listabtconsulta1 = gson.fromJson(response, Array<btconsulta1>::class.java).toList()

                    listabtconsulta1 = listabtconsulta1.drop(1)

                    binding.recyclerView.layoutManager = LinearLayoutManager(this@Consulta1)
                    binding.recyclerView.adapter = Consultas1Adapter.Consultas1Adapter(listabtconsulta1)

                }
            } catch (ex: Exception) {
                // Maneja cualquier excepción que pueda ocurrir durante la carga de usuarios
                withContext(Dispatchers.Main) {
                    // Muestra un mensaje de error en un Toast
                    Toast.makeText(
                        this@Consulta1,
                        "Error:  ${ex.message}",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
    }


}





