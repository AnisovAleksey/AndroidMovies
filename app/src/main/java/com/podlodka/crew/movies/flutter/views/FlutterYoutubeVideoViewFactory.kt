package com.podlodka.crew.movies.flutter.views

import android.content.Context
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

internal class FlutterYoutubeVideoViewFactory : PlatformViewFactory(
    StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, id: Int, args: Any?): PlatformView {
        val creationParams = args as Map<String?, Any?>?
        val videoId = creationParams?.get("videoId") as? String ?: throw Exception("YoutubeVideoView should have videoId field")

        return FlutterYoutubeVideoView(context, videoId)
    }
}