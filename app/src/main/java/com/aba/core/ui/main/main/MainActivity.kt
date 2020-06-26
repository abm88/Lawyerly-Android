package com.aba.core.ui.main.main

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aba.core.R
import com.aba.core.base.BaseActivity
import com.aba.core.extension.makeFullScreen
import com.aba.core.ui.main.main.list.ListingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewPagerAdapter: ListingAdapter by lazy {
        ListingAdapter(activity = this)
    }

    override val contentResourceId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBottomNavigation()
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(this.tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.featured)
                1 -> tab.text =  getString(R.string.all)
                2 -> tab.text = getString(R.string.favorites)
                else -> tab.text = getString(R.string.favorites)
            }
        }.attach()

    }

    private fun initializeBottomNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.mainBottomNavigation)
        bottomNavigation.setOnNavigationItemReselectedListener {
            // Do Nothing
        }
    }

    private fun initViewPager() {
        viewPager.adapter = viewPagerAdapter
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else {
            super.onBackPressed()
        }

    }

    fun navigateTo(fragment: Fragment) = supportFragmentManager.beginTransaction()
        .add(R.id.mainActivityContainer, fragment).commit()
}
