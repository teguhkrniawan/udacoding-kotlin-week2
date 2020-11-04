package com.teguh.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = "user@gmail.com"
        val password = "123456"

        masukBtnLogin.setOnClickListener {

            val emailText = emailLogin.text.toString()
            val passwordText = passwordLogin.text.toString()

            // cek apakah editText kosong atau tidak
            if (emailText.isEmpty() || passwordText.isEmpty()){
                Toast.makeText(applicationContext, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            // jika nilai editext email dan pass == dummy data
            else if (emailText == email && passwordText == password){
                val intent = Intent(this, MemberIdentityActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(applicationContext, "email atau password salah", Toast.LENGTH_SHORT).show()
            }

        }
    }
}