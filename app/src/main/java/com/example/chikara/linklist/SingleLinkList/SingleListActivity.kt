package com.example.chikara.linklist.SingleLinkList

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/3/18.
 */
class SingleListActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        (findViewById<Button>(R.id.mDeleteLastNode)).setOnClickListener(this)
        (findViewById<Button>(R.id.mInsertNodeAtEnd)).setOnClickListener(this)
        (findViewById<Button>(R.id.mInsertNodeAtPos)).setOnClickListener(this)
        (findViewById<Button>(R.id.mDeleteFirstNode)).setOnClickListener(this)
        (findViewById<Button>(R.id.mLinkListInsertion)).setOnClickListener(this)
        (findViewById<Button>(R.id.mDeletePositionNode)).setOnClickListener(this)
        (findViewById<Button>(R.id.mLinkListTraversing)).setOnClickListener(this)
        (findViewById<Button>(R.id.mInsertNodeAtBeginning)).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mLinkListInsertion -> {
                val intent = Intent(this,
                        LinkListInsertion::class.java)
                startActivity(intent)
            }
            R.id.mLinkListTraversing -> {
                val intent = Intent(this,
                        LinkListTraversingElement::class.java)
                startActivity(intent)
            }
            R.id.mInsertNodeAtBeginning -> {
                val intent = Intent(this,
                        InsertionAtBeginning::class.java)
                startActivity(intent)
            }
            R.id.mInsertNodeAtEnd -> {
                val intent = Intent(this,
                        LinkListInsertNodeAtEnd::class.java)
                startActivity(intent)
            }
            R.id.mInsertNodeAtPos -> {
                val intent = Intent(this,
                        InsertNodeAtPosition::class.java)
                startActivity(intent)
            }
            R.id.mDeleteFirstNode -> {
                val intent = Intent(this,
                        DeleteFirstNode::class.java)
                startActivity(intent)
            }
            R.id.mDeleteLastNode -> {
                val intent = Intent(this,
                        DeleteLastNode::class.java)
                startActivity(intent)
            }
            R.id.mDeletePositionNode -> {
                val intent = Intent(this,
                        DeleteLastNode::class.java)
                startActivity(intent)
            }
        }
    }
}