package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bikeservicev2.databinding.ActivityLandingpageBinding


class LandingActivity : AppCompatActivity() {
    lateinit var landingpageBinding: ActivityLandingpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        landingpageBinding = ActivityLandingpageBinding.inflate(layoutInflater)
        setContentView(landingpageBinding.root)

        landingpageBinding.getButton.setOnClickListener{
            var intent = Intent(this, PhoneActivity::class.java)
            startActivity(intent)

        }

    }
}