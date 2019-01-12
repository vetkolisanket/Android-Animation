package com.example.admin.animations

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var toggleWithoutAnimation = true

    private var toggleWithAnimation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btnWithoutAnimation.setOnClickListener {
            if (toggleWithoutAnimation) {
                tvWithoutAnimation.hide()
            } else {
                tvWithoutAnimation.show()
            }
            toggleWithoutAnimation = !toggleWithoutAnimation;
        }

        btnWithAnimation.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(llWithAnimation)
            }
            if (toggleWithAnimation) {
                tvWithAnimation.hide()
            } else {
                tvWithAnimation.show()
            }
            toggleWithAnimation = !toggleWithAnimation;
        }
    }
}

private fun TextView.show() {
    visibility = View.VISIBLE
}

private fun TextView.hide() {
    visibility = View.GONE
}
