package com.example.admin.animations.custom

import android.view.animation.Interpolator

/**
 * Created by Sanket on 12/02/19.
 */
@Suppress("unused", "ConvertSecondaryConstructorToPrimary")
class CustomSpringInterpolator: Interpolator {

    var factor = 0.3f

    constructor(factor: Float) {
        this.factor = factor
    }

    override fun getInterpolation(input: Float): Float {
        return (Math.pow(2.0, (-10 * input).toDouble()) * Math.sin(2 * Math.PI * (input - factor / 4) / factor) + 1).toFloat()
    }
}