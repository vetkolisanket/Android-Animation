package com.example.admin.animations.coordinator.custom

import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import android.view.View
import kotlin.math.min


/**
 * Created by Sanket on 20/01/19.
 */
public class CustomMoveUpBehavior : CoordinatorLayout.Behavior<View>() {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        return dependency is Snackbar.SnackbarLayout;
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        val translationY = min(0f, dependency.translationY - dependency.height)
        child.translationY = translationY
        return true
    }

}