package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af extends a {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            x.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            return;
        }
        float f = c.getWindow().getAttributes().screenBrightness;
        if (f <= 0.0f) {
            f = cx(c);
        }
        x.i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", new Object[]{Float.valueOf(f), Float.valueOf(r2.screenBrightness)});
        Map hashMap = new HashMap();
        hashMap.put("value", Float.valueOf(f));
        lVar.E(i, f("ok", hashMap));
    }

    private static float cx(Context context) {
        float f = 0.0f;
        try {
            return ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            x.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[]{e.getMessage()});
            return f;
        }
    }
}
