package com.aba.core.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.R
import com.aba.core.domain.data.LawyerDomainModel
import kotlinx.android.extensions.LayoutContainer



class SpaceViewHolder(override val containerView: View):
    RecyclerView.ViewHolder(containerView), LayoutContainer {


    companion object {
        fun create(
            parent: ViewGroup
        ): SpaceViewHolder = SpaceViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_space, parent, false
                )
        )
    }

}