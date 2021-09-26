package com.example.tokyotravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class configuration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)
        btonRegresar()
    }

    fun btonRegresar(){
        val btnToOne: Button = findViewById(R.id.buttonDetalles)

        btnToOne.setOnClickListener {
            val intentr = Intent(applicationContext, MainActivity::class.java)
            startActivity(intentr)
        }
    }


}