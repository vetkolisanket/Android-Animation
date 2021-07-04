package com.example.admin.animations.constraint.motion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_coordinator_layout_with_motion_layout.*

class MotionCoordinatorLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout_with_motion_layout)

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset/appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition
        })
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MotionCoordinatorLayoutActivity::class.java)
    }
}