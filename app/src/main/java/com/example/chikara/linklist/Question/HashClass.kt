package com.example.chikara.linklist.Question

import java.util.LinkedList

class HashClass {

    var primeNo: Int = 10000000 + 9
    var list: ArrayList<LinkedList<PairClass>> = ArrayList()


    fun hashFunction(key: String): Int {
        var initialValue = 0
        for (i in key.indices) {
            initialValue = ((key[i].toInt()) * i + initialValue) % primeNo;
        }
        return initialValue
    }


    class PairClass {
        var key: String? = null
        var value: Int? = null
    }

}