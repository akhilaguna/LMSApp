package com.example.loginsignupauth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginsignupauth2.databinding.ActivityAddStudentBinding
import com.example.loginsignupauth2.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.mainUpload.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.mainUpdate.setOnClickListener {
            val intent = Intent(this, UpdateStudentActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.mainDelete.setOnClickListener {
            val intent = Intent(this, DeleteStudentActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.logoutText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}