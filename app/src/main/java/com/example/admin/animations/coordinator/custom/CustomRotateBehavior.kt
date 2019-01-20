package com.example.admin.animations.coordinator.custom

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.util.AttributeSet
import android.view.View





/**
 * Created by Sanket on 20/01/19.
 */
class CustomRotateBehavior : CoordinatorLayout.Behavior<View> {

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        return dependency is Snackbar.SnackbarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        val translationY = getFabTranslationYForSnackbar(parent!!, child as FloatingActionButton)
        val percentComplete = -translationY / dependency!!.height
        child.setRotation(180 * percentComplete)
        child.setTranslationY(translationY)
        return false
    }

    private fun getFabTranslationYForSnackbar(parent: CoordinatorLayout,
                                              fab: FloatingActionButton): Float {
        var minOffset = 0f
        val dependencies = parent.getDependencies(fab)
        var i = 0
        val z = dependencies.size
        while (i < z) {
            val view = dependencies[i]
            if (view is Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
                minOffset = Math.min(minOffset,
                        view.translationY - view.height)
            }
            i++
        }

        return minOffset
    }

}