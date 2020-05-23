package com.example.admin.animations.custom

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_custom_views.*

class CustomViewsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent  = Intent(context, CustomViewsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_views)

        init()
    }

    private fun init() {
        btnPollView.setOnClickListener { startActivity(PollViewActivity.newIntent(this)) }
    }
}
