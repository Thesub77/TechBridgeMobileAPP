package com.softdevelopers.techbridge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Consultas2Adapter {
    class Consultas2Adapter(private val exchanges: List<btconsulta2>): // Define la clase del adaptador y recibe una lista de usuarios como parámetro
        RecyclerView.Adapter<Consultas2Adapter.ExchangeViewHolder>() { // Extiende RecyclerView.Adapter y especifica el tipo de ViewHolder

        // Clase interna que representa cada elemento de la lista en la vista
        class ExchangeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            // Define los campos del itemView
            private val textViewProjectName = itemView.findViewById<TextView>(R.id.textViewProjectName)
            private val textViewProfitMargin = itemView.findViewById<TextView>(R.id.textViewProfitMargin)
            private val porcentaje = itemView.findViewById<TextView>(R.id.textPorcentaje)

            // Función para vincular el valor con el campo del itemView
            fun bind(exch: btconsulta2){
                textViewProjectName.text = "Cliente"+exch.nombre
                textViewProfitMargin.text = "$" + exch.margin.toString()
                // Convertir el margen de ganancia en porcentaje y establecer el texto y color del porcentaje
                val marginPercentage = exch.margin / 100

                // Establece el texto y cambia el color del TextView porcentaje
                porcentaje.text = "Margen: $marginPercentage%".also {
                    porcentaje.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            if (marginPercentage >= 1) R.color.verde else if (marginPercentage <= 0) R.color.rojo else R.color.black
                        )
                    )
                }
            }
        }

        // Método llamado cuando se necesita crear un nuevo ViewHolder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
            // Define el diseño de los elementos de la vista
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_clientes,parent,false)
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
