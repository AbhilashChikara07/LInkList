package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/8/18.
 */
class DoubleDeleteFirstNode : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.link_list_layout)
        pushNode()
    }

    class NodeClass(tempValue: Int) {
        var value: Int? = null
        var prev: NodeClass? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
        }

    }

    private fun pushNode() {
        for (i in 0..5) {
            insertElement(i)
        }
    }

    private fun insertElement(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            head!!.next = null
            head!!.prev = null
        } else {
            val tempNode = NodeClass(value)
            tempNode.next = head
            tempNode.prev = null
            head = tempNode
        }
    }



}