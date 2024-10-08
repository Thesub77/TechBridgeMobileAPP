package com.softdevelopers.techbridge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Consultas1Adapter {
    class Consultas1Adapter(private val exchanges: List<btconsulta1>): // Define la clase del adaptador y recibe una lista de usuarios como parámetro
        RecyclerView.Adapter<Consultas1Adapter.ExchangeViewHolder>() { // Extiende RecyclerView.Adapter y especifica el tipo de ViewHolder

        // Clase interna que representa cada elemento de la lista en la vista
        class ExchangeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            // Define los campos del itemView
            private val textViewProjectName = itemView.findViewById<TextView>(R.id.textViewProjectName)
            private val textViewProfitMargin = itemView.findViewById<TextView>(R.id.textViewProfitMargin)
            private val porcentaje = itemView.findViewById<TextView>(R.id.textPorcentaje)

            // Función para vincular el valor con el campo del itemView
            fun bind(exch: btconsulta1){
                textViewProjectName.text = exch.nombre
                textViewProfitMargin.text = "$" + exch.margin.toString()
                porcentaje.text =  "Margen: "+"${exch.margin / 100}%".toString()+"%"

            }
        }

        // Método llamado cuando se necesita crear un nuevo ViewHolder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
            // Define el diseño de los elementos de la vista
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_project,parent,false)
            // Crea un nuevo objeto UserViewHolder con la vista inflada
            return ExchangeViewHolder(view)
        }

        // Método que devuelve el número total de elementos en la lista
        override fun getItemCount(): Int {
            return exchanges.size
        }

        // Método llamado cuando RecyclerView necesita mostrar un elemento en una posición específica
        override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
            val exchange = exchanges[position] // Obtiene el usuario en la posición dada
            holder.bind(exchange) // Llama a la función bind del ViewHolder para actualizar los campos de la vista con los datos
        }
    }


}

