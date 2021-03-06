package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class ae implements d {
    public final String getMethod() {
        return "setShadow";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float d = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 0);
        float d2 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 1);
        float d3 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            return false;
        }
        int h = com.tencent.mm.plugin.appbrand.q.f.h(optJSONArray);
        fVar.fng.setShadowLayer(d3, d, d2, h);
        fVar.fnf.setShadowLayer(d3, d, d2, h);
        return true;
    }
}
