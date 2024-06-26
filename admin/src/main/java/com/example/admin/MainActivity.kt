package com.example.admin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.admin.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.logout.setOnClickListener {
            firebaseAuth.signOut()

            val intent = Intent().apply {
                setClassName("com.example.attendancefinal", "com.example.attendancefinal.LoginActivity")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish()
        }
        binding.addSubjectButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SubjectAllocationActivity::class.java)
            startActivity(intent)
        }

        binding.addTeacher.setOnClickListener {
            val intent = Intent(this@MainActivity,AddTeacherActivity::class.java )
            startActivity(intent)
        }

        binding.addClassButton.setOnClickListener {
            val intent = Intent(this@MainActivity, addClassActivity::class.java)
            startActivity(intent)
        }
        binding.ViewTeacher.setOnClickListener {
            val intent = Intent(this@MainActivity, ViewTeacherActivity::class.java)
            startActivity(intent)
        }
    }
}