package com.example.admin.animations.constraint.motion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.example.admin.animations.R
import com.example.admin.animations.commons.fragments.FirstFragment
import com.example.admin.animations.commons.fragments.SecondFragment
import com.example.admin.animations.custom.Page
import kotlinx.android.synthetic.main.activity_motion_fragment.*
import kotlin.math.abs

class MotionFragmentActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private var fragment: Fragment? = null
    private var lastProgress = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_fragment)
        if (savedInstanceState == null) {
            fragment = FirstFragment.newInstance().also {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commitNow()
            }
        }

        motionLayout.setTransitionListener(this)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MotionFragmentActivity::class.java)
    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) = Unit

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, progress: Float) {
        if (progress - lastProgress > 0) {
            val atEnd = progress > 0.9
            if (atEnd && fragment is FirstFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(R.animator.show, 0)
                fragment = SecondFragment.newInstance().also {
                    transaction.replace(R.id.container, it).commitNow()
                }
            }
        } else {
            val atStart = progress < 0.9
            if (atStart && fragment is SecondFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(0, R.animator.hide)
                fragment = FirstFragment.newInstance().also {
                    transaction.replace(R.id.container, it).commitNow()
                }
            }
        }
        lastProgress = progress
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) = Unit

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) = Unit

}