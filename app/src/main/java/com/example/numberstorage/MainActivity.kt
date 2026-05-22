package com.example.numberstorage

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        // Array of size 10
        var numbers = IntArray(10)
        // Counter
        var counter =0
        
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonSave =  findViewById<Button>(R.id.buttonSave)

        buttonSave.setOnClickListener {
            // check if array is full
            if (counter<10) {
                // Get number from EditText
                val number = editTextNumber.text.toString().toInt()
                // Store number in array
                numbers[counter]=number
                // Increase counter
                counter++

                Toast.makeText(this,
                    "Number saved",
                    Toast.LENGTH_SHORT).show()
            }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}