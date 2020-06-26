package com.aba.core.utils

import android.widget.ImageView
import com.aba.core.R
import com.aba.core.domain.data.LawyerDomainModel

object LoadImage {
    fun loadImage(imageView: ImageView, item: LawyerDomainModel) = when{
        (item.id.endsWith("0")) -> imageView.setImageResource(R.drawable.face1)
        (item.id.endsWith("1")) -> imageView.setImageResource(R.drawable.face2)
        (item.id.endsWith("2") ) -> imageView.setImageResource(R.drawable.face3)
        (item.id.endsWith("3") ) -> imageView.setImageResource(R.drawable.face4)
        (item.id.endsWith("4") ) -> imageView.setImageResource(R.drawable.face5)
        (item.id.endsWith("5") ) -> imageView.setImageResource(R.drawable.face1)
        (item.id.endsWith("6") ) -> imageView.setImageResource(R.drawable.face2)
        (item.id.endsWith("7") ) -> imageView.setImageResource(R.drawable.face3)
        (item.id.endsWith("8") ) -> imageView.setImageResource(R.drawable.face4)
        (item.id.endsWith("9") ) -> imageView.setImageResource(R.drawable.face5)
        else -> imageView.setImageResource(R.drawable.face4)
    }
}