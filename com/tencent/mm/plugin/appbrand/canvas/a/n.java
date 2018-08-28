package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class n implements d {
    public final String getMethod() {
        return "rotate";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        canvas.rotate((float) ((((double) ((float) jSONArray.optDouble(0))) / 3.141592653589793d) * 180.0d));
        return true;
    }
}
