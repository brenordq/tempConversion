/*
 * Name: Breanna Gonzalez
 * Date: November 22, 2026
 * Assignment: Temperature Conversion Application
 */

package com.example.temperatureconversion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect UI components
        val etTemperature = findViewById<EditText>(R.id.etTemperature)
        val rbFtoC = findViewById<RadioButton>(R.id.rbFtoC)
        val rbCtoF = findViewById<RadioButton>(R.id.rbCtoF)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val inputStr = etTemperature.text.toString().trim()

            // Check if input is empty
            if (inputStr.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature value.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputTemp = inputStr.toDoubleOrNull()
            if (inputTemp == null) {
                Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (rbFtoC.isChecked) {
                // Enforce Fahrenheit bounds: Min -100, Max 250
                if (inputTemp < -100.0 || inputTemp > 250.0) {
                    Toast.makeText(
                        this,
                        "Fahrenheit must be between -100°F and 250°F.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    // Formula: (°F - 32) * 5/9
                    val celsius = (inputTemp - 32.0) * (5.0 / 9.0)
                    tvResult.text = String.format("Converted Value: %.2f °C", celsius)
                }
            } else if (rbCtoF.isChecked) {
                // Enforce Celsius bounds: Min -75, Max 125
                if (inputTemp < -75.0 || inputTemp > 125.0) {
                    Toast.makeText(
                        this,
                        "Celsius must be between -75°C and 125°C.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    // Formula: (°C * 9/5) + 32
                    val fahrenheit = (inputTemp * (9.0 / 5.0)) + 32.0
                    tvResult.text = String.format("Converted Value: %.2f °F", fahrenheit)
                }
            }
        }
    }
}