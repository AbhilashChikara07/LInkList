package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R
import java.util.*

class PreFixToPostFixConversion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        val infixExpression = convertInToInfixConversion("*+AB-CD".reversed())
        val postfixExpression = convertIntoPostfix(infixExpression)
        findViewById<TextView>(R.id.displayElement).text = postfixExpression
    }
    /*
    * 1- First convert in IN-FIX expression.
    * 2- Then convert this in postfix expression.
    * */


    private fun isOperator(str: String): Boolean {
        return (str == "+" || str == "-" || str == "*" || str == "/" || str == "^")
    }

    private fun convertInToInfixConversion(prefixExpression: String): String {
        val stack = Stack<String>()
        for (i in prefixExpression.indices) {
            val char = prefixExpression[i].toString()
            if (isOperator(char)) {
                val first = stack.pop()
                val second = stack.pop()
                stack.push("($first$char$second)")
            } else
                stack.push(char)
        }
        return stack.pop()
    }

    private fun getOperatorValue(char: Char): Int {
        when (char) {
            '+' -> {
                return 1
            }
            '-' -> {
                return 1
            }
            '*' -> {
                return 2
            }
            '/' -> {
                return 2
            }
            '^' -> {
                return 3
            }
        }
        return 0
    }

    private fun convertIntoPostfix(expression: String): String {
        val stack = Stack<Char>()
        var resultString = ""
        for (i in expression.indices) {
            val char = expression[i]
            if (char.isLetterOrDigit())
                resultString += char
            else if (char == '(')
                stack.push(char)
            else if (char == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    resultString += stack.pop()
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "ERROR"
                else
                    stack.pop()
            } else {
                while (getOperatorValue(char) <= getOperatorValue(stack.peek())) {
                    if (stack.peek() == '(')
                        return "ERROR"
                    resultString += stack.pop()
                }
                stack.push(char)
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "ERROR"
            resultString += stack.pop()
        }
        return resultString
    }
}