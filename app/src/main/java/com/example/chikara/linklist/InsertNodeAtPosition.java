package com.example.chikara.linklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by chikara on 12/29/17.
 */

public class InsertNodeAtPosition extends AppCompatActivity {

    private NodeClass head;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_list_layout);
        insertionElement();
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

    private void insertionElement() {
        if (head != null)
            head = null;
        head = new NodeClass(1);
        head.next = new NodeClass(2);
        head.next.next = new NodeClass(3);
        head.next.next.next = new NodeClass(4);
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
            if (count+1 == position) {
                NodeClass insertNode = new NodeClass(8);
                insertNode.next = tempHead.next;
                tempHead.next = insertNode;
                displayValue();
                break;
            }else{
                count = count + 1;
                tempHead = tempHead.next;
            }
        }
    }
}
