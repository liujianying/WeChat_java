package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

public final class a {
    public static int h(Activity activity) {
        if (activity instanceof AppCompatActivity) {
            if (((AppCompatActivity) activity).getSupportActionBar() != null) {
                return ((AppCompatActivity) activity).getSupportActionBar().getHeight();
            }
        } else if (activity.getActionBar() != null) {
            return activity.getActionBar().getHeight();
        }
        return i(activity);
    }

    public static int i(Activity activity) {
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(com.tencent.mm.compatible.a.a.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        if (activity.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        return 0;
    }
}
