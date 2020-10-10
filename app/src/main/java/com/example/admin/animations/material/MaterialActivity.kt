package com.example.admin.animations.material

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_material.*

class MaterialActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MaterialActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)

        btnExtendedFAB.setOnClickListener { startActivity(ExtendedFabActivity.newIntent(this)) }
    }
}