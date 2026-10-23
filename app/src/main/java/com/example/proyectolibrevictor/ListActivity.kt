package com.example.proyectolibrevictor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private lateinit var adapter: VideojuegoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvVideojuegos = findViewById<RecyclerView>(R.id.rvVideojuegos)
        val btnVolver = findViewById<Button>(R.id.btnVolverLista)

        adapter = VideojuegoAdapter(GameRepository.listaVideojuegos) { juego ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_TITULO", juego.titulo)
                putExtra("EXTRA_PLATAFORMA", juego.plataforma)
                putExtra("EXTRA_ESTADO", juego.estado)
            }
            startActivity(intent)
        }

        rvVideojuegos.layoutManager = LinearLayoutManager(this)
        rvVideojuegos.adapter = adapter

        btnVolver.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}