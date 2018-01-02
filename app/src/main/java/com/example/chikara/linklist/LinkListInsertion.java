package com.example.chikara.linklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chikara on 12/28/17.
 */

public class LinkListInsertion extends AppCompatActivity {
    NodeClass head;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_list_layout);
        insertionElement();
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
        head = null;
        head = new NodeClass(1);
        head.next = new NodeClass(2);
        head.next.next = new NodeClass(3);
        head.next.next.next = new NodeClass(4);
        displayElement();
    }

    private void displayElement() {
        StringBuilder textValue = new StringBuilder();
        NodeClass tempHead = head;
        while (tempHead != null) {
            textValue.append(tempHead.value);
            tempHead = tempHead.next;
        }
        ((TextView) findViewById(R.id.displayElement)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.displayElement)).setText(textValue.toString());
    }
}
