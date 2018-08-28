package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.f.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class b$1 implements k {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ b fSC;

    b$1(b bVar, int i, p pVar) {
        this.fSC = bVar;
        this.fKG = i;
        this.fJO = pVar;
    }

    public final void tE(String str) {
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.fKG);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", new Object[]{e});
        }
        h a = aVar.a(this.fJO);
        a.mData = jSONObject.toString();
        a.ahM();
    }
}
