package com.example.proyectolibrevictor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GameRepository.cargarDesdeAlmacenamiento(this)

        val btnIrAgregar = findViewById<Button>(R.id.btnIrAgregar)
        val btnIrListado = findViewById<Button>(R.id.btnIrListado)
        val btnIrModificar = findViewById<Button>(R.id.btnIrModificar)

        btnIrAgregar.setOnClickListener {
            val intent = Intent(this, AddGameActivity::class.java)
            startActivity(intent)
        }

        btnIrListado.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        btnIrModificar.setOnClickListener {
            val intent = Intent(this, ModifyListActivity::class.java)
            startActivity(intent)
        }
    }
}