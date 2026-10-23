package com.example.proyectolibrevictor

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GameRepository {

    val listaVideojuegos = mutableListOf<Videojuego>()

    private const val PREFS_NAME = "mis_juegos_prefs"
    private const val KEY_JUEGOS = "key_lista_juegos"


    fun guardarEnAlmacenamiento(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(listaVideojuegos)
        editor.putString(KEY_JUEGOS, json)
        editor.apply()
    }


    fun cargarDesdeAlmacenamiento(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = sharedPreferences.getString(KEY_JUEGOS, null)

        if (!json.isNullOrEmpty()) {
            val gson = Gson()
            val type = object : TypeToken<MutableList<Videojuego>>() {}.type
            val juegosGuardados: MutableList<Videojuego> = gson.fromJson(json, type)

            listaVideojuegos.clear()
            listaVideojuegos.addAll(juegosGuardados)
        }
    }
}