package com.podlodka.crew.movies.flutter

import android.app.Activity
import android.content.Context
import com.podlodka.crew.movies.flutter.views.FlutterMyVideoViewFactory
import com.podlodka.crew.movies.flutter.views.FlutterYoutubeVideoViewFactory
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class FlutterWorker(context: Context) {
    init {
        val flutterEngine = FlutterEngine(context)

        flutterEngine
            .platformViewsController
            .registry
            .run {
                registerViewFactory("FlutterYoutubeVideoView", FlutterYoutubeVideoViewFactory())
                registerViewFactory("FlutterMyVideoView", FlutterMyVideoViewFactory())
            }


        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        FlutterEngineCache
            .getInstance()
            .put("main_engine", flutterEngine)
    }

    fun startActivity(currentActivity: Activity) {
        val builder = FlutterActivity.CachedEngineIntentBuilder(CustomFlutterActivity::class.java, "main_engine")

        currentActivity.startActivity(
            builder.build(currentActivity)
        )

//        currentActivity.startActivity(
//            FlutterActivity
//                .withCachedEngine("main_engine")
//                .build(currentActivity)
//        )
    }
}