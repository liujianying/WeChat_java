package com.tencent.mm.plugin.webview.fts.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.bp.a;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static float cx(Context context) {
        float f = 0.0f;
        try {
            return ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            return f;
        }
    }

    public static float cA(Context context) {
        LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        return attributes.screenBrightness < 0.0f ? cx(context) : attributes.screenBrightness;
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

    public static float[] a(JSONObject jSONObject, Context context) {
        float[] fArr = new float[5];
        if (jSONObject.has("x")) {
            fArr[0] = (float) a.fromDPToPix(context, jSONObject.optInt("x"));
        } else {
            fArr[0] = Float.MAX_VALUE;
        }
        if (jSONObject.has("y")) {
            fArr[1] = (float) a.fromDPToPix(context, jSONObject.optInt("y"));
        } else {
            fArr[1] = Float.MAX_VALUE;
        }
        if (jSONObject.has("width")) {
            fArr[2] = (float) a.fromDPToPix(context, jSONObject.optInt("width"));
        } else {
            fArr[2] = Float.MAX_VALUE;
        }
        if (jSONObject.has("height")) {
            fArr[3] = (float) a.fromDPToPix(context, jSONObject.optInt("height"));
        } else {
            fArr[3] = Float.MAX_VALUE;
        }
        fArr[4] = 0.0f;
        return fArr;
    }

    public static int m(JSONObject jSONObject) {
        if (jSONObject.has("visible")) {
            return jSONObject.optBoolean("visible") ? 0 : 1;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static String an(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("playUrl");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                return optJSONArray.getString(0);
            } catch (JSONException e) {
            }
        }
        return "";
    }
}
