package com.example.admin.animations.coordinator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_custom_behavior.*

class CustomBehaviorActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, CustomBehaviorActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_behavior)
        setSupportActionBar(toolbarCustomBehavior)

        init()
    }

    private fun init() {
        btnCustomBehavior.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}
