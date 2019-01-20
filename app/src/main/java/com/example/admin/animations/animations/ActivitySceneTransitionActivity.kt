package com.example.admin.animations.animations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.animations.R

class ActivitySceneTransitionActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ActivitySceneTransitionActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_transition)
    }
}
