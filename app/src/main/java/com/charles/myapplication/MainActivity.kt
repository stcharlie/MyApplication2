package com.charles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        private const val Tag = "MAIN"

        val username = "admin"
        val password = "admin"

        private lateinit var usernameInput: EditText
        private lateinit var passwordInput: EditText
        private lateinit var submitButton: Button

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.userNameInput)
        passwordInput = findViewById(R.id.passwordInput)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {  }
        val username = usernameInput.text.toString()
        val password = passwordInput.text.toString()
        login(username, password)

    }

    private fun login(username: String, password: String) {
        if (isValidCredential(username, password)) {
            val intent: Intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name", username)
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidCredential(username: String, password: String): Boolean {
        if (username == username && password == password) return true
        return false
    }
}