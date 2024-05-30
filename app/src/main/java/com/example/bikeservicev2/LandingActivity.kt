package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bikeservicev2.databinding.ActivityLandingpageBinding


class LandingActivity : AppCompatActivity() {
    lateinit var landingpageBinding: ActivityLandingpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        landingpageBinding = ActivityLandingpageBinding.inflate(layoutInflater)
        setContentView(landingpageBinding.root)
        val button = findViewById<Button>(R.id.loginButton)

        button.setOnClickListener {
            button.background = ContextCompat.getDrawable(this, R.drawable.button_background)
        }

        landingpageBinding.loginButton.setOnClickListener{
            var intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)

        }

    }
}