package com.example.admin.animations.material

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_extended_fab.*

class ExtendedFabActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ExtendedFabActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended_fab)

        extendedFab.setOnClickListener {
            toggleFabExtension()
        }
    }

    private fun toggleFabExtension() {
        if (extendedFab.isExtended) {
            extendedFab.shrink()
        } else {
            extendedFab.extend()
        }
    }
}