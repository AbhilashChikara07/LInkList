package com.example.chikara.linklist.Question

class NodeClass {
    var head: NodeClass? = null
    var secondHead: NodeClass? = null

    var data: Int? = null
    var next: NodeClass? = null

    public fun getLinkedList(): NodeClass? {
        for (i in 5 downTo 1) {
            val tempNode = NodeClass()
            tempNode.data = i
            tempNode.next = null

            if (head == null)
                head = tempNode
            else {
                tempNode.next = head
                head = tempNode
            }
        }
        return head
    }

    public fun getSecondLinkList(): NodeClass? {
        for (i in 9 downTo 6) {
            val tempNode = NodeClass()
            tempNode.data = i
            tempNode.next = null

            if (secondHead == null)
                secondHead = tempNode
            else {
                tempNode.next = secondHead
                secondHead = tempNode
            }
        }
        return secondHead
    }
}