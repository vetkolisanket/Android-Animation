package com.example.admin.animations.utils

import android.view.View
import android.widget.TextView

/**
 * Created by Sanket on 14/01/19.
 */

public fun TextView.show() {
    visibility = View.VISIBLE
}

public fun TextView.hide() {
    visibility = View.GONE
}