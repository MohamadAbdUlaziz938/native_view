package com.example.native_view;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

import static io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import static io.flutter.plugin.common.MethodChannel.Result;

import androidx.annotation.NonNull;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class FlutterTextView implements PlatformView, MethodCallHandler {
    private final TextView textView;

    FlutterTextView(Context context, BinaryMessenger messenger, int id) {
        textView = new TextView(context);
        MethodChannel methodChannel = new MethodChannel(messenger, "com.example.native_view/textview_" + id);
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if ("setText".equals(methodCall.method)) {
            setText(methodCall, result);
        } else {
            result.notImplemented();
        }

    }

    private void setText(MethodCall methodCall, Result result) {
        String text = (String) methodCall.arguments;
        textView.setText(text);
        result.success(null);
    }

    @Override
    public void dispose() {
    }
}