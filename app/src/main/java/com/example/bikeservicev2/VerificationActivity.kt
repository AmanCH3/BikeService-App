package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bikeservicev2.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {


    lateinit var  verificationBinding: ActivityVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        verificationBinding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(verificationBinding.root)

        var intent = Intent(this, PasswordActivity::class.java)
        startActivity(intent)


    }
}