package com.example.compteurandroid

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var compteur = 0

    private lateinit var textViewCompteur: TextView

    // true = négatif autorisé, false = minimum 0
    private val autoriserNegatif = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCompteur = findViewById(R.id.textViewCompteur)
        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonIncrementer5 = findViewById<Button>(R.id.buttonIncrementer5)
        val buttonDecrementer5 = findViewById<Button>(R.id.buttonDecrementer5)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)

        compteur = savedInstanceState?.getInt("compteur") ?: 0
        afficher()

        buttonIncrementer.setOnClickListener { modifier(1) }
        buttonDecrementer.setOnClickListener { modifier(-1) }
        buttonIncrementer5.setOnClickListener { modifier(5) }
        buttonDecrementer5.setOnClickListener { modifier(-5) }

        buttonReinitialiser.setOnClickListener {
            compteur = 0
            afficher()
            Toast.makeText(this, R.string.message_reinitialise, Toast.LENGTH_SHORT).show()
        }
    }

    private fun modifier(valeur: Int) {
        compteur += valeur
        if (!autoriserNegatif && compteur < 0) compteur = 0
        afficher()
    }

    private fun afficher() {
        textViewCompteur.text = compteur.toString()
        val couleur = when {
            compteur > 0 -> Color.parseColor("#2E7D32")
            compteur < 0 -> Color.RED
            else -> Color.BLACK
        }
        textViewCompteur.setTextColor(couleur)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("compteur", compteur)
    }
}