package com.nextin.testassignment.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.slider.Slider
import com.nextin.testassignment.R
import com.nextin.testassignment.databinding.ActivityRefineBinding

class RefineActivity : AppCompatActivity() {


    private val binding : ActivityRefineBinding by lazy{
        ActivityRefineBinding.inflate(layoutInflater)
    }


    private lateinit var slider :Slider
    private val toolbar : Toolbar get() = findViewById(R.id.refineToolbar)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setActionBar()


        slider = findViewById(R.id.slider)

        slider.setLabelFormatter { value ->
            value.toInt().toString()
        }

        val availabilty = arrayOf(
            "Available | Hey Let Us Connect",
            "Away | Stay Discrete And Watch",
            "Busy | Do not Disturb | Will Catch..",
            "SOS | Emergency! Need Assistance"
        )
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,availabilty)

        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun setActionBar(){
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_new_24)
            actionBar.setTitle("Refine")
        }

        toolbar.setNavigationOnClickListener { onBackPressed() }

    }
}