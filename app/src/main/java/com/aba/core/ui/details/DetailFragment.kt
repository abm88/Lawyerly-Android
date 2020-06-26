package com.aba.core.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aba.core.R
import com.aba.core.base.BaseFragment


class DetailFragment : BaseFragment() {

    companion object {
        fun newInstance(): DetailFragment = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

}