package com.example.admin.animations

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun init() {
        btnWithWithoutAnimation.setOnClickListener { startActivity(WithWithoutAnimationActivity.newIntent(this)) }
        btnSlide.setOnClickListener { startActivity(SlideActivity.newIntent(this)) }
        btnExplode.setOnClickListener { startActivity(ExplodeActivity.newIntent(this)) }
        btnChangeImageTransform.setOnClickListener { startActivity(ChangeImageTransformActivity.newIntent(this)) }
        btnPathMotion.setOnClickListener { startActivity(PathCurvedMotionActivity.newIntent(this)) }
        btnActivitySceneTransition.setOnClickListener {
            val animation = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, btnActivitySceneTransition,
                            btnActivitySceneTransition.transitionName)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                startActivity(ActivitySceneTransitionActivity.newIntent(this), animation.toBundle())
            }
        }
        btnTransitionName.setOnClickListener { startActivity(TransitionNameActivity.newIntent(this)) }
    }
}
