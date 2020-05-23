package com.example.admin.animations.constraint

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import androidx.appcompat.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_multi_fab.*

class MultiFabActivity : AppCompatActivity() {

    private val csOld by lazy { ConstraintSet() }
    private val csNew by lazy { ConstraintSet() }
    private var activated = false

    companion object {
        fun newIntent(context: Context) = Intent(context, MultiFabActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_fab)

        init()
    }

    private fun init() {
        csOld.clone(parentLayout)
        csNew.clone(this, R.layout.activity_multi_fab_alt)
    }

    fun swapLayout(view: View) {
        activated = !activated
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            val changeBounds = ChangeBounds()
//            changeBounds.interpolator = DecelerateInterpolator()
            TransitionManager.beginDelayedTransition(parentLayout)
        }
        if (activated) {
            csNew.applyTo(parentLayout)
        } else {
            csOld.applyTo(parentLayout)
        }
    }

}
