package com.example.loginsignupauth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsignupauth2.databinding.ActivityDeleteStudentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteStudentBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dasboardRedirectText.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.deleteButton.setOnClickListener {
            val stdId = binding.deleteStudent.text.toString()
            if(stdId.isNotEmpty())
            {
                deleteData(stdId)
            }
            else
            {
                Toast.makeText(this, "Enter a phone number", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun deleteData(studentId: String)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("Students")
        databaseReference.child(studentId).removeValue().addOnSuccessListener {
            binding.deleteStudent.text.clear()
            Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show()
        }
    }
}