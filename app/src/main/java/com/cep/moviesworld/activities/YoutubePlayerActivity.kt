package com.cep.moviesworld.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cep.moviesworld.R
import com.cep.moviesworld.utils.GOOGLE_API_KEY
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_youtube_player.*

class YoutubePlayerActivity : AppCompatActivity(), YouTubePlayer.OnInitializedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_player)

        youtubePlayer.initialize(GOOGLE_API_KEY, this)
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youtubePlayer: YouTubePlayer?,
        b: Boolean
    ) {
//        youtubePlayer.loadVideo()
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
    }

    companion object{
        fun newIntent(context: Context): Intent{
            val intent = Intent(context, YoutubePlayerActivity::class.java)
            return intent
        }
    }

}