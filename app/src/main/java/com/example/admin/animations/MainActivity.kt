package com.example.admin.animations

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import com.example.admin.animations.animations.*
import com.example.admin.animations.constraint.ConstraintLayoutActivity
import com.example.admin.animations.coordinator.CoordinatorLayoutActivity
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

        btnExplode.setOnClickListener { startActivity(ExplodeActivity.newIntent(this), ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()) }

        btnChangeImageTransform.setOnClickListener { startActivity(ChangeImageTransformActivity.newIntent(this), ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()) }

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

        btnCoordinatorLayout.setOnClickListener { startActivity(CoordinatorLayoutActivity.newIntent(this)) }

        btnConstraintLayout.setOnClickListener { startActivity(ConstraintLayoutActivity.newIntent(this)) }

        btnInterpolators.setOnClickListener { startActivity(InterpolatorsActivity.newIntent(this)) }

    }
}
