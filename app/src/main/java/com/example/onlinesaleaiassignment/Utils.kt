package com.example.onlinesaleaiassignment

import android.app.Activity
import android.view.animation.Animation
import android.widget.TextView

object Utils {

    fun TextView.shakeView(shakeAnimation: Animation) {
        startAnimation(shakeAnimation)
        requestFocus()
    }


}