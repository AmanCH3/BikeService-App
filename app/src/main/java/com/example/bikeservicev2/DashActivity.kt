package com.example.bikeservicev2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bikeservicev2.databinding.ActivityDashBinding

class DashActivity : AppCompatActivity() {
    lateinit var dashBinding: ActivityDashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        dashBinding = ActivityDashBinding.inflate(layoutInflater)
        setContentView(dashBinding.root)


    }
}