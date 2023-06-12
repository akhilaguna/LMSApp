package com.example.loginsignupauth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsignupauth2.databinding.ActivityAddStudentBinding
import com.example.loginsignupauth2.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val studentId = binding.studentId.text.toString()
            val studentName = binding.studentName.text.toString()
            val marksIas = binding.marksIas.text.toString()
            val marksItpm = binding.marksItpm.text.toString()
            val marksMad = binding.marksMad.text.toString()
            val marksMaths = binding.marksMaths.text.toString()
            val marksSqa = binding.marksSqa.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Students")
            val students = StudentData(studentId, studentName, marksIas, marksItpm, marksMad, marksMaths, marksSqa)

            databaseReference.child(studentId).setValue(students).addOnSuccessListener {
                binding.studentId.text.clear()
                binding.studentName.text.clear()
                binding.marksIas.text.clear()
                binding.marksItpm.text.clear()
                binding.marksMad.text.clear()
                binding.marksMaths.text.clear()
                binding.marksSqa.text.clear()

                Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show()
            }
        }

        binding.dasboardRedirectText.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*binding.saveButton.setOnClickListener {
            val studentID = binding.studentId.text.toString()
            val studentName = binding.studentName.text.toString()
            val marksIas = binding.marksIas.text.toString()
            val marksItpm = binding.marksItpm.text.toString()
            val marksMad = binding.marksMad.text.toString()
            val marksMaths = binding.marskMaths.text.toString()
            val marksSqa = binding.marksSqa.text.toString()

            addStudent(studentID, studentName, marksIas, marksItpm, marksMad, marksMaths, marksSqa)
        }
    }

    fun addStudent(stdId: String, stdName: String, ias: String, itpm: String, mad: String, maths: String, sqa: String)
    {
        val db = FirebaseFirestore.getInstance()
        val student: MutableMap<String, Any> = HashMap()
        student["student_id"] = stdId
        student["student_name"] = stdName
        student["marks_ias"] = ias
        student["marks_itpm"] = itpm
        student["marks_mad"] = mad
        student["marks_maths"] = maths
        student["marks_sqa"] = sqa

        db.collection("students").document(stdId).set(student)
            .addOnSuccessListener {
                Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }*/
    }
}