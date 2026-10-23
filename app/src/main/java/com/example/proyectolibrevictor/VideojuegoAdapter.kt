package com.example.proyectolibrevictor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideojuegoAdapter(
    private val listaVideojuegos: List<Videojuego>,
    private val onItemClick: (Videojuego) -> Unit
) : RecyclerView.Adapter<VideojuegoAdapter.VideojuegoViewHolder>() {

    class VideojuegoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvPlataforma: TextView = view.findViewById(R.id.tvPlataforma)
        val tvEstado: TextView = view.findViewById(R.id.tvEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideojuegoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_videojuego, parent, false)
        return VideojuegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideojuegoViewHolder, position: Int) {
        val juego = listaVideojuegos[position]
        holder.tvTitulo.text = juego.titulo
        holder.tvPlataforma.text = juego.plataforma
        holder.tvEstado.text = juego.estado

        holder.itemView.setOnClickListener {
            onItemClick(juego)
        }
    }

    override fun getItemCount(): Int = listaVideojuegos.size
}