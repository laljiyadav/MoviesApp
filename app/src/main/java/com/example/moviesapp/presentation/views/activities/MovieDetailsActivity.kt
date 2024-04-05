package com.example.moviesapp.presentation.views.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.moviesapp.BaseActivity
import com.example.moviesapp.R
import com.example.moviesapp.assets.IMAGE_BASE_URL
import com.example.moviesapp.dataLayer.models.movieDetails.Genre
import com.example.moviesapp.databinding.ActivityMovieDetailsBinding
import com.example.moviesapp.presentation.viewmodels.MainActivityViewModel
import com.example.moviesapp.presentation.viewmodels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailsActivity : BaseActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var viewModel:MovieDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        viewModel= ViewModelProvider(this).get(MovieDetailsViewModel::class.java);
        binding.viewModel=viewModel
        binding.lifecycleOwner=this
        setUpToolbar("Movie Details")
        setUpProgressBar()
        var movieId=intent.extras!!.getInt("id")
        viewModel.getMovieDetails(movieId.toString())

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stateFlowCart.collect{
                    if (it.isLoading) {
                        showProgressBar()
                    } else if (it.error.isNotBlank()) {
                        Toast.makeText(this@MovieDetailsActivity, it.error, Toast.LENGTH_LONG).show()
                    } else {
                        hideProgressBar()
                        binding.txtMovieName.setText(it.data!!.title)
//                        var genres = arrayOf<String>()
//                        for (index in it.data.genres.indices)
//                        {
//                            genres[index]=it.data.genres.get(index).name
//                        }
                        binding.txtDate.setText(it.data.release_date.plus(" • ").plus(getGenres(it.data.genres)).plus(" • ").plus(it.data.runtime))
                        Glide.with(this@MovieDetailsActivity).load(IMAGE_BASE_URL.plus(it.data.poster_path)).error(R.drawable.ic_launcher_background).into(binding.img)
                        binding.txtContentOverview.setText(it.data.overview)

                    }
                }

            }
        }
    }

    fun getGenres(genres: List<Genre>):String{
        if (genres.isNotEmpty())
        {
            var genresList=ArrayList<String>()
            for (genresName in genres)
            {
                genresList.add(genresName.name)
            }

            return genresList.toString().substring(1,genresList.toString().length-1)
        }
        return "Action"
    }
}