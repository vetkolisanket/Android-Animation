package com.example.admin.animations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btnWithWithoutAnimation.setOnClickListener { startActivity(WithWithoutAnimationActivity.newIntent(this)) }
        btnSlide.setOnClickListener { startActivity(SlideActivity.newIntent(this)) }
        btnExplode.setOnClickListener { startActivity(ExplodeActivity.newIntent(this)) }
        btnChangeImageTransform.setOnClickListener { startActivity(ChangeImageTransformActivity.newIntent(this)) }
        btnPathMotion.setOnClickListener { startActivity(PathCurvedMotionActivity.newIntent(this)) }
    }
}
