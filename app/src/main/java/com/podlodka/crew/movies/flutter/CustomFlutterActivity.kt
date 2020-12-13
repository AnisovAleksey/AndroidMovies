package com.podlodka.crew.movies.flutter

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMethodCodec

// This activity used only for handle `dismissCurrent`.
// No another way to finish activity from outside ¯\_(ツ)_/¯
class CustomFlutterActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val engine = flutterEngine ?: return

        val channel = MethodChannel(
            engine.dartExecutor.binaryMessenger,
            "flutterApp/customNavigation",
            StandardMethodCodec.INSTANCE
        )

        channel.setMethodCallHandler { call, result ->
            when (call.method) {
                "dismissCurrent" -> {
                    finish()
                }
                else -> {
                    result.notImplemented()
                }
            }
        }
    }
}
