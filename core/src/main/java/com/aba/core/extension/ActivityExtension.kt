package com.aba.core.extension

import android.graphics.PorterDuff
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aba.core.R


fun AppCompatActivity.makeFullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
    supportActionBar?.apply {
        hide()
    }
}

fun AppCompatActivity.changeUpArrow(){
    val upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
    upArrow?.let {
        it.setColorFilter(
            ContextCompat.getColor(
                this,
                android.R.color.black
            ), PorterDuff.Mode.SRC_ATOP
        )
        supportActionBar?.setHomeAsUpIndicator(it)
    }

}
