package com.example.admin.animations.constraint

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.animations.R

class MultiFabActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MultiFabActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_fab)
    }
}
