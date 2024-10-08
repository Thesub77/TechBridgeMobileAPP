package com.softdevelopers.techbridge


import com.google.gson.annotations.SerializedName

//Clase de losd atos que vienen de la api para la consulta1
data class btconsulta1(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
)

//Aqui se encuentran las variables de la api y se guardan en una lista
lateinit var listabtconsulta1: List<btconsulta1>