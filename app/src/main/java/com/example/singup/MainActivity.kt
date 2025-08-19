package com.example.singup
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnName=findViewById<EditText>(R.id.text1)
        val btnEmail=findViewById<EditText>(R.id.text2)
        val btnPassword=findViewById<EditText>(R.id.text3)
        val signup=findViewById<Button>(R.id.button)
        val login1=findViewById<TextView>(R.id.login)
        signup.setOnClickListener {
            val username = btnName.text.toString()
            val email = btnEmail.text.toString()
            val password = btnPassword.text.toString()
            val user= User(username,email,password)
            database = FirebaseDatabase.getInstance().getReference("User")
            database.child(username).setValue(user)
            if(username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this,"User registered",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Fill all blanks",Toast.LENGTH_SHORT).show()

            }
         }
        login1.setOnClickListener{
            val intent=Intent(this, LoginPage::class.java)
            startActivity(intent)
        }



    }
}