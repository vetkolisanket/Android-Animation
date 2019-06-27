package com.example.admin.animations.custom

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.animations.R

class CustomViewsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent  = Intent(context, CustomViewsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_views)
    }
}
