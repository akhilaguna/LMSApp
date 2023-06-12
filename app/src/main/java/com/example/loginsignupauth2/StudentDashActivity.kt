package com.example.loginsignupauth2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginsignupauth2.databinding.ActivityAdminBinding
import com.example.loginsignupauth2.databinding.ActivityStudentDashBinding

class StudentDashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoutText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.logoutImage.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.marksText.setOnClickListener {
            val intent = Intent(this, StudentMarksActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.marksImage.setOnClickListener {
            val intent = Intent(this, StudentMarksActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.lecturesText.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://nsbm365-my.sharepoint.com/:f:/g/personal/aigunawardena_students_nsbm_ac_lk/EroBL3iGG1hJupiqvJYMY4wBq5ho0hagwYWBQDecQ5UMDA?e=i0R3OX"))
            startActivity(intent)
        }

        binding.lecturesImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://nsbm365-my.sharepoint.com/:f:/g/personal/aigunawardena_students_nsbm_ac_lk/EroBL3iGG1hJupiqvJYMY4wBq5ho0hagwYWBQDecQ5UMDA?e=i0R3OX"))
            startActivity(intent)
        }

        binding.scheduleText.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://nsbm365-my.sharepoint.com/:x:/g/personal/aigunawardena_students_nsbm_ac_lk/EbcoIJ5zBTBBnu0xTcW0CKsBfwREDS-yUMO_kckSa8sUXQ?e=NIOUid"))
            startActivity(intent)
        }

        binding.scheduleImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://nsbm365-my.sharepoint.com/:x:/g/personal/aigunawardena_students_nsbm_ac_lk/EbcoIJ5zBTBBnu0xTcW0CKsBfwREDS-yUMO_kckSa8sUXQ?e=NIOUid"))
            startActivity(intent)
        }

    }
}