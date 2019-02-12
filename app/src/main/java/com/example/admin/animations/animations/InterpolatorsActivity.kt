package com.example.admin.animations.animations

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_interpolators.*

class InterpolatorsActivity : AppCompatActivity() {

    var isAnimated = false

    companion object {
        fun newIntent(context: Context) = Intent(context, InterpolatorsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolators)

        init()
    }

    private fun init() {
        btnAnimate.setOnClickListener {
            animatePB(pbLinear, LinearInterpolator())
        }
    }

    private fun animatePB(progressBar: ProgressBar, interpolator: TimeInterpolator) {
        val animation = ObjectAnimator.ofInt(progressBar, "progress", getStart(), getEnd())
        animation.duration = 1000
        animation.interpolator = interpolator
        animation.start()

        isAnimated = !isAnimated
    }

    private fun getEnd(): Int {
        if (isAnimated) {
            return 0
        }
        return 100
    }

    private fun getStart(): Int {
        if (isAnimated) {
            return 100
        }
        return 0
    }
}
