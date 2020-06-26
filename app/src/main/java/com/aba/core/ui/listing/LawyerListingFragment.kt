package com.aba.core.ui.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.R
import com.aba.core.base.BaseFragment
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.extension.*
import com.aba.core.network.ResultResponse
import com.aba.core.ui.details.DetailFragment
import com.aba.core.ui.listing.list.LawyerListingAdapter
import com.aba.core.ui.main.main.MainActivity
import kotlinx.android.synthetic.main.fragment_listing.*
import javax.inject.Inject

class LawyerListingFragment : BaseFragment(), LawyerListingAdapter.LawyerAdapterCallback {

    @Inject
    lateinit var adapter: LawyerListingAdapter<RecyclerView.ViewHolder>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by lazy {
        viewModelFactory.create(ListingViewModel::class.java)
    }

    companion object {
        const val LISTING_KEY = "LISTING_KEY"
        fun newInstance(type: FragmentType): LawyerListingFragment =
            LawyerListingFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(LISTING_KEY, type)
                }
            }
    }

    override fun onLawyerItemClicked(item: LawyerDomainModel) {
        activity?.let {
            (it as MainActivity).navigateTo(DetailFragment.newInstance())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_listing, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLiveData(viewModel.lawyerLiveData) {
            processResult(it)
        }
        viewModel.getAllLawyers()
    }

    private fun initView() {
        lawyerList.setupLinearLayout(adapter)
    }

    private fun processResult(it: ResultResponse<List<LawyerDomainModel>>) = when (it) {
        is ResultResponse.Success<*> -> {
            loading.hide()
            adapter.lawyerItems = (it as ResultResponse.Success<List<LawyerDomainModel>>).data
        }

        is ResultResponse.Failure<*> -> {
            loading.show()
            toastIt((it as ResultResponse.Failure<List<LawyerDomainModel>>).error.toString())
        }

        is ResultResponse.Loading<*> -> {
            loading.hide()
        }
    }


}