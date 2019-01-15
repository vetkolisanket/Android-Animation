package com.example.admin.animations

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_change_image_transform.*



class ChangeImageTransformActivity : AppCompatActivity() {

    var expanded = false

    companion object {
        fun newIntent(context: Context) = Intent(context, ChangeImageTransformActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_image_transform)

        init()
    }

    private fun init() {
        ivChangeImageTransform.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                expanded = !expanded

                TransitionManager.beginDelayedTransition(clParent, TransitionSet()
                        .addTransition(ChangeBounds())
                        .addTransition(ChangeImageTransform()))

                val layoutParams = ivChangeImageTransform.layoutParams
                layoutParams.height = if (expanded)
                    ViewGroup.LayoutParams.MATCH_PARENT
                else
                    ViewGroup.LayoutParams.WRAP_CONTENT

                layoutParams.width = if (expanded)
                    ViewGroup.LayoutParams.MATCH_PARENT
                else
                    ViewGroup.LayoutParams.WRAP_CONTENT

                ivChangeImageTransform.layoutParams = layoutParams

                ivChangeImageTransform.scaleType = if (expanded)
                    ImageView.ScaleType.CENTER_CROP
                else
                    ImageView.ScaleType.FIT_CENTER

            };
        }
    }
}
