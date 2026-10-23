package com.example.proyectolibrevictor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditGameActivity : AppCompatActivity() {

    private var posicionJuego: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_game)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etTitulo = findViewById<EditText>(R.id.etEditarTitulo)
        val etPlataforma = findViewById<EditText>(R.id.etEditarPlataforma)
        val etEstado = findViewById<EditText>(R.id.etEditarEstado)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarCambios)
        val btnEliminar = findViewById<Button>(R.id.btnEliminarJuego)
        val btnVolver = findViewById<Button>(R.id.btnVolverEdit)

        posicionJuego = intent.getIntExtra("EXTRA_POSICION", -1)

        if (posicionJuego != -1 && posicionJuego < GameRepository.listaVideojuegos.size) {
            val juego = GameRepository.listaVideojuegos[posicionJuego]
            etTitulo.setText(juego.titulo)
            etPlataforma.setText(juego.plataforma)
            etEstado.setText(juego.estado)
        }

        btnGuardar.setOnClickListener {
            val nuevoTitulo = etTitulo.text.toString().trim()
            val nuevaPlataforma = etPlataforma.text.toString().trim()
            val nuevoEstado = etEstado.text.toString().trim()

            if (nuevoTitulo.isEmpty() || nuevaPlataforma.isEmpty() || nuevoEstado.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (posicionJuego != -1) {
                GameRepository.listaVideojuegos[posicionJuego] = Videojuego(nuevoTitulo, nuevaPlataforma, nuevoEstado)
                GameRepository.guardarEnAlmacenamiento(this)

                Toast.makeText(this, "Juego modificado con éxito", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnEliminar.setOnClickListener {
            if (posicionJuego != -1) {
                GameRepository.listaVideojuegos.removeAt(posicionJuego)
                GameRepository.guardarEnAlmacenamiento(this)

                Toast.makeText(this, "Juego eliminado", Toast.LENGTH_SHORT).show()
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