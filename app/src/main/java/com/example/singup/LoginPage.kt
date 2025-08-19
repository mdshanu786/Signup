package com.example.singup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginPage : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1="com.example.sing" +
                ".KEY1"
        const val KEY2="com.example.sing.KEY2"
        const val KEY3="com.example.sing.KEY3"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val login = findViewById<Button>(R.id.button)
        val userName = findViewById<EditText>(R.id.text1)

        login.setOnClickListener {
            val username = userName.text.toString()
            if (username.isNotEmpty()) {
                readData(username)
            } else {
                Toast.makeText(this,"Please enter Username",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData(username: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("User")
        databaseReference.child(username).get().addOnSuccessListener {
            if (it.exists()){
                val userName=it.child("username").value
                val email=it.child("email").value
                val password=it.child("password").value

                val intent=Intent(this,homepage::class.java)
                intent.putExtra(KEY1,userName.toString())
                intent.putExtra(KEY2,email.toString())
                intent.putExtra(KEY3,password.toString())
                startActivity(intent)

            }else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
            }
        }
    }
}