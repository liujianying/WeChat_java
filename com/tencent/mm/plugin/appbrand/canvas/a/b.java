package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.c.e.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class b implements d {
    public final String getMethod() {
        return "clip";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.clipPath(a.fnC.d(jSONArray));
        return true;
    }
}
