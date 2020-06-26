package com.aba.core.ui.listing.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.view.SpaceViewHolder
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LawyerListingAdapterImpl @Inject constructor(
    private val callback: LawyerAdapterCallback
) : LawyerListingAdapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_LAWYER = 1
        const val VIEW_TYPE_SPACE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEW_TYPE_LAWYER -> LawyerItemViewHolder.create(parent, callback)
            VIEW_TYPE_SPACE -> SpaceViewHolder.create(parent)
            else -> throw IllegalArgumentException("Unknown view type")
        }

    override fun getItemCount() = if (lawyerItems.size > 0) {
        lawyerItems.size + 1
    } else {
        0
    }

    override fun getItemViewType(position: Int) = when {
        position < lawyerItems.size -> VIEW_TYPE_LAWYER
        position == lawyerItems.size -> VIEW_TYPE_SPACE
        else -> 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        if (position < lawyerItems.size) {
            (holder as LawyerItemViewHolder).bindView(lawyerItems[position])
        } else {
            // Do Nothing
        }

}