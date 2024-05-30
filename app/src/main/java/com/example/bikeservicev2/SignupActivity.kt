package com.example.bikeservicev2


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bikeservicev2.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    lateinit var signupBinding: ActivitySignupBinding
    var auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         signupBinding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(signupBinding.root)

            signupBinding.signButton.setOnClickListener {
            val password = signupBinding.signPassword.text.toString()
            if(password.isNotEmpty()){
                setPassword(password)
            }else{
                Toast.makeText(applicationContext,"Please enter a password",Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun setPassword(password : String){
        val user = auth.currentUser
        user?.updatePassword(password)
            ?.addOnCompleteListener{
                task ->
                if(task.isSuccessful){
//                    startActivity(Intent(this,RegisterActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Password setting Failed : ${task.exception?.message}"
                    ,Toast.LENGTH_LONG).show()
                }
            }
    }
}

