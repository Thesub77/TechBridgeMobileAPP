package com.softdevelopers.techbridge


import com.google.gson.annotations.SerializedName

//Consulta1

//Clase de los datos que vienen de la api para la consulta1
data class btconsulta1(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
)

//Aqui se encuentran las variables de la api y se guardan en una lista
lateinit var listabtconsulta1: List<btconsulta1>

//Consulta2
data class btconsulta2(
    @SerializedName("Company Name") val nombre: String,
    @SerializedName("Profit Margin") val margin: Double,
)

//Aqui se encuentran las variables de la api y se guardan en una lista
lateinit var listabtconsulta2: List<btconsulta2>