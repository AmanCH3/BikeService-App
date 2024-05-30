package com.example.bikeservicev2

//import RegisterActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bikeservicev2.databinding.ActivityPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class PasswordActivity : AppCompatActivity() {

    lateinit var passwordBinding: ActivityPasswordBinding
    var auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        passwordBinding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(passwordBinding.root)


        passwordBinding.passwordButton.setOnClickListener {
            val password = passwordBinding.passwordText.text.toString()
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

