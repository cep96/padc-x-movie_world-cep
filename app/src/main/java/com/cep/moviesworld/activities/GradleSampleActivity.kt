package com.cep.moviesworld.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cep.moviesworld.BuildConfig
import com.cep.moviesworld.R
import kotlinx.android.synthetic.main.activity_gradle_sample.*

class GradleSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradle_sample)

        tvHello.text = BuildConfig.MY_ACCOUNT

    }
}