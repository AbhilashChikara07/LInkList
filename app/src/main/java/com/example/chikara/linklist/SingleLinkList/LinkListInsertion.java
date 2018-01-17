package com.example.chikara.linklist.SingleLinkList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.chikara.linklist.R;

/**
 * Created by chikara on 12/28/17.
 */

public class LinkListInsertion extends AppCompatActivity {
    NodeClass head;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_list_layout);
        makeList();
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
        displayElement();
    }

    private void displayElement() {
        StringBuilder textValue = new StringBuilder();
        NodeClass tempHead = head;
        while (tempHead != null) {
            textValue.append(tempHead.value);
            tempHead = tempHead.next;
        }
        ((TextView) findViewById(R.id.displayElement)).setText(textValue.toString());
    }
}
