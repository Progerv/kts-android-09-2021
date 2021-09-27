package com.khaymoev.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("onCreate ${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart ${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy ${hashCode()}")
    }
}
