package com.aba.core.ui.listing.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.R
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.extension.show
import com.aba.core.utils.LoadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.include_detail_top_card.*
import kotlinx.android.synthetic.main.item_listing.view.*


class LawyerItemViewHolder(override val containerView: View,
                           private val callback: LawyerListingAdapter.LawyerAdapterCallback
):
    RecyclerView.ViewHolder(containerView), LayoutContainer {


    companion object {
        fun create(
            parent: ViewGroup,
            callback : LawyerListingAdapter.LawyerAdapterCallback
        ): LawyerItemViewHolder = LawyerItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_listing, parent, false
                ), callback
        )
    }

    fun bindView(item: LawyerDomainModel){
        itemView.itemLawyerName.text = item.firstName
        itemView.itemSpeciality.text = item.speciality
        itemView.itemRating.text = item.rating.toString() ?: ""
        itemView.itemRate.text = item.rate.toString() ?: ""
        itemView.itemIsVerified.show(item.isBackgroundVerified)
        LoadImage.loadImage(itemView.itemImageView, item)
        itemView.itemContainer.setOnClickListener {
            callback.onLawyerItemClicked(item)
        }
    }

}