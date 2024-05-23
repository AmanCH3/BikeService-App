package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import androidx.activity.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bikeservicev2.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity() {

    lateinit var passwordBinding: ActivityPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        passwordBinding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(passwordBinding.root)


        passwordBinding.passwordButton.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }



    }
}

