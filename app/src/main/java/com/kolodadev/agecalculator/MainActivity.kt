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


        editYear.filters = arrayOf(InputFilterMinMax(1,2100))

        btnCalculate.setOnClickListener {
            calculateAge()
        }
    }

    class InputFilterMinMax: InputFilter{
        private var min:Int = 0
        private var max:Int = 0
        constructor(min:Int , max:Int){
            this.min = min
            this.max = max
        }
        constructor(min:String , max:String){
            this.min = Integer.parseInt(min)
            this.max = Integer.parseInt(max)
        }

        override fun filter(
            source: CharSequence,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int): CharSequence? {

            try {
               val input = Integer.parseInt(dest.toString() +source.toString())
               if (isInRange(min,max,input))
                   return null
            }
            catch (nfe:NumberFormatException){}
            return ""
        }

        private fun isInRange(min: Int, max: Int, input: Int): Boolean {
            return if (max > min) input in min..max else input in max..min
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