package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class i$2 implements f {
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ c fSD;
    final /* synthetic */ i fSE;

    i$2(i iVar, c cVar, JSONObject jSONObject) {
        this.fSE = iVar;
        this.fSD = cVar;
        this.fHi = jSONObject;
    }

    public final void agL() {
        x.i("MicroMsg.JsApiInsertMap", "onForeground");
        if (this.fSD != null) {
            this.fSD.cS(this.fHi.optBoolean("showLocation"));
        }
    }
}
