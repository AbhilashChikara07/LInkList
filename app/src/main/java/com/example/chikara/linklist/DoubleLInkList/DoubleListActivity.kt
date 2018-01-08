package com.example.chikara.linklist.DoubleLInkList

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/3/18.
 */

class DoubleListActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.double_link_list)

        findViewById<Button>(R.id.mDeleteMidNode).setOnClickListener(this)
        findViewById<Button>(R.id.mDeleteLastNode).setOnClickListener(this)
        findViewById<Button>(R.id.mInsertNodeAtPos).setOnClickListener(this)
        findViewById<Button>(R.id.mInsertNodeAtEnd).setOnClickListener(this)
        findViewById<Button>(R.id.mDeleteFirstNode).setOnClickListener(this)
        findViewById<Button>(R.id.mDeleteFirstNode).setOnClickListener(this)
        findViewById<Button>(R.id.mDeleteFirstNode).setOnClickListener(this)
        findViewById<Button>(R.id.mLinkListInsertion).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.mLinkListInsertion -> {
                val intent = Intent(this,
                        DoubleListInsertElement::class.java)
                startActivity(intent)
            }

            R.id.mInsertNodeAtEnd -> {
                val intent = Intent(this,
                        DoubleListInsertAtEnd::class.java)
                startActivity(intent)
            }

            R.id.mInsertNodeAtPos -> {
                val intent = Intent(this,
                        DoubleInsertElementAtPosition::class.java)
                startActivity(intent)
            }

            R.id.mDeleteFirstNode -> {
                val intent = Intent(this,
                        DoubleDeleteFirstElement::class.java)
                startActivity(intent)
            }

            R.id.mDeleteLastNode -> {
                val intent = Intent(this,
                        DoubleDeleteLastNode::class.java)
                startActivity(intent)
            }

            R.id.mDisplayMidNode -> {
                val intent = Intent(this,
                        DoubleListInsertNodeAtMid::class.java)
                startActivity(intent)
            }

            R.id.mDeleteMidNode -> {
                val intent = Intent(this,
                        DoubleDeletePositionNode::class.java)
                startActivity(intent)
            }
        }
    }

}