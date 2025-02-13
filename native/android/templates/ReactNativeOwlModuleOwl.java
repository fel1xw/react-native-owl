package com.formidable.reactnativeowl;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = ReactNativeOwlModule.NAME)
public class ReactNativeOwlModule extends ReactContextBaseJavaModule {
    public static final String NAME = "ReactNativeOwl";

    private static final int UI_FLAG_IMMERSIVE = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    public ReactNativeOwlModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public void initialize() {
        hideNavigationBar();
    }

    private void hideNavigationBar() {
        // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        final Activity activity = getCurrentActivity();

        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_IMMERSIVE);
            }
        });
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }
}
