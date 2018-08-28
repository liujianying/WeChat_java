package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class b {
    public static float cA(Context context) {
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        return attributes.screenBrightness < 0.0f ? cx(context) : attributes.screenBrightness;
    }

    private static float cx(Context context) {
        float f = 0.0f;
        try {
            return ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            return f;
        }
    }

    public static String bx(long j) {
        String str;
        if (j < 3600000) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        return simpleDateFormat.format(Long.valueOf(j));
    }
}
