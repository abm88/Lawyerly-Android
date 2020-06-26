package com.aba.core.ui.details

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aba.core.R
import com.aba.core.base.BaseFragment
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.extension.disableHomeUpArrow
import com.aba.core.extension.enableHomeUpArrow
import com.aba.core.extension.show
import com.aba.core.utils.LoadImage
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.include_detail_ranking.*
import kotlinx.android.synthetic.main.include_detail_rating.*
import kotlinx.android.synthetic.main.include_detail_reviews.*
import kotlinx.android.synthetic.main.include_detail_top_card.*
import kotlinx.android.synthetic.main.include_gradient_button.*


class DetailFragment : BaseFragment() {

    companion object {
        const val LAWYER_ITEM = "LAWYER_ITEM"
        fun newInstance(item: LawyerDomainModel): DetailFragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(LAWYER_ITEM, item)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        populateViews()
    }

    override fun onResume() {
        super.onResume()
        enableHomeUpArrow()
    }

    override fun onPause() {
        super.onPause()
        disableHomeUpArrow()
    }

    private fun populateViews() = arguments?.run {
        getParcelable<LawyerDomainModel>(LAWYER_ITEM)?.run {
            detailFirstName.text = firstName
            detailSurName.text = surName
            detailSpecialitye.text = speciality
            itemRate.text = rate.toString()
            if(isBackgroundVerified){
                detailVerifiedTextView.show()
                detailVerified.show()
            }
            LoadImage.loadImage(detailPersonalImage, this)
            detailRating.text = rating.toString()
            detailReview.text = reviews.size.toString()
            detailRanking.text = getString(R.string.rankingString,
                ranking.ranking, ranking.numberOfCandidates)
            memberSinceTextView.text = getString(R.string.member_since, memberSince)
        }
    }

    private fun initView() {
        (ButtonContainer.background as AnimationDrawable).start()
    }

}