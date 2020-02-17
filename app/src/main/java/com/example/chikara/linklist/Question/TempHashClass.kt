package com.example.chikara.linklist.Question

import java.util.*
import java.util.LinkedList

class TempHashClass {
    var primeNo = 10000000 * 9
    var list: ArrayList<LinkedList<HashKeyValueClass>> = ArrayList()

    fun put(key: String) {
        val hashValue = getHashValue(key)
        val linkedList = LinkedList<HashKeyValueClass>()
        linkedList.add(HashKeyValueClass(hashValue))
        list.add(linkedList)
    }

    fun getHashValue(key: String): Int {
        var finalValue: Int = 0
        for (i in key.length) {
            finalValue = (finalValue + key[i].toInt() * i) % primeNo
        }
        return finalValue
    }

    class HashKeyValueClass {
        var key: Int? = null
        var value:S
    }
}