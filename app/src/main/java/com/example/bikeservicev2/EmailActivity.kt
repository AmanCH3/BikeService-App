package com.example.bikeservicev2

//import RegisterActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
//        emailBinding.phoneButton2.setOnClickListener {
//            val intent = Intent(this@EmailActivity, RegisterActivity::class.java)
//            startActivity(intent)
//        }


        var email = emailBinding.editEmailAddress.text.toString()
        var password = emailBinding.editTextTextPassword.text.toString()







    }
}
