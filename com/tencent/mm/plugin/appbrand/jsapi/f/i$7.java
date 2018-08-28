package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class i$7 implements m {
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ i fSE;
    final /* synthetic */ b fSG;

    i$7(i iVar, JSONObject jSONObject, b bVar) {
        this.fSE = iVar;
        this.fHi = jSONObject;
        this.fSG = bVar;
    }

    public final void onMapLoaded() {
        x.i("MicroMsg.JsApiInsertMap", "onMapLoaded");
        float f = bi.getFloat(this.fHi.optString("centerLatitude"), 0.0f);
        float f2 = bi.getFloat(this.fHi.optString("centerLongitude"), 0.0f);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            x.e("MicroMsg.JsApiInsertMap", "[onMapLoaded] centerLatitude or centerLongitude value is error!");
            return;
        }
        this.fSG.b((double) f, (double) f2, this.fHi.optInt("scale", 16));
    }
}
