package com.example.moviesapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.presentation.viewmodels.PopularMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    private lateinit var viewModel: PopularMovieViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel= ViewModelProvider(this).get(PopularMovieViewModel::class.java);
        binding.viewModel=viewModel
        binding.lifecycleOwner=this
        viewModel.getPopularMovie()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.stateFlowCart.collect{
                    if (it.isLoading) {
                        Log.i(TAG, "onCreate: it.isLoading ")
                    } else if (it.error.isNotBlank()) {
                        Log.i(TAG, "onCreate: it.error.isNotBlank() ")
                    } else {
                        Log.i(TAG, "onCreate: "+it.data!!.page)
                    }
                }
            }
        }
    }
}