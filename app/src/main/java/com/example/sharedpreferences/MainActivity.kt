package com.example.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fmanager=supportFragmentManager
        var ftransaction=fmanager.beginTransaction()
        ftransaction.add(R.id.frame1,LoginFrag())
    }
}
