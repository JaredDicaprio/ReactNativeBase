//PUT YOUR PACKAGE NAME HERE, IT'S THE SAME AS IN MainApplication.java
package com.reactnativebase;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedStorage extends ReactContextBaseJavaModule {
    ReactApplicationContext context;
    public static final String PREFS_KEY = "DATA";
    public static final String DATA_KEY = "appData";

    public SharedStorage(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    @Override
    public String getName() {
        return "SharedStorage";
    }

    @ReactMethod
    public void set(String data) {
        SharedPreferences.Editor prefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE).edit();
        prefs.putString(DATA_KEY, data);
        prefs.commit();

        //CHANGE TO THE NAME OF YOUR WIDGET
        Intent intent = new Intent(getCurrentActivity().getApplicationContext(), Widget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        //CHANGE TO THE NAME OF YOUR WIDGET
        int[] ids = AppWidgetManager.getInstance(getCurrentActivity().getApplicationContext()).getAppWidgetIds(new ComponentName(getCurrentActivity().getApplicationContext(), Widget.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        getCurrentActivity().getApplicationContext().sendBroadcast(intent);
    }

}