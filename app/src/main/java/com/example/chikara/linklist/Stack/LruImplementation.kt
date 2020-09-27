package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class LruImplementation : AppCompatActivity() {

    private var head: NodeClass? = null
    private val map = HashMap<Int, NodeClass>()
    private val CACHE_SIZE = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        insertData(1)
        insertData(2)
        insertData(3)
        insertData(4)
        insertData(5)
        insertData(6)
        insertData(7)
        insertData(8)

    }

    class NodeClass(data: Int) {
        var next: NodeClass? = null
        var data: Int? = null

        init {
            this.data = data
            this.next = null
        }
    }

    private fun insertData(data: Int) {
        if (head == null) {
            val node = NodeClass(data)
            head = node
            map[data] = node
        } else {
            if (map.size < CACHE_SIZE) {
                if (map.containsKey(data)) {
                    // Remove contain element
                    var slow = head
                    var fast = head!!.next
                    if (null != fast) {
                        while (fast?.data != data) {
                            slow = slow?.next
                            fast = fast?.next
                        }
                        slow!!.next = fast.next
                        fast.next = null
                        val node = NodeClass(data)
                        node.next = head
                        head = node
                    } else {
                        val node = NodeClass(data)
                        head = node
                        head!!.next = null
                    }
                } else {
                    val node = NodeClass(data)
                    node.next = head
                    head = node
                    map[data] = node
                }
            } else {
                var slow = head
                var fast = head?.next
                while (null != fast?.next) {
                    slow = slow?.next
                    fast = fast.next
                }
                slow?.next = null
                val node = NodeClass(data)
                node.next = head
                head = node
                map[data] = node
            }
        }
    }

}