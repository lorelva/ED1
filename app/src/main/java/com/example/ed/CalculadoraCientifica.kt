package com.example.ed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

class CalculadoraCientifica : AppCompatActivity() {

    private lateinit var txtResult: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_cientifica)

        txtResult = findViewById<TextView>(R.id.txtResult)


        val buttons = listOf<Button>(
            findViewById(R.id.btnFactorial),
            findViewById(R.id.btnRoot),
            findViewById(R.id.btnExponent),
            findViewById(R.id.btnSquare),
            findViewById(R.id.btnPi),
            findViewById(R.id.btnLog),
            findViewById(R.id.btnClear),
            findViewById(R.id.btnDelete),
            findViewById(R.id.btnDivide),
            findViewById(R.id.btnMultiply),
            findViewById(R.id.btnSubtract),
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnEquals),
            findViewById(R.id.btnDecimal),
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )

        for (button in buttons) {
            button.setOnClickListener {
                onButtonClick(button)
            }
        }
    }

    fun onButtonClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        when {
            buttonText == "!" -> {
                val input = txtResult.text.toString().toDouble()
                val result = factorial(input)
                displayResult(result)
            }
            buttonText == "√" -> {
                val input = txtResult.text.toString().toDouble()
                val result = sqrt(input)
                displayResult(result)
            }
            buttonText == "^" -> {
                operand1 = txtResult.text.toString().toDouble()
                operator = buttonText
                txtResult.text = ""
            }
            buttonText == "x^2" -> {
                val input = txtResult.text.toString().toDouble()
                val result = input.pow(2)
                displayResult(result)
            }
            buttonText == "π" -> {
                val result = PI
                displayResult(result)
            }
            buttonText == "ln" -> {
                val input = txtResult.text.toString().toDouble()
                val result = ln(input)
                displayResult(result)
            }
            buttonText == "C" -> {
                clearInput()
            }
            buttonText == "⌫" -> {
                deleteLastDigit()
            }
            buttonText == "/" -> {
                operand1 = txtResult.text.toString().toDouble()
                operator = buttonText
                txtResult.text = ""
            }
            buttonText == "*" -> {
                operand1 = txtResult.text.toString().toDouble()
                operator = buttonText
                txtResult.text = ""
            }
            buttonText == "-" -> {
                operand1 = txtResult.text.toString().toDouble()
                operator = buttonText
                txtResult.text = ""
            }
            buttonText == "+" -> {
                operand1 = txtResult.text.toString().toDouble()
                operator = buttonText
                txtResult.text = ""
            }
            buttonText == "=" -> {
                operand2 = txtResult.text.toString().toDouble()
                val result = performCalculation()
                displayResult(result)
            }
            buttonText == "." -> {
                val currentText = txtResult.text.toString()
                if (!currentText.contains(".")) {
                    txtResult.append(buttonText)
                }
            }
            else -> {
                txtResult.append(buttonText)
            }
        }
    }

    private fun displayResult(result: Double) {
        txtResult.text = result.toString()
    }

    private fun performCalculation(): Double {
        return when (operator) {
            "/" -> operand1 / operand2
            "*" -> operand1 * operand2
            "-" -> operand1 - operand2
            "+" -> operand1 + operand2
            "^" -> operand1.pow(operand2)
            else -> 0.0
        }
    }

    private fun clearInput() {
        operand1 = 0.0
        operand2 = 0.0
        operator = null
        txtResult.text = ""
    }

    private fun deleteLastDigit() {
        val currentText = txtResult.text.toString()
        if (currentText.isNotEmpty()) {
            txtResult.text = currentText.substring(0, currentText.length - 1)
        }
    }

    private fun factorial(n: Double): Double {
        return if (n == 0.0 || n == 1.0) {
            1.0
        } else {
            n * factorial(n - 1)
        }
    }


}