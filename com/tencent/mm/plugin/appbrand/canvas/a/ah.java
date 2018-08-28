package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public final class ah implements d {
    public final String getMethod() {
        return "setTextBaseline";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        x.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[]{optString});
        if ("top".equalsIgnoreCase(optString)) {
            fVar.fnf.fns = a.fnx;
            fVar.fng.fns = a.fnx;
        } else if ("middle".equalsIgnoreCase(optString)) {
            fVar.fnf.fns = a.fnz;
            fVar.fng.fns = a.fnz;
        } else if ("bottom".equalsIgnoreCase(optString)) {
            fVar.fnf.fns = a.fny;
            fVar.fng.fns = a.fny;
        } else if ("normal".equalsIgnoreCase(optString)) {
            fVar.fnf.fns = a.fnw;
            fVar.fng.fns = a.fnw;
        }
        return true;
    }
}
