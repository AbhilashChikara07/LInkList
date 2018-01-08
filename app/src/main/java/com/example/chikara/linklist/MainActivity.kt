package com.example.chikara.linklist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.chikara.linklist.DoubleLInkList.DoubleListActivity
import com.example.chikara.linklist.SingleLinkList.*

/**
 * Created by chikara on 12/28/17.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (findViewById<Button>(R.id.mSingleLinkList)).setOnClickListener(this)
        (findViewById<Button>(R.id.mDoubleLinkList)).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mSingleLinkList -> {
                val intent = Intent(this,
                        SingleListActivity::class.java)
                startActivity(intent)
            }
            R.id.mDoubleLinkList -> {
                val intent = Intent(this,
                        DoubleListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}