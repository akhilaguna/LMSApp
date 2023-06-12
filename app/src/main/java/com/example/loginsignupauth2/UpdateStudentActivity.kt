package com.example.loginsignupauth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsignupauth2.databinding.ActivityUpdateStudentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateStudentBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.studentNameUpdate.setOnClickListener {

            val studentIdUpdate = binding.studentIdUpdate.text.toString()

            readData(studentIdUpdate)

        }

        binding.updateButton.setOnClickListener {
            val studentIdUpdate = binding.studentIdUpdate.text.toString()
            val studentNameUpdate = binding.studentNameUpdate.text.toString()
            val marksIasUpdate = binding.marksIasUpdate.text.toString()
            val marksItpmUpdate = binding.marksItpmUpdate.text.toString()
            val marksMadUpdate = binding.marksMadUpdate.text.toString()
            val marksMathsUpdate = binding.marksMathsUpdate.text.toString()
            val marksSqaUpdate = binding.marksSqaUpdate.text.toString()

            updateData(studentIdUpdate, studentNameUpdate, marksIasUpdate, marksItpmUpdate, marksMadUpdate, marksMathsUpdate, marksSqaUpdate)
        }

        binding.dasboardRedirectText.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun updateData(id: String, name: String, ias: String, itpm: String, mad: String, maths: String, sqa: String)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("Students")
        val student = mapOf<String, String>(
            "stdName" to name,
            "iasMarks" to ias,
            "itpmMarks" to itpm,
            "madMarks" to mad,
            "mathsMarks" to maths,
            "sqaMarks" to sqa)

        databaseReference.child(id).updateChildren(student).addOnSuccessListener {
            binding.studentIdUpdate.text.clear()
            binding.studentNameUpdate.text.clear()
            binding.marksIasUpdate.text.clear()
            binding.marksItpmUpdate.text.clear()
            binding.marksMadUpdate.text.clear()
            binding.marksMathsUpdate.text.clear()
            binding.marksSqaUpdate.text.clear()

            Toast.makeText(this, "Student updated successfully", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readData(stdId: String)
    {
        Toast.makeText(this, "Please Wait", Toast.LENGTH_LONG).show()
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


                binding.studentNameUpdate.hint = name.toString()
                binding.marksIasUpdate.hint = marksIas.toString()
                binding.marksItpmUpdate.hint = marksItpm.toString()
                binding.marksMadUpdate.hint = marksMad.toString()
                binding.marksMathsUpdate.hint = marksMaths.toString()
                binding.marksSqaUpdate.hint = marksSqa.toString()
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