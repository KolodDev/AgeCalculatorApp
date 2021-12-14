package com.kolodadev.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            calculateAge()
        }
    }

    private fun calculateAge() {
        val calendar = Calendar.getInstance()
        val y = editYear.text.toString()
        val cYear = calendar.get(Calendar.YEAR)

        // حساب العمر
        var YearOB = cYear - y.toInt()

        showAge.text = "عمرك $YearOB سنة "

    }
}