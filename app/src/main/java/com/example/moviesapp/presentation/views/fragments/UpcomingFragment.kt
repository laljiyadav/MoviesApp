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
import com.atiyakeithel.presentation.applayer.views.adapters.UpcomingMovieAdapter
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentUpcomingBinding
import com.example.moviesapp.presentation.views.activities.MainActivity
import com.example.moviesapp.presentation.viewmodels.UpcomingMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpcomingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class UpcomingFragment : Fragment() {

    private val TAG = "UpcomingFragment"
    private lateinit var binding: FragmentUpcomingBinding
    private val viewModel:UpcomingMovieViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_upcoming, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeActivity = activity as MainActivity

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUpcomingMovieList()
            viewModel.stateFlow.collect{
                if (it.isLoading) {
                    homeActivity.showProgressBar()
                } else if (it.error.isNotBlank()) {
                    Log.i(TAG, "onViewCreated: "+it.error)
                    Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                } else {
                    it.data?.let {
                        homeActivity.hideProgressBar()
                        Log.i(TAG, "onViewCreated: " + it)

                        val layoutManager = GridLayoutManager(
                            requireActivity(),
                            2,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        binding.rcvUpcoming.layoutManager = layoutManager
                        val adapter = UpcomingMovieAdapter(requireActivity(), it!!.results)
                        binding.rcvUpcoming.adapter = adapter
                    }
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = UpcomingFragment()

    }
}