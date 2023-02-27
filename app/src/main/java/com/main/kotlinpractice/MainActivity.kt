package com.main.kotlinpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClick()
    }

    fun initClick(){
        var btnName: Button = findViewById(R.id.btn_name)
        btnName.setOnClickListener{
            toast("点击name")
        }
    }
}