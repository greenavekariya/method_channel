package com.example.methodchannel;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import android.widget.Toast;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "toast";

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("showToast")) {
                                String message = call.argument("message");
                                showToast(message);
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
