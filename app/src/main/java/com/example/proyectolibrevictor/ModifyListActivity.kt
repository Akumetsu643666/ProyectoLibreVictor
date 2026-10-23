package com.example.proyectolibrevictor

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ModifyListActivity : AppCompatActivity() {

    private lateinit var adapter: VideojuegoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rv = findViewById<RecyclerView>(R.id.rvModificarVideojuegos)

        adapter = VideojuegoAdapter(GameRepository.listaVideojuegos) { juego ->
            val posicion = GameRepository.listaVideojuegos.indexOf(juego)
            val intent = Intent(this, EditGameActivity::class.java).apply {
                putExtra("EXTRA_POSICION", posicion)
            }
            startActivity(intent)
        }

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
        if (GameRepository.listaVideojuegos.isEmpty()) {
            Toast.makeText(this, "No hay juegos para modificar", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}