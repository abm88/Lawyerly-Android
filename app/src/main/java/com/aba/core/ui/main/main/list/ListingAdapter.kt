package com.aba.core.ui.main.main.list

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aba.core.ui.listing.FragmentType
import com.aba.core.ui.listing.LawyerListingFragment
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ListingAdapter @Inject constructor(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    companion object {
        const val ITEM_COUNT = 3
    }

    override fun getItemCount() =
        ITEM_COUNT

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> LawyerListingFragment.newInstance(FragmentType.ALL)
        1 -> LawyerListingFragment.newInstance(FragmentType.FEATURED)
        2 -> LawyerListingFragment.newInstance(FragmentType.FAVORITE)
        else -> {
            throw IllegalArgumentException("Unknown Type")
        }

    }

}