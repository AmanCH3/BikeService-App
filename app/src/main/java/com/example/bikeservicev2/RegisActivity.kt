package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bikeservicev2.databinding.ActivityRegisBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisActivity : AppCompatActivity() {
    lateinit var regisBinding: ActivityRegisBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    data class User(
        val name: String = "",
        val email: String = "",
        val phone: String = "",
        val gender: String = ""
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        regisBinding = ActivityRegisBinding.inflate(layoutInflater)
        setContentView(regisBinding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        regisBinding.Finishbutton.setOnClickListener {
            val name = regisBinding.fullnameSign.text.toString()
            val email = regisBinding.editTextTextEmailAddress.text.toString()
            val phone = regisBinding.phoneSign.text.toString()
            val gender = regisBinding.spinner.selectedItem.toString()
            val password = intent.getStringExtra("password") ?: ""

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && gender.isNotEmpty()) {
                createUser(email, password, name, phone, gender)
            } else {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createUser(email: String, password: String, name: String, phone: String, gender: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val newUser = User(name, email, phone, gender)
                    db.collection("users").document(user!!.uid).set(newUser)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@RegisActivity, DashActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Failed to store user data", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
