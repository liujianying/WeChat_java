package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class ab implements d {
    public final String getMethod() {
        return "setLineWidth";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        float d = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 0);
        fVar.fng.setStrokeWidth(d);
        fVar.fnf.setStrokeWidth(d);
        return true;
    }
}
