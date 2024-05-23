package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bikeservicev2.databinding.ActivityPhoneBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneActivity : AppCompatActivity() {

    lateinit var phoneBinding: ActivityPhoneBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var verificationID: String

    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(auth, credential)
        }

        override fun onVerificationFailed(exception: FirebaseException) {
            Toast.makeText(this@PhoneActivity, "Verification failed: ${exception.message}", Toast.LENGTH_LONG).show()
        }

        override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
            this@PhoneActivity.verificationID = verificationId
            val intent = Intent(this@PhoneActivity, VerificationActivity::class.java).apply {
                putExtra("VerificationID", verificationId)
            }
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        phoneBinding = ActivityPhoneBinding.inflate(layoutInflater)
        setContentView(phoneBinding.root)

        auth = FirebaseAuth.getInstance()

        phoneBinding.phoneNextButton.setOnClickListener {
            val phoneNumber = phoneBinding.editPhone.text.toString()
            if (phoneNumber.isNotEmpty()) {
                sendVerificationCode(phoneNumber)
            } else {
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendVerificationCode(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signInWithPhoneAuthCredential(auth: FirebaseAuth, credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, PasswordActivity::class.java))
                } else {
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}