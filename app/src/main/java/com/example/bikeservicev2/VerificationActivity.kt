package com.example.bikeservicev2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bikeservicev2.databinding.ActivityVerificationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class VerificationActivity : AppCompatActivity() {


    lateinit var  verificationBinding: ActivityVerificationBinding
    private lateinit var  auth : FirebaseAuth
    private lateinit var  verificationId : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        verificationBinding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(verificationBinding.root)

        auth = FirebaseAuth.getInstance()

        verificationId = intent.getStringExtra("Verification code") ?: ""


      verificationBinding.verifyButton.setOnClickListener {
//          var intent = Intent(this, PasswordActivity::class.java)
//          startActivity(intent)

          val otp = verificationBinding.verificationCode.text.toString()
          if(otp.isNotEmpty()){
              //verifying the otp
              verifyCode(otp)
          }else{
              Toast.makeText(this,"Please enter the OTP",Toast.LENGTH_SHORT).show()
          }
      }


    }

    private fun verifyCode(code :String){
         val credential = PhoneAuthProvider.getCredential(verificationId,code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun  signInWithPhoneAuthCredential(credential : PhoneAuthCredential){
            auth.signInWithCredential(credential)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        val intent = Intent(this,PasswordActivity ::class.java)
                    }
                    else{
                        Toast.makeText(this,"Verification Code",Toast.LENGTH_SHORT).show()
                    }
                }
    }
}