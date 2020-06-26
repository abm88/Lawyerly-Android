package com.aba.core.ui.listing.list

import androidx.recyclerview.widget.RecyclerView
import com.aba.core.domain.data.LawyerDomainModel


abstract class LawyerListingAdapter<VH: RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {

    var lawyerItems: List<LawyerDomainModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface LawyerAdapterCallback {
        fun onLawyerItemClicked(item: LawyerDomainModel)
    }

}