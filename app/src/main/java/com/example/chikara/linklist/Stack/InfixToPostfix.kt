package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class InfixToPostfix : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        val result = infixToPostfix("a+b*(c^d-e)^(f+g*h)-i")

    }

    private fun Prec(char: Char): Int {
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

    private fun infixToPostfix(exp: String): String {
        var resultString = String()
        val stack = Stack<Char>()
        for (i in exp.indices) {
            val c = exp[i]
            if (Character.isLetterOrDigit(c))
                resultString += c;
            else if (c == '(')
                stack.push(c)
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    resultString += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"
                else
                    stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    if (stack.peek() == '(')
                        return "Invalid Expression"
                    resultString += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression"
            resultString += stack.pop();
        }
        return resultString;
    }

}