package com.example.chikara.linklist.Stack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.chikara.linklist.R;

public class ImplementTwoStacksInAnArray extends AppCompatActivity {

    int[] arr = new int[10];
    int top1 = 0;
    int mid = arr.length / 2;
    int top2 = mid + 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_list_layout);
        push_1(1);
        push_1(2);
        push_1(3);
        push_1(4);
        push_1(5);
        push_1(6);

        push_2(7);
        push_2(8);
        push_2(9);
        push_2(10);
        push_2(11);
        push_2(12);

        pop_1();
        pop_1();
        pop_1();
        pop_1();
        pop_1();
        pop_1();

        pop_2();
        pop_2();
        pop_2();
        pop_2();
        pop_2();
        pop_1();
    }

    private void push_1(int data) {
        if (top1 <= mid - 1 && top1 > -1) {
            arr[top1] = data;
            top1 += 1;
        }
    }

    private void push_2(int data) {
        if (top2 < arr.length && top2 >= mid + 1) {
            arr[top2] = data;
            top2 += 1;
        }
    }

    private void pop_1() {
        if (top1 > -1) {
            int deleteData = arr[top1];
            top1 -= 1;
        }
    }

    private void pop_2() {
        if (top2 > mid + 1) {
            int deleteData = arr[top2];
            top2 -= 1;
        }
    }

}
