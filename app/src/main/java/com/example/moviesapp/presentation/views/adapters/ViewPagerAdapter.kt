package com.example.moviesapp.presentation.views.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.annotation.Nullable
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviesapp.presentation.views.fragments.LatestFragment
import com.example.moviesapp.presentation.views.fragments.PopularFragment

class ViewPagerAdapter (fragmentActivity: FragmentActivity,private val fragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {

        return fragments[position]

    }


}