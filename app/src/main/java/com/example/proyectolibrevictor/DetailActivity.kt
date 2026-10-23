package com.example.proyectolibrevictor

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvTitulo = findViewById<TextView>(R.id.tvDetalleTitulo)
        val tvPlataforma = findViewById<TextView>(R.id.tvDetallePlataforma)
        val tvEstado = findViewById<TextView>(R.id.tvDetalleEstado)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val titulo = intent.getStringExtra("EXTRA_TITULO")
        val plataforma = intent.getStringExtra("EXTRA_PLATAFORMA")
        val estado = intent.getStringExtra("EXTRA_ESTADO")

        tvTitulo.text = titulo
        tvPlataforma.text = "Plataforma: $plataforma"
        tvEstado.text = "Estado: $estado"

        btnVolver.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}