package com.example.singup

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Homepage : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_homepage)
       val userName=findViewById<TextView>(R.id.text1)
        val gmail=findViewById<TextView>(R.id.text2)
        val passWord=findViewById<TextView>(R.id.text3)
        val text=findViewById<TextView>(R.id.textView)

        val name=intent.getStringExtra(LoginPage.KEY1)
        val email=intent.getStringExtra(LoginPage.KEY2)
        val password=intent.getStringExtra(LoginPage.KEY3)


        text.text="Welcome $name"
        userName.text="UserName: $name"
        gmail.text="Email: $email"
        passWord.text="Password : $password"
    }
}