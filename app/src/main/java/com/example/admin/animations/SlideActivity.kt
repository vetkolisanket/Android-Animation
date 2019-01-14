package com.example.admin.animations

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_slide.*

class SlideActivity : AppCompatActivity() {

    private var flag = false

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, SlideActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        init()
    }

    private fun init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val slide = Slide()
            slide.slideEdge = Gravity.END
            btnSlide.setOnClickListener {
                TransitionManager.beginDelayedTransition(clParent, slide)
                if (!flag) {
                    tvSlide.show()
                } else {
                    tvSlide.hide()
                }
                flag = !flag
            }
        }
    }
}
