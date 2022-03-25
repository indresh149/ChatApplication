package com.example.android.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var googleicon:Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        editName = findViewById(R.id.edit_name)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        btnSignUp = findViewById(R.id.btnSignUp)

//        btnSignUp.setOnClickListener {
//            val name = editName.text.toString()
//            val email = editEmail.text.toString()
//            val password = editPassword.text.toString()
//
//            signUp(name,email,password)
//        }
        btnSignUp.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            finish()
            startActivity(intent)
        }


    }
//    private fun signUp(name:String,email: String ,password: String){
//        // logic of creating user
//        mAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // code for jumping to home
//                        addUserToDatabase(name,email, mAuth.currentUser?.uid!!)
//                    val intent = Intent(this@SignUp, HomePage::class.java)
//                    finish()
//                    startActivity(intent)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Toast.makeText(this@SignUp, "Some error occurred", Toast.LENGTH_SHORT).show()
//                }
//            }
//    }

    private fun addUserToDatabase(name: String, email: String, uid: String){
          mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(name,email,uid))
    }
}