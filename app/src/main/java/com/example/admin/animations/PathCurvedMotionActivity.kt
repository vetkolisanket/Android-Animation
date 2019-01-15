package com.example.admin.animations

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_path_curved_motion.*





class PathCurvedMotionActivity : AppCompatActivity() {

    var isReturnAnimation = false

    companion object {
        fun newIntent(context: Context) = Intent(context, PathCurvedMotionActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_curved_motion)

        init()
    }

    private fun init() {
        btnPathMotion.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val changeBounds = ChangeBounds()
                changeBounds.pathMotion = ArcMotion()
                changeBounds.duration = 500
                TransitionManager.beginDelayedTransition(flParent, changeBounds)

                val params = btnPathMotion.layoutParams as FrameLayout.LayoutParams
                params.gravity = if (isReturnAnimation)
                    Gravity.START or Gravity.TOP
                else
                    Gravity.BOTTOM or Gravity.END
                btnPathMotion.layoutParams = params

                isReturnAnimation = !isReturnAnimation
            }
        }
    }
}
