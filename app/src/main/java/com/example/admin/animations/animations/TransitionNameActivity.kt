package com.example.admin.animations.animations

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.widget.TextView
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_transition_name.*

class TransitionNameActivity : AppCompatActivity() {

    var titles = arrayListOf<String>("1", "2", "3", "4", "5")

    companion object {
        fun newIntent(context: Context) = Intent(context, TransitionNameActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_name)

        init()
    }

    private fun init() {
        createViews()

        btnShuffle.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(llTransitionName)
            }
            titles.shuffle()
            createViews()
        }
    }

    private fun createViews() {
        llTransitionName.removeAllViews()

        titles.forEach {
            val textView = LayoutInflater.from(this).inflate(R.layout.text_view, llTransitionName, false) as TextView
            textView.text = """Text View $it"""
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textView.transitionName = it
            }
            llTransitionName.addView(textView)
        }

    }
}
