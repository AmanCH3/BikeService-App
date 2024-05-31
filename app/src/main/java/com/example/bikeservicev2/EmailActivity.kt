package com.example.bikeservicev2

//import RegisterActivity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.bikeservicev2.databinding.ActivityEmailBinding
import com.google.firebase.auth.FirebaseAuth




class EmailActivity : AppCompatActivity() {

    lateinit var emailBinding: ActivityEmailBinding

        var auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        emailBinding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(emailBinding.root)


        emailBinding.ForgotPassword.setOnClickListener{
            val intent = Intent(this@EmailActivity , ForgotAcrivity::class.java)
            startActivity(intent)
        }


        emailBinding.phoneButton2.setOnClickListener {
            val email = emailBinding.editEmailAddress.text.toString()
            val password = emailBinding.editTextTextPassword.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Sign in the user with email and password
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Login in success, update UI with the signed-in user's information
                            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                            // Start the main activity or navigate to the appropriate screen
                            var intent = Intent(this@EmailActivity, DashActivity::class.java)
                            startActivity(intent)
                        } else {
                            // If Login in fails, display a message to the user
                            Toast.makeText(this, "Login failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }








    }
}

