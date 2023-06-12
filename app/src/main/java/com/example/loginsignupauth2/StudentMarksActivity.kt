package com.example.loginsignupauth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsignupauth2.databinding.ActivityMainBinding
import com.example.loginsignupauth2.databinding.ActivityStudentMarksBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class StudentMarksActivity : AppCompatActivity() {


    private lateinit var binding: ActivityStudentMarksBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentMarksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val searchStudent: String = binding.searchStudentId.text.toString()
            if(searchStudent.isNotEmpty())
            {
                readData(searchStudent)
            }
            else
            {
                Toast.makeText(this, "Please enter a student ID", Toast.LENGTH_SHORT).show()
            }
        }

        binding.dasboardRedirectText.setOnClickListener {
            val intent = Intent(this, StudentDashActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun readData(stdId: String)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("Students")
        databaseReference.child(stdId).get().addOnSuccessListener {
            if(it.exists())
            {
                val name = it.child("stdName").value
                val marksIas = it.child("iasMarks").value
                val marksItpm = it.child("itpmMarks").value
                val marksMad = it.child("madMarks").value
                val marksMaths = it.child("mathsMarks").value
                val marksSqa = it.child("sqaMarks").value
                Toast.makeText(this, "Results Found", Toast.LENGTH_SHORT).show()
                binding.searchStudentId.text.clear()

                binding.readName.text = name.toString()
                binding.readIas.text = marksIas.toString()
                binding.readItpm.text = marksItpm.toString()
                binding.readMad.text = marksMad.toString()
                binding.readMaths.text = marksMaths.toString()
                binding.readSqa.text = marksSqa.toString()
            }
            else
            {
                Toast.makeText(this, "Student does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }
}