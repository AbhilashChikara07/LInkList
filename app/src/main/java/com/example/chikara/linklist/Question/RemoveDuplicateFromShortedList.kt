package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

class RemoveDuplicateFromShortedList : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
    }

    inner class NodeClass(var tempValue: Int) {
        var data: Int? = null
        var next: NodeClass? = null

        init {
            this.data = tempValue
            next = null
        }
    }

    fun makeList() {

        insertionElement(1)
        insertionElement(1)
        insertionElement(2)
        insertionElement(2)
        insertionElement(3)
        insertionElement(3)
        insertionElement(4)

        removeDuplicateElement_2()

    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            tempHead = head
        } else {
            val mTempHead = NodeClass(tempValue)
            this.tempHead!!.next = mTempHead
            this.tempHead = mTempHead
        }
    }

    /*
    * METHOD 1
    * */
    private fun removeDuplicateElement_1() {
        var mCurrent: NodeClass? = head
        var mTempHead: NodeClass? = null


        while (mCurrent != null) {
            if (mCurrent.data == mCurrent.next?.data) {

                mTempHead = mCurrent.next?.next
                mCurrent.next = null
                mCurrent.next = mTempHead
            } else
                mCurrent = mCurrent.next

        }
        displayValue()
    }


    /*
    * METHOD 2
    * Using HashMap.
    * */
    private fun removeDuplicateElement_2() {
        var mCurrent: NodeClass? = head
        val mHashMap: HashMap<Int?, Int?> = HashMap()


        while (mCurrent != null) {

            if (!mHashMap.contains(mCurrent.data)) {
                mHashMap[mCurrent.data!!] = mCurrent.data
            }

            mCurrent = mCurrent.next
        }
        displayValue()
    }

    private fun displayValue() {
        val sb = StringBuilder()
        var tempNode = head
        while (tempNode != null) {
            sb.append(tempNode.data)
            tempNode = tempNode.next
        }
        (findViewById<TextView>(R.id.displayElement) as TextView).text = sb.toString()
    }

}