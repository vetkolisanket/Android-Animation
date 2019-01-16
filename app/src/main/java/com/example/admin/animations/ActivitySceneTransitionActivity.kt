package com.example.admin.animations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ActivitySceneTransitionActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ActivitySceneTransitionActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_transition)
    }
}
