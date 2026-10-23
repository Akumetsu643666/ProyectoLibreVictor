package com.example.proyectolibrevictor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etPlataforma = findViewById<EditText>(R.id.etPlataforma)
        val etEstado = findViewById<EditText>(R.id.etEstado)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnVolver = findViewById<Button>(R.id.btnVolverAgregar)


        btnGuardar.setOnClickListener {
            val titulo = etTitulo.text.toString().trim()
            val plataforma = etPlataforma.text.toString().trim()
            val estado = etEstado.text.toString().trim()

            if (titulo.isEmpty() || plataforma.isEmpty() || estado.isEmpty()) {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            } else {

                GameRepository.listaVideojuegos.add(Videojuego(titulo, plataforma, estado))


                GameRepository.guardarEnAlmacenamiento(this)

                Toast.makeText(this, "Juego guardado correctamente", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}