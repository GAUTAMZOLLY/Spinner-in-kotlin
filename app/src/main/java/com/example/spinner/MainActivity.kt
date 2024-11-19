package com.example.spinner

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private  lateinit var   binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val listItems  =  listOf(
             "kotlin" ,
             "java" ,
             "Python" ,
             "c" ,
             "c++"
         )
        val arrayAdapter  =  ArrayAdapter(this , android.R.layout.simple_spinner_item , listItems)
         arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         binding.spinner.adapter  =  arrayAdapter
       binding.spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
           @SuppressLint("SuspiciousIndentation")
           override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
              val selectedItem =  parent?.getItemAtPosition(position)
                Toast.makeText(this@MainActivity , "You click :$selectedItem" , Toast.LENGTH_SHORT).show()

           }

           override fun onNothingSelected(parent: AdapterView<*>?) {

           }

       }
    }
}