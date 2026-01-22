package com.example.myapplication.ui.screen.sample.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myapplication.ui.screen.sample.fragment.SampleFragment
import com.example.myapplication.ui.screen.sample.fragment.SecondFragment

class SampleViewPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> SampleFragment.newInstance()
            else -> SecondFragment.newInstance()
        }
    }

    override fun getCount(): Int  = 2
}