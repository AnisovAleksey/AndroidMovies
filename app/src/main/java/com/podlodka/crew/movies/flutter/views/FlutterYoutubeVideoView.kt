package com.podlodka.crew.movies.flutter.views

import android.content.Context
import android.view.View
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import io.flutter.plugin.platform.PlatformView

class FlutterYoutubeVideoView(context: Context, videoId: String) :
    PlatformView {
    private val youtubePlayerView = YouTubePlayerView(context)

    override fun getView(): View {
        return youtubePlayerView
    }

    override fun dispose() {}

    init {
        youtubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }
}