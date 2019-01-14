package com.example.admin.animations

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_explode.*


class ExplodeActivity : AppCompatActivity() {

    private lateinit var adapter: ExplodeAdapter

    companion object {
        fun newIntent(context: Context) = Intent(context, ExplodeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explode)

        init()
    }

    private fun init() {
        initViews()
    }

    private fun initViews() {
        val list = mutableListOf<String>()
        for (i in 1..20) {
            list.add(i.toString())
        }
        adapter = ExplodeAdapter(list, object : ExplodeAdapter.Callback {
            override fun onItemClick(itemView: View) {
                explode(itemView)
            }
        })
        rvExplode.adapter = adapter
        btnExplode.setOnClickListener {
            val viewRect = Rect()
            rvExplode.getGlobalVisibleRect(viewRect)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // create Explode transition with epicenter
                val explode = Explode()
                explode.epicenterCallback = object : Transition.EpicenterCallback() {
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return viewRect
                    }
                }
                explode.duration = 1000
                TransitionManager.beginDelayedTransition(rvExplode, explode)
            }
            rvExplode.adapter = adapter }
    }

    private fun explode(itemView: View) {
        // save rect of view in screen coordinates
        val viewRect = Rect()
        itemView.getGlobalVisibleRect(viewRect)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // create Explode transition with epicenter
            val explode = Explode()
            explode.epicenterCallback = object : Transition.EpicenterCallback() {
                override fun onGetEpicenter(transition: Transition): Rect {
                    return viewRect
                }
            }
            explode.duration = 1000
            TransitionManager.beginDelayedTransition(rvExplode, explode)
        }

        // remove all views from Recycler View
        rvExplode.adapter = null
    }
}
