package com.example.admin.animations.constraint

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_swap_view.*

class SwapViewsActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, SwapViewsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swap_view)
    }

    fun swapView(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(parentLayout)
        }
        placeholder.setContentId(view.id)
    }

}
