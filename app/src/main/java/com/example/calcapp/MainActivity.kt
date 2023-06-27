package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<TextView>(R.id.input)
        val output = findViewById<TextView>(R.id.output)


        findViewById<Button>(R.id.button_clear).setOnClickListener {
            input.text = ""
            output.text = ""
        }
        findViewById<Button>(R.id.button_bracket_left).setOnClickListener {
            input.text = addToInputText(buttonValue = "(")
        }
        findViewById<Button>(R.id.button_bracket_right).setOnClickListener {
            input.text = addToInputText(buttonValue = ")")
        }
        findViewById<Button>(R.id.button_div).setOnClickListener {
            input.text = addToInputText(buttonValue = "÷")
        }
        findViewById<Button>(R.id.button_multiply).setOnClickListener {
            input.text = addToInputText(buttonValue = "×")
        }
        findViewById<Button>(R.id.button_plus).setOnClickListener {
            input.text = addToInputText(buttonValue = "+")
        }
        findViewById<Button>(R.id.button_minus).setOnClickListener {
            input.text = addToInputText(buttonValue = "-")
        }
        findViewById<Button>(R.id.button_1).setOnClickListener {
            input.text = addToInputText(buttonValue = "1")
        }
        findViewById<Button>(R.id.button_2).setOnClickListener {
            input.text = addToInputText(buttonValue = "2")
        }
        findViewById<Button>(R.id.button_3).setOnClickListener {
            input.text = addToInputText(buttonValue = "3")
        }
        findViewById<Button>(R.id.button_4).setOnClickListener {
            input.text = addToInputText(buttonValue = "4")
        }
        findViewById<Button>(R.id.button_5).setOnClickListener {
            input.text = addToInputText(buttonValue = "5")
        }
        findViewById<Button>(R.id.button_6).setOnClickListener {
            input.text = addToInputText(buttonValue = "6")
        }
        findViewById<Button>(R.id.button_7).setOnClickListener {
            input.text = addToInputText(buttonValue = "7")
        }
        findViewById<Button>(R.id.button_8).setOnClickListener {
            input.text = addToInputText(buttonValue = "8")
        }
        findViewById<Button>(R.id.button_9).setOnClickListener {
            input.text = addToInputText(buttonValue = "9")
        }
        findViewById<Button>(R.id.button_0).setOnClickListener {
            input.text = addToInputText(buttonValue = "0")
        }
        findViewById<Button>(R.id.button_decimal).setOnClickListener {
            input.text = addToInputText(buttonValue = ".")
        }
        findViewById<Button>(R.id.button_equals).setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        val input = findViewById<TextView>(R.id.input)
        return "${input.text}$buttonValue"
    }

    private fun showResult() {
        val output = findViewById<TextView>(R.id.output)

        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // show error message
                output.text = "Error: Division by 0"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                //show result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // show error message
            output.text = e.toString()
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    private fun getInputExpression(): String {
        val input = findViewById<TextView>(R.id.input)
        var expression = input.text.replace(Regex(pattern = "÷"), replacement = "/")
        expression = expression.replace(Regex(pattern = "×"), replacement = "*")
        return expression
    }
}
