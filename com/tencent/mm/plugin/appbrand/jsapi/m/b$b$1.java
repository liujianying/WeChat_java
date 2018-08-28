package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.hardware.SensorManager;
import com.tencent.mm.plugin.appbrand.jsapi.m.b.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class b$b$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ b fYj;

    b$b$1(b bVar, l lVar) {
        this.fYj = bVar;
        this.fCl = lVar;
    }

    public final boolean i(Object... objArr) {
        x.v("MicroMsg.JsApiEnableCompass", "onAction.");
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, b.a(this.fYj), b.b(this.fYj));
        SensorManager.getOrientation(fArr2, fArr);
        Map hashMap = new HashMap();
        float toDegrees = (float) Math.toDegrees((double) fArr[0]);
        if (toDegrees < 0.0f) {
            toDegrees += 360.0f;
        }
        hashMap.put("direction", Float.valueOf(toDegrees));
        this.fYj.fYi.x(hashMap);
        return f.ajz().a(this.fYj.fYi, this.fCl);
    }
}
