package com.example.moviesapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity: AppCompatActivity() {
    private  val TAG = "BaseActivity"
    protected var google_progress: LinearLayoutCompat? = null
    protected var toolbar: Toolbar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpProgressBar()
    }

    public fun setUpProgressBar()
    {
        if (google_progress==null)
        {
            google_progress=findViewById(R.id.google_progress)
        }
    }

    public fun showProgressBar()
    {
        google_progress?.visibility= View.VISIBLE
    }

    public fun hideProgressBar()
    {
        google_progress?.visibility= View.GONE
    }

    protected fun setUpToolbar(title:String)
    {
        if (toolbar==null)
        {
            toolbar=findViewById(R.id.toolbar)
            var toolbarTextView: TextView =findViewById(R.id.act_name)
            toolbarTextView.text=title
            setSupportActionBar(toolbar)
            supportActionBar?.title=null
            // add back arrow to toolbar
            if (supportActionBar != null) {
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}