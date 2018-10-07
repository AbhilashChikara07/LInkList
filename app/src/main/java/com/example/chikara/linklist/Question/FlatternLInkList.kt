package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class FlatternLInkList : AppCompatActivity() {
    var head: MergeShort.NodeClass? = null
    var tempHead: MergeShort.NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
    }


    class NodeClass {
        var mDown: NodeClass? = null
        var mRight: NodeClass? = null

    }

}