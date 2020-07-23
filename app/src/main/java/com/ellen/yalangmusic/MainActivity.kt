package com.ellen.yalangmusic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ellen.yalangmusic.activity.Android30Activity
import com.ellen.yalangmusic.activity.Android5Activity
import com.ellen.yalangmusic.activity.Android7Activity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bt1:Button
    private lateinit var bt2:Button
    private lateinit var bt3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bt1).setOnClickListener(this)
        findViewById<Button>(R.id.bt2).setOnClickListener(this)
        findViewById<Button>(R.id.bt3).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.bt1){
            val intent = Intent(MainActivity@this, Android7Activity::class.java)
            startActivity(intent);
        }else if(v!!.id == R.id.bt2){
            val intent = Intent(MainActivity@this, Android5Activity::class.java)
            startActivity(intent);
        }else{
            val intent = Intent(MainActivity@this, Android30Activity::class.java)
            startActivity(intent);
        }
    }

}