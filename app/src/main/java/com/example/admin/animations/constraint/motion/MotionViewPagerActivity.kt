package com.example.admin.animations.constraint.motion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.admin.animations.R
import com.example.admin.animations.custom.ViewPagerAdapter
import com.example.admin.animations.custom.ViewPagerHeader
import kotlinx.android.synthetic.main.activity_motion_view_pager.*

class MotionViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_view_pager)
        init()
    }

    private fun init() {
        val viewPagerHeader = findViewById<ViewPagerHeader>(R.id.motionLayout)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addPage("Page 1", R.layout.fragment_page)
        adapter.addPage("Page 2", R.layout.fragment_page)
        adapter.addPage("Page 3", R.layout.fragment_page)
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        if (viewPagerHeader != null) {
            pager.addOnPageChangeListener(viewPagerHeader)
        }

        val debugMode = if (intent.getBooleanExtra("showPaths", false)) {
            MotionLayout.DEBUG_SHOW_PATH
        } else {
            MotionLayout.DEBUG_SHOW_NONE
        }
        viewPagerHeader.setDebugMode(debugMode)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MotionViewPagerActivity::class.java)
    }

}