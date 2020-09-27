package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class PreFixToInfix : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        preFixToInfix("*-A/BC-/AKL".reversed())
    }

    private fun getOperatorResult(char: String): Boolean {
        return char == "+" || char == "-" || char == "*" || char == "/" || char == "^"
    }

    private fun preFixToInfix(prefixValue: String) {
        var resultString = ""
        val stack = Stack<String>()
        for (i in prefixValue.indices) {
            val char = prefixValue[i].toString()
            if (getOperatorResult(char)) {
                val first = stack.pop()
                val second = stack.pop()
                resultString += "($first$char$second)"
                stack.push(resultString)
            } else {
                stack.push(char)
            }
        }
        return
    }

}