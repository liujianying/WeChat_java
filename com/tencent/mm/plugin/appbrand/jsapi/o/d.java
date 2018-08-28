package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.View;
import com.tencent.mm.plugin.appbrand.q.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public static void a(View view, JSONObject jSONObject) {
        int i = 1;
        if (view != null && jSONObject != null) {
            int i2;
            float f;
            int vO = f.vO(jSONObject.optString("bgColor"));
            int vO2 = f.vO(jSONObject.optString("borderColor"));
            float a = f.a(jSONObject, "borderRadius", 0.0f);
            float a2 = f.a(jSONObject, "borderWidth", 0.0f);
            if (view instanceof e) {
                e eVar = (e) view;
                eVar.setBgColor(vO);
                eVar.setBorderColor(vO2);
                eVar.setBorderRadius(a);
                eVar.setBorderWidth(a2);
                i2 = 1;
            } else {
                i2 = 0;
            }
            try {
                f = (float) jSONObject.getDouble("opacity");
                if (f >= 0.0f && f <= 1.0f) {
                    view.setAlpha(f);
                    i2 = 1;
                }
            } catch (JSONException e) {
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                view.setPadding(f.a(optJSONArray, 3), f.a(optJSONArray, 0), f.a(optJSONArray, 1), f.a(optJSONArray, 2));
            }
            float optDouble = (float) jSONObject.optDouble("rotate", 0.0d);
            f = (float) jSONObject.optDouble("scaleX", 1.0d);
            float optDouble2 = (float) jSONObject.optDouble("scaleY", 1.0d);
            if (jSONObject.has("rotate")) {
                view.setRotation(optDouble);
                i2 = 1;
            }
            if (jSONObject.has("scaleX")) {
                view.setScaleX(f);
                i2 = 1;
            }
            if (jSONObject.has("scaleY")) {
                view.setScaleY(optDouble2);
            } else {
                i = i2;
            }
            if (i != 0) {
                view.invalidate();
            }
        }
    }
}
