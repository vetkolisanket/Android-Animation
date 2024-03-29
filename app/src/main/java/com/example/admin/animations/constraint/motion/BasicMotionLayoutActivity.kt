package com.example.admin.animations.constraint.motion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R

class BasicMotionLayoutActivity : AppCompatActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, BasicMotionLayoutActivity::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_motion_layout_start)
    }
}