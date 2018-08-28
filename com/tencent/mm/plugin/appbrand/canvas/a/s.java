package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class s implements d {
    public final String getMethod() {
        return "setFontSize";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        int a = com.tencent.mm.plugin.appbrand.q.f.a(jSONArray, 0);
        fVar.fng.setTextSize((float) a);
        fVar.fnf.setTextSize((float) a);
        return true;
    }
}
