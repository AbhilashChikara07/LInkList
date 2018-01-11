package com.example.chikara.linklist.SingleCircularList

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/8/18.
 */

class SingleCircularActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_link_list_layout)

        findViewById<Button>(R.id.mInsertNodeAtEnd).setOnClickListener(this)
        findViewById<Button>(R.id.mInsertNodeAtMid).setOnClickListener(this)
        findViewById<Button>(R.id.mLinkListInsertion).setOnClickListener(this)
        findViewById<Button>(R.id.mInsertNodeAtBeginning).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.mLinkListInsertion -> {
                val intent = Intent(this,
                        InsertNode::class.java)
                startActivity(intent)
            }

            R.id.mInsertNodeAtBeginning -> {
                val intent = Intent(this,
                        InsertFirstNode::class.java)
                startActivity(intent)
            }

            R.id.mInsertNodeAtEnd -> {
                val intent = Intent(this,
                        InsertLatNode::class.java)
                startActivity(intent)
            }

            R.id.mInsertNodeAtMid -> {
                val intent = Intent(this,
                        InsertAtMid::class.java)
                startActivity(intent)
            }
        }
    }

}