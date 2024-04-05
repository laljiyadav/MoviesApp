package com.example.moviesapp.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.moviesapp.BaseActivity
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.presentation.viewmodels.MainActivityViewModel
import com.example.moviesapp.presentation.views.adapters.ViewPagerAdapter
import com.example.moviesapp.presentation.views.fragments.UpcomingFragment
import com.example.moviesapp.presentation.views.fragments.PopularFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private  val TAG = "MainActivity"
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java);
        binding.viewModel=viewModel
        binding.lifecycleOwner=this
        viewPager2=binding.pager
        tabLayout=binding.tabLayout
        setUpProgressBar()
        val fragments = listOf(PopularFragment(), UpcomingFragment())

        viewPager2.adapter=ViewPagerAdapter(this,fragments)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            if (position==0)
            {
                tab.text = "Popular Movies"
            }else{
                tab.text = "Latest Movies"
            }

        }.attach()
//        viewModel.getPopularMovie()

//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//
//                viewModel.stateFlowCart.collect{
//                    if (it.isLoading) {
//                        Log.i(TAG, "onCreate: it.isLoading ")
//                    } else if (it.error.isNotBlank()) {
//                        Log.i(TAG, "onCreate: it.error.isNotBlank() ")
//                    } else {
//                        Log.i(TAG, "onCreate: "+it.data!!.page)
//                    }
//                }
//            }
//        }
    }
}