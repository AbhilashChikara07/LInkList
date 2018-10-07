package com.example.chikara.linklist.Question;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.chikara.linklist.R;

public class LinkedList extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_list_layout);

        LinkedList L = new LinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 20
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 15);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 28);

//        NodeClass mHead = getOneList(L.head);
//        displayElement(mHead);

//         flatten the list
        L.head = L.flatten(L.head);

        L.printList();

    }

    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }


    class NodeClass {

        int data;
        NodeClass next;

        NodeClass(int data) {
            this.data = data;
            next = null;
        }

    }

    // An utility function to merge two sorted linked lists
    Node merge(Node a, Node b) {


        // if first linked list is empty then second
        // is the answer
        if (a == null) return b;

        // if second linked list is empty then first
        // is the result
        if (b == null) return a;

        // compare the data members of the two linked lists
        // and put the larger one in the result
        Node result;

        Log.e("ROOT-VALUE-A", "" + a.data);
        Log.e("ROOT-VALUE-B", "" + b.data);
        Log.e("---------------------", "------------------");


        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
//            displayElement(result);
        } else {
            result = b;
            result.down = merge(a, b.down);
//            displayElement(result);
        }
        Log.e("RESULT END", "RESULT END");


        return result;

    }


    Node flatten(Node root) {
        if (root == null || root.right == null)
            return root;

        // recur for list on right
        root.right = flatten(root.right);

        // now merge
        root = merge(root, root.right);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    /* Utility function to insert a node at begining of the
       linked list */
    Node push(Node head_ref, int data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }


    private NodeClass getOneList(Node mTempList) {

        NodeClass mTempHead = null;
        NodeClass mHead = null;

        Node mDown = null;
        Node mRight = mTempList;

        mHead = new NodeClass(mRight.data);
        mTempHead = mHead;

        while (mRight != null) {

            if (mRight.down != null) {
                mDown = mRight.down;
                mRight = mRight.right;


                while (mDown != null) {
                    mTempHead.next = new NodeClass(mDown.data);
                    mTempHead = mTempHead.next;
                    mDown = mDown.down;
                }

            }

            if (mRight != null) {
                mTempHead.next = new NodeClass(mRight.data);
                mTempHead = mTempHead.next;

            }

        }
        return mHead;
    }

    private void displayElement(NodeClass tempNode) {
        StringBuilder textValue = new StringBuilder();
        NodeClass tempHead = tempNode;

        while (tempHead != null) {
            textValue.append(tempHead.data + ", ");
            tempHead = tempHead.next;
        }

        Log.e("LIST IS :- ", "" + textValue.toString());

    }

}
