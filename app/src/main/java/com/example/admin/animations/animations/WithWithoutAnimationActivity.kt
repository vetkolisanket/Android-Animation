package com.example.admin.animations.animations

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.transition.TransitionManager
import com.example.admin.animations.R
import com.example.admin.animations.utils.hide
import com.example.admin.animations.utils.show
import kotlinx.android.synthetic.main.activity_with_without_animations.*

class WithWithoutAnimationActivity : AppCompatActivity() {

    private var toggleAnimation = true

    companion object {
        @JvmStatic
        fun newIntent(context: Context): Intent = Intent(context, WithWithoutAnimationActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_without_animations)

        init()
    }

    private fun init() {
        btnWithoutAnimation.setOnClickListener {
            toggle()
        }

        btnWithAnimation.setOnClickListener {
            toggle()
        }
    }

    private fun toggle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(llWithAnimation)
        }
        if (toggleAnimation) {
            tvWithAnimation.hide()
            tvWithoutAnimation.hide()
        } else {
            tvWithAnimation.show()
            tvWithoutAnimation.show()
        }
        toggleAnimation = !toggleAnimation
    }
}


