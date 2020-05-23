package com.example.admin.animations.coordinator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_coordinator_layout.*

class CoordinatorLayoutActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, CoordinatorLayoutActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)

        init()
    }

    private fun init() {
        btnFab.setOnClickListener { startActivity(FabActivity.newIntent(this)) }
        btnCustomBehavior.setOnClickListener { startActivity(CustomBehaviorActivity.newIntent(this)) }
        btnCustomRotateBehavior.setOnClickListener { startActivity(CustomRotateBehaviorActivity.newIntent(this)) }
        btnCollapsingToolbar.setOnClickListener { startActivity(ScrollingActivity.newIntent(this)) }
        btnParallax.setOnClickListener { startActivity(ParallaxActivity.newIntent(this)) }
    }
}
