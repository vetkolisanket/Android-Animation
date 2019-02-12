package com.example.admin.animations.animations

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.*
import android.widget.ProgressBar
import com.example.admin.animations.R
import com.example.admin.animations.custom.CustomSpringInterpolator
import kotlinx.android.synthetic.main.activity_interpolators.*

class InterpolatorsActivity : AppCompatActivity() {

    var isLinearAnimated = false
    var isAccelerateAnimated = false
    var isDecelerateAnimated = false
    var isAccelerateDecelerateAnimated = false
    var isAnticipateAnimated = false
    var isOvershootAnimated = false
    var isAnticipateOvershootAnimated = false
    var isBounceAnimated = false
    var isCustomSpringAnimated = false

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
            animatePB(pbLinear, LinearInterpolator(), isLinearAnimated)
            animatePB(pbAccelerate, AccelerateInterpolator(), isAccelerateAnimated)
            animatePB(pbDecelerate, DecelerateInterpolator(), isDecelerateAnimated)
            animatePB(pbAccelerateDecelerate, AccelerateDecelerateInterpolator(), isAccelerateDecelerateAnimated)
            animatePB(pbCycle, CycleInterpolator(1.5F), false)
            animatePB(pbAnticipate, AnticipateInterpolator(), isAnticipateAnimated)
            animatePB(pbOvershoot, OvershootInterpolator(), isOvershootAnimated)
            animatePB(pbAnticipateOvershoot, AnticipateOvershootInterpolator(), isAnticipateOvershootAnimated)
            animatePB(pbBounce, BounceInterpolator(), isBounceAnimated)
            animatePB(pbCustomSpring, CustomSpringInterpolator(0.3f), isCustomSpringAnimated)

            toggleIsAnimated()
        }
    }

    private fun toggleIsAnimated() {
        isLinearAnimated = !isLinearAnimated
        isAccelerateAnimated = !isAccelerateAnimated
        isDecelerateAnimated = !isDecelerateAnimated
        isAccelerateDecelerateAnimated = !isAccelerateDecelerateAnimated
        isAnticipateAnimated = !isAnticipateAnimated
        isOvershootAnimated = !isOvershootAnimated
        isAnticipateOvershootAnimated = !isAnticipateOvershootAnimated
        isBounceAnimated = !isBounceAnimated
        isCustomSpringAnimated = !isCustomSpringAnimated
    }

    private fun animatePB(progressBar: ProgressBar, interpolator: TimeInterpolator, isAnimated: Boolean) {
        val animation = ObjectAnimator.ofInt(progressBar, "progress", getStart(isAnimated), getEnd(isAnimated))
        animation.duration = 5000
        animation.interpolator = interpolator
        animation.start()
    }

    private fun getEnd(isAnimated: Boolean): Int {
        if (isAnimated) {
            return 25
        }
        return 75
    }

    private fun getStart(isAnimated: Boolean): Int {
        if (isAnimated) {
            return 75
        }
        return 25
    }
}
