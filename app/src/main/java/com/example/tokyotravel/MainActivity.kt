package com.example.tokyotravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDetalles: Button = findViewById(R.id.buttonD)
        btnDetalles.setOnClickListener{
            val intent : Intent = Intent(applicationContext, activity_list::class.java)
            startActivity(intent)
        }

        val btnConfig: Button = findViewById(R.id.buttonConf)
        btnConfig.setOnClickListener{
            val intentC : Intent = Intent(applicationContext, configuration::class.java)
            startActivity(intentC)
        }

    }
}