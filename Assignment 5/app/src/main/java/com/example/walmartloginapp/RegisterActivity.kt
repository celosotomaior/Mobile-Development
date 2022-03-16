package com.example.walmartloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.walmart.account.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun clear() {
        firstName.text.clear()
        lastName.text.clear()
        username.text.clear()
        password.text.clear()
    }

    fun createAccount(view: View) {
        val firstName = firstName.text.toString()
        val lastName = lastName.text.toString()
        val username = username.text.toString()
        val password = password.text.toString()
        var newUser = User(firstName, lastName, username, password)
        if (firstName != "" && lastName != "" && username != "" && password != "") {
            val intent = intent
            var userList: ArrayList<User>? =
                intent.getSerializableExtra("userList") as ArrayList<User>
            if (userList != null) {
                userList.add(newUser)
                Toast.makeText(this, "Login Now, Account Created Successfully!!", Toast.LENGTH_LONG)

                val intentObject = Intent(this, MainActivity::class.java)
                intentObject.putExtra("userList", userList)
                startActivity(intentObject)
                clear()
            } else {
                Toast.makeText(this, "Create Account Failure!!", Toast.LENGTH_LONG)
            }
        }
    }
}
