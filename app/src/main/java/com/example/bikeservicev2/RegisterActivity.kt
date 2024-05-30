package com.example.bikeservicev2//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.bikeservicev2.DashActivity
//import com.example.bikeservicev2.databinding.ActivityRegisterBinding
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
//
//
//
//class RegisterActivity : AppCompatActivity() {
//
//    data class User(
//        val name: String = "",
//        val email: String = "",
//        val phone: String = "",
//        val gender: String = "",
//        val birthday: String = ""
//    )
//
//    private lateinit var auth: FirebaseAuth
//    private lateinit var db: FirebaseFirestore
//    private lateinit var registerBinding: ActivityRegisterBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(registerBinding.root)
//
//        auth = FirebaseAuth.getInstance()
//        db = FirebaseFirestore.getInstance()
//
//        registerBinding.Finishbutton.setOnClickListener {
//            val name = registerBinding.fullnameSign.text.toString()
//            val email = registerBinding.editTextTextEmailAddress.text.toString()
//            val phone = registerBinding.phoneSign.text.toString()
//            val gender = registerBinding.spinner.toString()
//            val birthday = registerBinding.birthdaySign.text.toString()
//            val password = intent.getStringExtra("password") ?: ""
//
//            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && gender.isNotEmpty() && birthday.isNotEmpty()) {
//                createUser(email, password, name, phone, gender, birthday)
//            } else {
//                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun createUser(email: String, password: String, name: String, phone: String, gender: String, birthday: String) {
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    val user = auth.currentUser
//                    val newUser = User(name, email, phone, gender, birthday)
//                    db.collection("users").document(user!!.uid).set(newUser)
//                        .addOnSuccessListener {
//                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
//                            val intent = Intent(this@RegisterActivity , DashActivity::class.java)
//                            startActivity(intent)
//
//                            // Redirect to another activity or finish registration
//                        }
//                        .addOnFailureListener {
//                            Toast.makeText(this, "Failed to store user data", Toast.LENGTH_SHORT).show()
//                        }
//                } else {
//                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//    }
//}