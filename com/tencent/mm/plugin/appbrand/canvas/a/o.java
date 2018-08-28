package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class o implements d {
    public final String getMethod() {
        return "save";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        a aVar = fVar.fnf;
        fVar.fnh.push(fVar.fnf);
        fVar.fnf = fVar.fnf.adp();
        if (fVar.fnf == null) {
            fVar.fnf = aVar;
        }
        aVar = fVar.fng;
        fVar.fni.push(fVar.fng);
        fVar.fng = fVar.fng.adp();
        if (fVar.fng == null) {
            fVar.fng = aVar;
        }
        return true;
    }
}
