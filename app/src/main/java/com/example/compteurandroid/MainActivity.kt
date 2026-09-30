package com.example.compteurandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewCompteur = findViewById<TextView>(R.id.textViewCompteur)
        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)

        compteur = savedInstanceState?.getInt("compteur") ?: 0
        textViewCompteur.text = compteur.toString()

        buttonIncrementer.setOnClickListener {
            compteur++
            textViewCompteur.text = compteur.toString()
        }
        buttonDecrementer.setOnClickListener {
            compteur--
            textViewCompteur.text = compteur.toString()
        }
        buttonReinitialiser.setOnClickListener {
            compteur = 0
            textViewCompteur.text = compteur.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("compteur", compteur)
    }
}