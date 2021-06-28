package com.example.admin.animations.constraint.motion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_motion_layout.*

class MotionLayoutActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MotionLayoutActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)

        btnBasic.setOnClickListener { startActivity(BasicMotionLayoutActivity.newIntent(this)) }
        btnBasic2.setOnClickListener { startActivity(BasicMotionLayout2Activity.newIntent(this)) }
        btnKeyFrameSet.setOnClickListener { startActivity(KeyFrameSetActivity.newIntent(this)) }
        btnCoordinatorLayout.setOnClickListener { startActivity(CoordinatorLayoutWithMotionLayoutActivity.newIntent(this)) }
        btnImageSaturation.setOnClickListener { startActivity(ImageSaturationActivity.newIntent(this)) }
        btnCoordinatorLayout2.setOnClickListener { startActivity(CoordinatorLayoutWithMotionLayout2Activity.newIntent(this)) }
        btnParallax.setOnClickListener { startActivity(MotionParallaxActivity.newIntent(this)) }
    }
}
