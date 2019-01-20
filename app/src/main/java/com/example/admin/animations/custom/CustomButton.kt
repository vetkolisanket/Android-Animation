package com.example.admin.animations.custom

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import com.example.admin.animations.coordinator.custom.CustomMoveUpBehavior


/**
 * Created by Sanket on 20/01/19.
 */
@CoordinatorLayout.DefaultBehavior(CustomMoveUpBehavior::class)
class CustomButton : AppCompatButton {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}