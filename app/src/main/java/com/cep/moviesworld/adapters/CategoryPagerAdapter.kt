package com.cep.moviesworld.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cep.moviesworld.fragments.MoviesByCategoryFragment

class CategoryPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{
                MoviesByCategoryFragment()
            }
            1 ->{
                MoviesByCategoryFragment()
            }
            2 ->{
                MoviesByCategoryFragment()
            }
            3 ->{
                MoviesByCategoryFragment()
            }
            4 ->{
                MoviesByCategoryFragment()
            }
            else ->{
                MoviesByCategoryFragment()
            }

        }
    }
}