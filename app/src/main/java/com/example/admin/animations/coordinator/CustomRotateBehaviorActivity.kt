package com.example.admin.animations.coordinator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.admin.animations.R

import kotlinx.android.synthetic.main.activity_custom_rotate_behavior.*

class CustomRotateBehaviorActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, CustomRotateBehaviorActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_rotate_behavior)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
