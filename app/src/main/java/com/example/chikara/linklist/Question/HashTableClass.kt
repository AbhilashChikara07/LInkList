package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class HashTableClass : AppCompatActivity() {

//    var vv:HashMap<>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun put(key: String, value: Int) {
        var keyHasValue = HashClass().hashFunction(key)
        var tempLinkList = HashClass().list[keyHasValue]
    }

    fun has(key: String): Boolean {
        val hashObj = HashClass()
        val keyHashValue = hashObj.hashFunction(key)
        val list = hashObj.list
        for (i in 0 until list.size) {
            if (keyHashValue == i) {
                return true
            }
        }
        return false
    }


}