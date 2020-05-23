package com.example.admin.animations.constraint

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R

class MotionLayoutActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MotionLayoutActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)
    }
}
