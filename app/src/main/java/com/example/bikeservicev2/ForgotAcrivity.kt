package com.example.bikeservicev2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bikeservicev2.databinding.ActivityForgotAcrivityBinding

class ForgotAcrivity : AppCompatActivity() {
    lateinit var forgotAcrivityBinding: ActivityForgotAcrivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forgotAcrivityBinding = ActivityForgotAcrivityBinding.inflate(layoutInflater)
        setContentView(forgotAcrivityBinding.root)



    }
}