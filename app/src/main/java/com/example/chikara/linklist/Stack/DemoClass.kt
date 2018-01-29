package com.example.chikara.linklist.Stack

import android.os.*
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.linklist.R


/**
 * Created by abhilash on 26/1/18.
 */

class DemoClass : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

//        val threadHandler = HandlerThread("NAME")
//        threadHandler.start()
//        val hh = HandlerClass(threadHandler.looper)
//        hh.sendEmptyMessage(33)

        val handlerThread = MyHandlerThread("ABHILASH CHIKARA", Looper.myLooper())
        handlerThread.start()
    }

    private inner class MyHandlerThread(name: String, looper: Looper) : HandlerThread(name) {

        internal var looper: Looper? = null

        init {
            this.looper = looper
        }

        override fun run() {
            Log.e("Run Method-1", "Run Method-1")
            Thread.sleep(1000)
            Log.e("Run Method-2", "Run Method-2")
            Thread.sleep(1000)
            Log.e("Run Method-3", "Run Method-3")
            Thread.sleep(1000)
            Log.e("Run Method-4", "Run Method-4")
            Thread.sleep(1000)

            val hendler = HandlerClass(looper!!)
            hendler.sendEmptyMessage(22)

        }


//        override fun onLooperPrepared() {
//            object : Handler(this.looper) {
//                override fun handleMessage(msg: Message) {
//                    Log.e("Run Method--2", "Run Method---2")
//
//                    // process incoming messages here
//                    // this will run in non-ui/background thread
//                }
//            }
//        }


    }

    private inner class HandlerClass(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message?) {
            Log.e("ssssssss", "sssssssssss")
            super.handleMessage(msg)
            Log.e("message", "" + msg?.what)

            (findViewById<TextView>(R.id.displayElement)).text = "qqqqqqqqqqqqq"

        }
    }
}