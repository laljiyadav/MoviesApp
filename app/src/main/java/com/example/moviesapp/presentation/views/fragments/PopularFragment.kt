package com.example.moviesapp.presentation.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.atiyakeithel.presentation.applayer.views.adapters.PopularMovieAdapter
import com.example.moviesapp.R
import com.example.moviesapp.assets.isOnline
import com.example.moviesapp.databinding.FragmentPopularBinding
import com.example.moviesapp.presentation.views.activities.MainActivity
import com.example.moviesapp.presentation.viewmodels.PopularMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularFragment : Fragment() {

    private val TAG = "PopularFragment"
    private lateinit var binding: FragmentPopularBinding
    private  val viewModel: PopularMovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeActivity = activity as MainActivity
        loadData()
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.stateFlowCart.collect{
            if (it.isLoading) {
                homeActivity.showProgressBar()
            } else if (it.error.isNotBlank()) {
                Log.i(TAG, "onViewCreated: "+it.error)
                binding.swiperefresh.isRefreshing=false
                Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
            } else {
                it.data?.let {
                    binding.swiperefresh.isRefreshing=false
                    homeActivity.hideProgressBar()
                    Log.i(TAG, "onViewCreated: " + it)

                    val layoutManager = GridLayoutManager(
                        requireActivity(),
                        2,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    binding.rcvPopular.layoutManager = layoutManager
                    val adapter = PopularMovieAdapter(requireActivity(), it!!.results)
                    binding.rcvPopular.adapter = adapter
                }
            }
          }
        }

        binding.swiperefresh.setOnRefreshListener {
            loadData()
        }

    }

    fun loadData()
    {
        if (isOnline(requireContext())){
            binding.swiperefresh.isRefreshing=true
            viewModel.getPopularMovie()
        }else{
            Toast.makeText(context, getString(R.string.check_you_internet_connection), Toast.LENGTH_LONG).show()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = PopularFragment()
    }
}