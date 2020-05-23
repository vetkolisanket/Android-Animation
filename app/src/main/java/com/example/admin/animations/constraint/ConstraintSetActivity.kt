package com.example.admin.animations.constraint

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import androidx.appcompat.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_constraint_set.*

class ConstraintSetActivity : AppCompatActivity() {

    private val csOld = ConstraintSet()
    private val csNew = ConstraintSet()
    private var alt = false

    companion object {
        fun newIntent(context: Context) = Intent(context, ConstraintSetActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set)

        init()
    }

    private fun init() {
        csOld.clone(parentLayout)
        csNew.clone(this, R.layout.activity_constraint_set_alt)
    }

    fun swapLayout(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val changeBounds = ChangeBounds()
            changeBounds.interpolator = DecelerateInterpolator()
            TransitionManager.beginDelayedTransition(parentLayout, changeBounds)
        }
        if (alt.not()) {
            csNew.applyTo(parentLayout)
        } else {
            csOld.applyTo(parentLayout)
        }
        alt = !alt
    }

}
