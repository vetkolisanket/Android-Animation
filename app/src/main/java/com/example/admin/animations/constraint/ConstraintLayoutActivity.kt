package com.example.admin.animations.constraint

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_constraint_layout.*

class ConstraintLayoutActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ConstraintLayoutActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        init()
    }

    private fun init() {
        btnSwapViews.setOnClickListener { startActivity(SwapViewsActivity.newIntent(this)) }
        btnSwapLayouts.setOnClickListener { startActivity(ConstraintSetActivity.newIntent(this)) }
        btnMultiFab.setOnClickListener {
            startActivity(MultiFabActivity.newIntent(this))
        }
        btnMotionLayout.setOnClickListener { startActivity(MotionLayoutActivity.newIntent(this)) }
    }
}
