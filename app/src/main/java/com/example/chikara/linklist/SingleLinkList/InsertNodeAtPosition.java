package com.example.chikara.linklist.SingleLinkList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.chikara.linklist.R;

/**
 * Created by chikara on 12/29/17.
 */

public class InsertNodeAtPosition extends AppCompatActivity {

    private NodeClass head;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_list_layout);
        makeList();
        insertNodeAtPosition(2);
    }

    static class NodeClass {
        int value;
        NodeClass next;

        NodeClass(int tempValue) {
            this.value = tempValue;
            next = null;
        }
    }

    private void makeList() {
        for (int i = 0; i < 5; i++) {
            insertionElement(i);
        }
    }

    private void insertionElement(int value) {
        if (head == null) {
            head = new NodeClass(value);
        } else {
            NodeClass tempNode = new NodeClass(value);
            tempNode.next = head;
            head = tempNode;
        }
        displayValue();
    }

    private void displayValue() {
        StringBuilder sb = new StringBuilder();
        NodeClass tempNode = head;
        while (tempNode != null) {
            sb.append(tempNode.value);
            tempNode = tempNode.next;
        }
        ((TextView) findViewById(R.id.displayElement)).setText(sb.toString());
    }

    private void insertNodeAtPosition(final int position) {
        NodeClass tempHead = head;
        int count = 0;
        while (tempHead != null) {
            if (count + 1 == position) {
                NodeClass insertNode = new NodeClass(8);
                insertNode.next = tempHead.next;
                tempHead.next = insertNode;
                displayValue();
                break;
            } else {
                count = count + 1;
                tempHead = tempHead.next;
            }
        }
    }
}
