package com.softdevelopers.techbridge


import com.google.gson.annotations.SerializedName

//Consulta1

//Clase de los datos que vienen de la api para la consulta1
data class btconsulta1(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
    @SerializedName("Payment Amount Without Nulls") val payment: Double
)

//Aqui se encuentran las variables de la api y se guardan en una lista
lateinit var listabtconsulta1: List<btconsulta1>

//Consulta2
data class btconsulta2(
    @SerializedName("Company Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
    @SerializedName("Payment Amount Without Nulls") val payment: Double
)

//Aqui se encuentran las variables de la api y se guardan en una lista
lateinit var listabtconsulta2: List<btconsulta2>

//Consulta3
data class btconsulta3(
    @SerializedName("Year") val anio: Double,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
)

//Aqui se encuentran las variables de la api y se guardan en una lista
lateinit var listabtconsulta3: List<btconsulta3>

//Consulta4
data class btconsulta4(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
    @SerializedName("Payment Amount Without Nulls") val payment: Double
)

lateinit var listabtconsulta4: List<btconsulta4>

//Consulta5
data class btconsulta5(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Payment Amount Without Nulls") val payment: Double
)

lateinit var listabtconsulta5: List<btconsulta5>

//Consulta6
data class btconsulta6(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
    @SerializedName("Payment Amount Without Nulls") val payment: Double
)

lateinit var listabtconsulta6: List<btconsulta6>
//Consulta7
data class btconsulta7(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Profit Margin Without Nulls") val margin: Double,
    @SerializedName("Payment Amount Without Nulls") val payment: Double
)

lateinit var listabtconsulta7: List<btconsulta7>
//Consulta8
data class btconsulta8(
    @SerializedName("Project Name") val nombre: String,
    @SerializedName("Payment Amount") val payment: Double
)

lateinit var listabtconsulta8: List<btconsulta8>