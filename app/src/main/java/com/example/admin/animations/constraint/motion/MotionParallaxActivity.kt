package com.example.admin.animations.constraint.motion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R

class MotionParallaxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_parallax)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MotionParallaxActivity::class.java)
    }

}