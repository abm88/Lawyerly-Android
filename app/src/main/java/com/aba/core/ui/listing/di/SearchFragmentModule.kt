package com.aba.core.ui.listing.di

import androidx.recyclerview.widget.RecyclerView
import com.aba.core.di.scope.PerFragment
import com.aba.core.ui.listing.LawyerListingFragment
import com.aba.core.ui.listing.list.LawyerItemViewHolder
import com.aba.core.ui.listing.list.LawyerListingAdapter
import com.aba.core.ui.listing.list.LawyerListingAdapterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class SearchFragmentModule {


    @Provides
    @PerFragment
    fun provideAdapterCallback(callback: LawyerListingFragment): LawyerListingAdapter.LawyerAdapterCallback =
        callback


    @Provides
    @PerFragment
    fun provideLawyerAdapter(adapter: LawyerListingAdapterImpl): LawyerListingAdapter<RecyclerView.ViewHolder> =
        adapter

}
